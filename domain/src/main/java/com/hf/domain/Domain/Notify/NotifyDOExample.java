package com.hf.domain.Domain.Notify;

import java.io.Serializable;
import java.util.Date;

public class NotifyDOExample extends NotifyDO implements Serializable {

    //编号
    private Long notifyId;
    //发布者id
    private Long notifyUserId;
    //发布者id
    private String notifyUserName;
    //接受者id
    private Long notifyThatuser;
    //标题
    private String notifyTitle;
    //类型
    private String notifyType;
    //内容
    private String notifyContent;
    //备注信息
    private String notifyRemarks;
    //创建时间
    private Date notifyCreateDate;
    //更新时间
    private Date notifyUpdateDate;

    public NotifyDOExample(String notifyUserName,NotifyDO notifyDO) {
        this.notifyId = notifyDO.getNotifyId();
        this.notifyUserId = notifyDO.getNotifyUserId();
        this.notifyUserName = notifyUserName;
        this.notifyThatuser = notifyDO.getNotifyThatuser();
        this.notifyTitle = notifyDO.getNotifyTitle();
        this.notifyType = notifyDO.getNotifyType();
        this.notifyContent = notifyDO.getNotifyContent();
        this.notifyRemarks = notifyDO.getNotifyRemarks();
        this.notifyCreateDate = notifyDO.getNotifyCreateDate();
        this.notifyUpdateDate = notifyDO.getNotifyUpdateDate();
    }

    public Long getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(Long notifyId) {
        this.notifyId = notifyId;
    }

    public Long getNotifyUserId() {
        return notifyUserId;
    }

    public void setNotifyUserId(Long notifyUserId) {
        this.notifyUserId = notifyUserId;
    }

    public String getNotifyUserName() {
        return notifyUserName;
    }

    public void setNotifyUserName(String notifyUserName) {
        this.notifyUserName = notifyUserName;
    }

    public Long getNotifyThatuser() {
        return notifyThatuser;
    }

    public void setNotifyThatuser(Long notifyThatuser) {
        this.notifyThatuser = notifyThatuser;
    }

    public String getNotifyTitle() {
        return notifyTitle;
    }

    public void setNotifyTitle(String notifyTitle) {
        this.notifyTitle = notifyTitle;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getNotifyContent() {
        return notifyContent;
    }

    public void setNotifyContent(String notifyContent) {
        this.notifyContent = notifyContent;
    }

    public String getNotifyRemarks() {
        return notifyRemarks;
    }

    public void setNotifyRemarks(String notifyRemarks) {
        this.notifyRemarks = notifyRemarks;
    }

    public Date getNotifyCreateDate() {
        return notifyCreateDate;
    }

    public void setNotifyCreateDate(Date notifyCreateDate) {
        this.notifyCreateDate = notifyCreateDate;
    }

    public Date getNotifyUpdateDate() {
        return notifyUpdateDate;
    }

    public void setNotifyUpdateDate(Date notifyUpdateDate) {
        this.notifyUpdateDate = notifyUpdateDate;
    }
}
