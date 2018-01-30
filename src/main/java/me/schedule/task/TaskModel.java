package me.schedule.task;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Data
@NoArgsConstructor
@Table("tbl_task")
public class TaskModel {
    @Id
    private long id;
    @Column(hump = true)
    private String taskName;
    @Column(hump = true)
    private int projectId;
    @Column(hump = true)
    private String userId;
    @Column
    private int progress;
    @Column
    private String description;

}
