package me.schedule.framework;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Data
@NoArgsConstructor
@Table("tbl_user_role")
public class UserRoleModel {
    @Name
    @Column(hump = true)
    private String userRoleId;
    @Column(hump=true)
    private String userId;
    @Column(hump=true)
    private String roleId;

}
