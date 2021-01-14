package com.hjb.jpa.entity;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;

@Entity(name = "t_log")
public class LogPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "opt_api")
    private String optApi;
    @Column(name = "opt_time")
    private String optTime;
    @Column(name = "spend_time")
    private long spendTime;

    public LogPojo() {
    }

    public LogPojo(long userId, String optApi, String optTime, long spendTime) {
        this.id = id;
        this.userId = userId;
        this.optApi = optApi;
        this.optTime = optTime;
        this.spendTime = spendTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOptApi() {
        return optApi;
    }

    public void setOptApi(String optApi) {
        this.optApi = optApi;
    }

    public String getOptTime() {
        return optTime;
    }

    public void setOptTime(String optTime) {
        this.optTime = optTime;
    }

    public long getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(long spendTime) {
        this.spendTime = spendTime;
    }

    @Override
    public String toString() {
        return "LogPojo{" +
                "id=" + id +
                ", userId=" + userId +
                ", optApi='" + optApi + '\'' +
                ", optTime=" + optTime +
                ", spendTime='" + spendTime + '\'' +
                '}';
    }
}
