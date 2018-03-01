package me.schedule.framework.event;

import com.google.common.eventbus.Subscribe;
import me.schedule.framework.EventListener;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Logs;


@IocBean
public class InitTableListener implements EventListener {
    @Subscribe
    public void systemStart(SystemStartEvent event){
        Logs.get().info("========================================");
        Logs.get().info(event);
        Logs.get().info("========================================");

    }
}
