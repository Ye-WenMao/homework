package com.fifth.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/****
 * @Author:Anonym
 * @Description:Unchoice构建
 * @Date 2021/11/26 00:00
 *****/
@TableName(value = "unchoice")
public class Unchoice implements Serializable {

    @TableId(value = "id")
    private Integer id;//

    private Integer no;//题号

    private String title;//题干

    private Integer type;//类型

    private String trueAnswer;//正确答案

    private float score;//分数

    private Integer homeworkId;//作业id

    //get方法
    public Integer getId() {
        return id;
    }

    //set方法
    public void setId(Integer id) {
        this.id = id;
    }

    //get方法
    public Integer getNo() {
        return no;
    }

    //set方法
    public void setNo(Integer no) {
        this.no = no;
    }

    //get方法
    public String getTitle() {
        return title;
    }

    //set方法
    public void setTitle(String title) {
        this.title = title;
    }

    //get方法
    public Integer getType() {
        return type;
    }

    //set方法
    public void setType(Integer type) {
        this.type = type;
    }

    //get方法
    public String getTrueAnswer() {
        return trueAnswer;
    }

    //set方法
    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    //get方法
    public float getScore() {
        return score;
    }

    //set方法
    public void setScore(float score) {
        this.score = score;
    }

    //get方法
    public Integer getHomeworkId() {
        return homeworkId;
    }

    //set方法
    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }
}
