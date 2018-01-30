package me.schedule.framework;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;

import java.util.ArrayList;
import java.util.List;

@IocBean
public class AuthorityService {


    @Inject
    private Dao dao;

    public boolean hasResource(String userId,String resource){
        if(Strings.isBlank(userId)){
            return false;
        }
        if(Strings.isBlank(resource)){
            return false;
        }
        List<UserRoleModel> userRoleList = dao.query(UserRoleModel.class , Cnd.where("user_id","=",userId));
        if(userRoleList == null || userRoleList.isEmpty()){
            return false;
        }
        List<String> roleIdList = new ArrayList<>();
        for (UserRoleModel model : userRoleList){
            roleIdList.add(model.getRoleId());
        }
        List<RoleResourceModel> roleResourceModelList = dao.query(RoleResourceModel.class,Cnd.where("role_id","in",roleIdList));
        if(roleResourceModelList == null || roleResourceModelList.isEmpty()){
            return false;
        }
        for (RoleResourceModel model : roleResourceModelList){
            if(resource.equals(model.getResourceId())){
                return true;
            }
        }
        return false;
    }


}
