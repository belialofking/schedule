package me.schedule.framework;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Data
@NoArgsConstructor
@Table("tbl_role_resource")
public class RoleResourceModel {
    @Name
    @Column(hump=true)
    private String roleResourceId;
    @Column(hump=true)
    private String roleId;
    @Column(hump=true)
    private String resourceId;
}
