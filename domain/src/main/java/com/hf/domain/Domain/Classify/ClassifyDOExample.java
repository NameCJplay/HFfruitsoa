package com.hf.domain.Domain.Classify;

import java.util.List;

public class ClassifyDOExample {
    private static final long serialVersionUID = 1L;

    //编号
    private Integer classifyId;
    //上级id
    private Integer classifyParentid;
    //分类名称
    private String classifyName;
    //所有分类
    private List<ClassifyDO> classlist;

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getClassifyParentid() {
        return classifyParentid;
    }

    public void setClassifyParentid(Integer classifyParentid) {
        this.classifyParentid = classifyParentid;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public List<ClassifyDO> getClasslist() {
        return classlist;
    }

    public void setClasslist(List<ClassifyDO> classlist) {
        this.classlist = classlist;
    }

    public ClassifyDOExample(Integer classifyId, Integer classifyParentid, String classifyName) {
        this.classifyId = classifyId;
        this.classifyParentid = classifyParentid;
        this.classifyName = classifyName;
    }
    public ClassifyDOExample(ClassifyDO cd){
        this.classifyId = cd.getClassifyId().intValue();
        this.classifyParentid = cd.getClassifyParentid().intValue();
        this.classifyName = cd.getClassifyName();

    }

}
