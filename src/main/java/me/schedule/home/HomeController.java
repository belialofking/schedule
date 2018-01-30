package me.schedule.home;

import me.schedule.user.UserModel;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Logs;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.ServerRedirectView;

@IocBean
public class HomeController {

    private static final org.nutz.mvc.View MAIN_VIEW = new ServerRedirectView("/main");
    private static final org.nutz.mvc.View LOGIN_VIEW = new ServerRedirectView("/login");

    @Inject
    private Dao dao;

    @At("/login")
    @Ok("jsp:view.login")
    public void login(){
    }

    @At("/loginDo")
    public View loginDo(@Param("username") String username, @Param("password") String password) {
        if (Strings.isBlank(username)) {
            Logs.get().info("用户名不能为空！");
            Mvcs.getHttpSession().setAttribute("login_message", "用户名不能为空！!");
            return LOGIN_VIEW;
        }
        UserModel user = dao.fetch(UserModel.class,username);
        if (user == null || !user.getPassword().equals(password)) {
            Logs.get().info("用户名或密码错误:" + username);
            Mvcs.getHttpSession().setAttribute("login_message", "用户名或密码错误!");
            return LOGIN_VIEW;
        }
        Mvcs.getHttpSession().setAttribute("login_user", user.getLoginName());
        Logs.get().debug("登录成功！");
        return MAIN_VIEW;
    }

    @At("/logout")
    @Ok("redirect:/login")
    public void logout(){
        Mvcs.getHttpSession().invalidate();
    }

    @At
    @Ok("jsp:view.main")
    public void main(){

    }


}
