package me.schedule.framework;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Data
@NoArgsConstructor
@Table("tbl_role")
public class RoleModel {
    @Name
    @Column(hump = true)
    private String roleID;
    @Column(hump=true)
    private String roleName;
    @Column(hump=true)
    private String roleDescription;

}
