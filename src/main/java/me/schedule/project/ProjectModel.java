package me.schedule.project;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Data
@NoArgsConstructor
@Table("tbl_project")
public class ProjectModel {
    @Id
    private long id;
    @Column
    private String title;
    @Column
    private String description;
}
