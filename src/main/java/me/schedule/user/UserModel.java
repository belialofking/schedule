package me.schedule.user;

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

    @Id
    private long id;
    @Name
    @Column("login_name")
    private String loginName;
    @Column("real_name")
    private String realName;
    @Column
    private String password;
    @Column("real_phone")
    private String realPhone;
    @Column("real_email")
    private String realEmail;

}
