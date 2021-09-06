package com.geeker.todolist.pojo;

import lombok.Data;

import java.time.LocalDateTime;


public class Task {
    private Integer id;
    private Integer userId;
    private String content;
    private Integer type;   // 0表示未完成的任务，1表示已经完成的任务
    private LocalDateTime createTime;
    private LocalDateTime finishTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }
}
