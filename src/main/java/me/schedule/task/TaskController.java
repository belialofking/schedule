package me.schedule.task;

import me.schedule.project.ProjectModel;
import me.schedule.user.UserModel;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import java.util.List;

@IocBean
public class TaskController {
    @Inject
    private Dao dao;

    @At("/task/index")
    @Ok("jsp:view.task.index")
    public void index(@Param("projectId")long projectId,@Param("userId")long userId){
        List<TaskModel> taskList = dao.query(TaskModel.class,null);
        Mvcs.getReq().setAttribute("taskList",taskList);
    }

    @At("/task/add")
    @Ok("jsp:view.task.edit")
    public void add(){
        List<ProjectModel> projectList = dao.query(ProjectModel.class,null);
        List<UserModel> userList = dao.query(UserModel.class,null);
        Mvcs.getReq().setAttribute("projectList",projectList);
        Mvcs.getReq().setAttribute("userList",userList);
        TaskModel model = new TaskModel();
        Mvcs.getReq().setAttribute("task",model);
    }

    @At("/task/edit/?")
    @Ok("jsp:view.task.edit")
    public void edit(int id){
        List<ProjectModel> projectList = dao.query(ProjectModel.class,null);
        List<UserModel> userList = dao.query(UserModel.class,null);
        TaskModel model = dao.fetch(TaskModel.class,id);
        Mvcs.getReq().setAttribute("task",model);
        Mvcs.getReq().setAttribute("projectList",projectList);
        Mvcs.getReq().setAttribute("userList",userList);
    }

    @At("/task/save")
    @Ok(">>:/task/index")
    public void save(@Param("..") TaskModel model){
        if(model.getId() == 0){
            dao.insert(model);
            return;
        }
        dao.update(model);
    }

    @At("/task/remove/?")
    @Ok(">>:/task/index")
    public void remove(int id){
        dao.delete(TaskModel.class,id);
    }

}
