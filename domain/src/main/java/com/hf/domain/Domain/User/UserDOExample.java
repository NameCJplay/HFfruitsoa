package com.hf.domain.Domain.User;

import com.hf.domain.Domain.Dept.DeptDO;

import java.util.List;

public class UserDOExample {

    //用户id
    private Integer userId;
    //用户名
    private String userName;
    //密码
    private String userPwd;
    //手机号
    private String userMobile;
    //邮箱
    private String userEmail;
    //头像
    private String userImg;
    //性别
    private String userSex;
    //生日
    private String userBirth;
    //创建时间
    private String userCreate;
    //修改时间
    private String userModified;
    //状态 0:禁用，1:正常
    private Integer userStatus;
    //权限 1:普通用户，2:管理员
    private Integer userRole;
    //部门id
    private Integer userDeptId;
    //部门名称
    private String userDeptName;
    //全部部门
    private List<DeptDO> Deptlist;

    public UserDOExample(UserDO ud){
        this.userId = ud.getUserId().intValue();
        this.userName = ud.getUserName();
        this.userPwd = ud.getUserPwd();
        this.userMobile = ud.getUserMobile();
        this.userEmail = ud.getUserEmail();
        this.userImg = ud.getUserImg();
        this.userSex = ud.getUserSex();
        this.userBirth = ud.getUserBirth();
        this.userCreate = ud.getUserCreate();
        this.userModified = ud.getUserModified();
        this.userStatus = ud.getUserStatus();
        this.userRole = ud.getUserRole();
        this.userDeptId = ud.getUserDeptId().intValue();
    }

    public UserDOExample(Integer userId, String userName, String userPwd, String userMobile, String userEmail, String userImg, String userSex, String userBirth, String userCreate, String userModified, Integer userStatus, Integer userRole, Integer userDeptId, String userDeptName, List<DeptDO> Deptlist) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userMobile = userMobile;
        this.userEmail = userEmail;
        this.userImg = userImg;
        this.userSex = userSex;
        this.userBirth = userBirth;
        this.userCreate = userCreate;
        this.userModified = userModified;
        this.userStatus = userStatus;
        this.userRole = userRole;
        this.userDeptId = userDeptId;
        this.userDeptName = userDeptName;
        this.Deptlist = Deptlist;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }


    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getUserModified() {
        return userModified;
    }

    public void setUserModified(String userModified) {
        this.userModified = userModified;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getUserDeptId() {
        return userDeptId;
    }

    public void setUserDeptId(Integer userDeptId) {
        this.userDeptId = userDeptId;
    }

    public String getUserDeptName() {
        return userDeptName;
    }

    public void setUserDeptName(String userDeptName) {
        this.userDeptName = userDeptName;
    }

    public List<DeptDO> getDeptlist() {
        return Deptlist;
    }

    public void setDeptlist(List<DeptDO> deptlist) {
        Deptlist = deptlist;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
