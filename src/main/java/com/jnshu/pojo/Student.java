package com.jnshu.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
    private long s_id;
    //校验名称需大于1
    //message是提示效验出错显示的信息
    @Length(min = 1,message = "{student.name.length.error}")
    private String s_name;
//    @Range(min = 10010,message = "{student.qq.length}")
    @DecimalMin(value = "10010",message = "{student.qq.length}")
    private long s_qq;
    @Range(min = 1,max = 2,message = "{student.course.notNull}")
    private long s_course;
    //非空效验
    @Range(min = 1,message = "{student.updatetime.notNull}")
    private long update_at;
    private String s_school;
    private String s_link;
    private String s_flag;
    @Range(min = 1,max = 2,message = "{student.brother.notNull}")
    private long s_brother;
    private String s_source;
    @Range(min = 1,message = "{student.creattime.notNull}")
    private long create_at;

    public long getS_id() {
        return s_id;
    }

    public void setS_id(long s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public long getS_qq() {
        return s_qq;
    }

    public void setS_qq(long s_qq) {
        this.s_qq = s_qq;
    }

    public long getS_course() {
        return s_course;
    }

    public void setS_course(long s_course) {
        this.s_course = s_course;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    public String getS_school() {
        return s_school;
    }

    public void setS_school(String s_school) {
        this.s_school = s_school;
    }

    public String getS_link() {
        return s_link;
    }

    public void setS_link(String s_link) {
        this.s_link = s_link;
    }

    public String getS_flag() {
        return s_flag;
    }

    public void setS_flag(String s_flag) {
        this.s_flag = s_flag;
    }

    public long getS_brother() {
        return s_brother;
    }

    public void setS_brother(long s_brother) {
        this.s_brother = s_brother;
    }

    public String getS_source() {
        return s_source;
    }

    public void setS_source(String s_source) {
        this.s_source = s_source;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", s_qq=" + s_qq +
                ", s_course=" + s_course +
                ", update='" + update_at + '\'' +
                ", s_school=" + s_school +
                ", s_link='" + s_link + '\'' +
                ", s_flag='" + s_flag + '\'' +
                ", s_brother=" + s_brother +
                ", s_source='" + s_source + '\'' +
                ", create_at='" + create_at + '\'' +
                '}';
    }
}
