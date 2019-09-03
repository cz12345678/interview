package com.mao.swagger1.user.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "user", description = "用户对象")
public class User {

    @ApiModelProperty(value = "用户id", name = "userId", example = "001")
    private String userId;

    @ApiModelProperty(value = "用户名", name = "userName", example = "mao2080")
    private String userName;

    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    private String password;

    @ApiModelProperty(value = "邮箱", name = "email", example = "mao2080@sina.com")
    private String email;

    public User() {
        super();
    }

    public User(String userId, String userName, String password, String email) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email + "]";
    }

}
