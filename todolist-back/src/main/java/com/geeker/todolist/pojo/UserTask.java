package com.geeker.todolist.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserTask {
   private Integer task_id;
   private  Integer task_userid;
   private Integer task_type;
   private String task_content;

   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private LocalDateTime task_createtime;

   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private LocalDateTime task_finishtime;

}
