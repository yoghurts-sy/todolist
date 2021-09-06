package com.geeker.todolist.pojo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class UserTask {
   private Integer task_id;
   private  Integer task_userid;
   private Integer task_type;
   private String task_content;
   private LocalDateTime task_createtime;
   private LocalDateTime task_finishtime;

}
