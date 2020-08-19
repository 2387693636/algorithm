package com.test;

/**
 * @author: zou_xq
 * @description: user
 * @date: 2020/8/19 9:05
 */
public class User {
    private String username;
    private Integer id;


    public String getPawd1() {
        return pawd1;
    }

    public void setPawd1(String pawd1) {
        this.pawd1 = pawd1;
    }

    private String pawd1;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
