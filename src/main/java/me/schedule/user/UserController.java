package me.schedule.user;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

@IocBean
public class UserController {
    @At("/user/index")
    @Ok("jsp:view.user.index")
    public void index(){
    }
}
