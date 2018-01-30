package me.schedule.framework;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("tbl_resource")
public class ResourceModel {
    @Name
    private String resourceId;
    @Column(hump = true)
    private String resourceTitle;
    @Column(hump = true)
    private String resourceIcon;
    @Column(hump = true)
    private int resourceLevel;
    @Column(hump = true)
    private String parentId;
    @Column(hump = true)
    private String resourceUrl;
}
