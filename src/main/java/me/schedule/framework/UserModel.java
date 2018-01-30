package me.schedule.framework;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Data
@NoArgsConstructor
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

}
