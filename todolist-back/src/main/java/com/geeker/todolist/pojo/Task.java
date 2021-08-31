package com.geeker.todolist.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private Integer id;
    private Integer userId;
    private String content;
    private Integer type;   // 0表示未完成的任务，1表示已经完成的任务
    private LocalDateTime createTime;
    private LocalDateTime finishTime;
}
