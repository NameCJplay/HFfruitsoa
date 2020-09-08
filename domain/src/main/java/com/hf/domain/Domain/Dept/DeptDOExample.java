package com.hf.domain.Domain.Dept;

import java.util.List;

public class DeptDOExample {

    private Long deptId;
    //上级部门
    private Long deptParentid;
    //部门名称
    private String deptName;
    //所在地址
    private String deptAddress;
    //所有分类
    private List<DeptDO> deptlist;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getDeptParentid() {
        return deptParentid;
    }

    public void setDeptParentid(Long deptParentid) {
        this.deptParentid = deptParentid;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    public List<DeptDO> getDeptlist() {
        return deptlist;
    }

    public void setDeptlist(List<DeptDO> deptlist) {
        this.deptlist = deptlist;
    }

    public DeptDOExample(DeptDO deptDO) {
        this.deptId = (long)deptDO.getDeptId();
        this.deptParentid = deptDO.getDeptParentid();
        this.deptName = deptDO.getDeptName();
        this.deptAddress = deptDO.getDeptAddress();
        this.deptlist = null;
    }
}
