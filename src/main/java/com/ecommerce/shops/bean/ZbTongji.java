package com.ecommerce.shops.bean;

public class ZbTongji {
    private Integer id;

    private Integer uid;

    private String cid;

    private Integer dengji;

    private Integer intime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public Integer getDengji() {
        return dengji;
    }

    public void setDengji(Integer dengji) {
        this.dengji = dengji;
    }

    public Integer getIntime() {
        return intime;
    }

    public void setIntime(Integer intime) {
        this.intime = intime;
    }
}