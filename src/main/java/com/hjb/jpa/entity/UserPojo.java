package com.hjb.jpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_user")
public class UserPojo {

    // 用户编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    // 账号
    @Column(name = "user_name")
    private String userName;
    // 昵称
    @Column(name = "user_nick")
    private String userNick;
    // 密码
    @Column(name = "password")
    private String password;
    // 性别
    @Column(name = "sex")
    private String sex;
    // 生日
    @Column(name = "birthday")
    private Timestamp birthday;
    // 邮箱
    @Column(name = "email")
    private String email;
    // 家庭住址
    @Column(name = "address")
    private String address;
    // 状态, 1:未激活 2:已开启使用
    @Column(name = "state")
    private String state;
    // 创建时间
    @Column(name = "create_time")
    private String createTime;
    // 更新时间
    @Column(name = "update_time")
    private String updateTime;

    public UserPojo() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userNick='" + userNick + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
