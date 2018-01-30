package me.schedule.project;

import me.schedule.framework.Authority;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import java.util.List;


@IocBean
public class ProjectController {

    @Inject
    private Dao dao;

    @At("/project/index")
    @Ok("jsp:view.project.index")
    @Authority("project.index")
    public void index(@Param("key")String key){
        Cnd cnd = null;
        if(Strings.isNotBlank(key)){
            cnd = Cnd.where("title","like",key);
        }
        List<ProjectModel> projectList = dao.query(ProjectModel.class,cnd);
        Mvcs.getReq().setAttribute("key",key);
        Mvcs.getReq().setAttribute("projectList",projectList);
    }

    @At("/project/add")
    @Ok("jsp:view.project.edit")
    public void add(){
        ProjectModel model = new ProjectModel();
        Mvcs.getReq().setAttribute("project",model);
    }

    @At("/project/edit/?")
    @Ok("jsp:view.project.edit")
    public void edit(int id){
        ProjectModel model = dao.fetch(ProjectModel.class,id);
        Mvcs.getReq().setAttribute("project",model);
    }

    @At("/project/save")
    @Ok(">>:/project/index")
    public void save(@Param("..") ProjectModel model){
        if(model.getId() == 0){
            dao.insert(model);
            return;
        }
        dao.update(model);
    }

    @At("/project/remove/?")
    @Ok(">>:/project/index")
    public void remove(int id){
        dao.delete(ProjectModel.class,id);
    }

}
