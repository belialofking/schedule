package me.schedule;

import com.google.common.eventbus.EventBus;
import me.schedule.framework.EventListener;
import me.schedule.framework.UserModel;
import me.schedule.framework.event.SystemStartEvent;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

public class MainSetup implements Setup {

    public void init(NutConfig conf) {
        Ioc ioc = conf.getIoc();
        Dao dao = ioc.get(Dao.class);
        Daos.createTablesInPackage(dao, "me.schedule", false);
        //Daos.migration(dao, "me.schedule.task", true, true);
        // 初始化默认根用户
        if (dao.count(UserModel.class) == 0) {
            UserModel user = new UserModel();
            //"admin","管理员","123456"
            user.setUserId("super");
            user.setLoginName("admin");
            user.setRealName("管理员");
            user.setPassword("123456");
            dao.insert(user);
        }
        EventBus eventBus = ioc.get(EventBus.class);
        initEventBus(eventBus,ioc);
    }

    private void initEventBus(EventBus eventBus,Ioc ioc){
        for (Class<?> klass : Scans.me().scanPackage("me.schedule")) {
            if(EventListener.class.isAssignableFrom(klass) && klass != EventListener.class) {
                eventBus.register(ioc.get(klass));
            }
        }
        SystemStartEvent sse = SystemStartEvent.factory().setEventName("systemStart").setMsg("hello world!");
        eventBus.post(sse);
    }

    public void destroy(NutConfig conf) {
    }

}
