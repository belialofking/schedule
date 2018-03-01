package me.schedule.framework.event;

import com.google.common.eventbus.Subscribe;
import me.schedule.framework.EventListener;
import me.schedule.framework.ResourceModel;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;


@IocBean
public class InitResourceListener implements EventListener {

    @Inject
    private Dao dao;

    private ResourceModel generateResource(String id, String title, String icon, String parent, String url) {
        ResourceModel model = new ResourceModel();
        model.setResourceId(id);
        model.setResourceTitle(title);
        model.setResourceIcon(icon);
        model.setParentId(parent);
        model.setResourceUrl(url);
        return model;
    }

    @Subscribe
    public void init(SystemStartEvent startEvent) {
        //主页rb
        save(dao, generateResource("main", "主页", "ai-home", "main", "/main"));
        //日报管理
        save(dao, generateResource("rb", "任务管理", "ai-wallet", "", ""));
        //项目管理
        save(dao, generateResource("project", "任务管理", "ai-module", "rb", ""));
        save(dao, generateResource("project.index", "项目管理", "ai-module", "project", "/project/index"));
        save(dao, generateResource("task.index", "任务管理", "ai-module", "project", "/task/index"));


    }

    public void save(Dao dao, ResourceModel model) {
        ResourceModel result = dao.fetch(ResourceModel.class, model.getResourceId());
        if (result != null) {
            return;
        }
        dao.insert(model);
    }
}
