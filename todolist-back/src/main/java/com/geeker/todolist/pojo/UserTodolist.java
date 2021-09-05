package com.geeker.todolist.pojo;
import lombok.Data;
import java.util.Date;
@Data
public class UserTodolist {
   private int task_id;
   private  int task_userid;
   private  int task_type;
   private String task_content;
   private Date task_createtime;
   private Date task_finishtime;
}
