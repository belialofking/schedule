package me.schedule.framework;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Logs;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.View;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.ServerRedirectView;


@IocBean
public class AuthorityFilter implements ActionFilter {

    @Inject
    private Dao dao;
    
    private static final View INDEX =  new ServerRedirectView("/main");
    private static final View LOGIN =  new ServerRedirectView("/login");
    private static final View ERROR = new JspView("view.error");



    
    
    @Override
    public View match(ActionContext ac) {
        String serial = ac.getServletContext().getInitParameter("serial");
//        long abort = Long.valueOf(serial, 36);
//        if(System.currentTimeMillis() > abort){
//            Logs.get().info("校验码错误！");
//            return ERROR;
//        }
        //检查用户登录权限
        Authority ma = ac.getMethod().getAnnotation(Authority.class);
        //没用添加标注不做校验
        if(ma == null){
            Logs.get().info("url不需要权限验证!");
            return null;
        }
        Logs.get().info("校验用户登录开始");
        Boolean isLogin = (Boolean)Mvcs.getHttpSession().getAttribute(Constant.__IS_LOGIN__);
        if(!Boolean.TRUE.equals(isLogin)){
            Logs.get().info("用户未登录!");
            return LOGIN;
        }
        if(Strings.isBlank(ma.value())){
            Logs.get().info("只需要登录验证,无需权限验证!");
            return null;
        }
        String loginId = (String)Mvcs.getHttpSession().getAttribute(Constant.__LOGIN_ID__);
        if("super".equals(loginId)){
            return null;
        }
//
//        if(!menuService.check(ma.value(), loginId)){
//            Mvcs.getReq().setAttribute("msg", "校验未通过!");
//            Logs.get().info("校验未通过!");
//            return ERROR;
//        }

        Logs.get().info("校验权限完成!");
        return null;
    }
}
