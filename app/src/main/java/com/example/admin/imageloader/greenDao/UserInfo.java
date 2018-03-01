package com.example.admin.imageloader.greenDao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 陈杰 on 2018/2/21.
 */
@Entity
public class UserInfo {
    @Id
    private Long id;
    private String name;
    private String sex;
    private int age;
    private String studentId;

    @Generated(hash = 920490394)
    public UserInfo(Long id, String name, String sex, int age, String studentId) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.studentId = studentId;
    }

    @Generated(hash = 1279772520)
    public UserInfo() {
    }

    public int getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "id:"+id+"name:"+name+"sex:"+sex+"age"+age;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}

