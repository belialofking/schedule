package me.schedule.framework;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("tbl_user")
public class UserModel {
    @Name
    @Column(hump = true)
    private String userId;
    @Column(hump = true)
    private String loginName;
    @Column(hump = true)
    private String realName;
    @Column
    private String password;
    @Column(hump = true)
    private String realPhone;
    @Column(hump = true)
    private String realEmail;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealPhone() {
        return realPhone;
    }

    public void setRealPhone(String realPhone) {
        this.realPhone = realPhone;
    }

    public String getRealEmail() {
        return realEmail;
    }

    public void setRealEmail(String realEmail) {
        this.realEmail = realEmail;
    }
}
