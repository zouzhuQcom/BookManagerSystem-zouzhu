package com.zouzhu.pojo;

import lombok.Data;

import java.time.LocalDateTime;



@Data
public class JieShuData {
    /*
    *       描述 ： 借书条目的 POJO, 关联到 BookID, UserID
    *
    *       auther : zouzhu
    *
    *       time : 2019/10/15  23:18
    * */
    private Integer bkID;

    private Integer rdID;

    private String bkName;
    private LocalDateTime dateJieShu;
    private LocalDateTime dateHuanShu;
    private LocalDateTime dateNowHuanShu;
    private Integer jsStart;

    public Integer getBkID() {
        return bkID;
    }

    public void setBkID(Integer bkID) {
        this.bkID = bkID;
    }

    public Integer getRdID() {
        return rdID;
    }

    public void setRdID(Integer rdID) {
        this.rdID = rdID;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public LocalDateTime getDateJieShu() {
        return dateJieShu;
    }

    public void setDateJieShu(LocalDateTime dateJieShu) {
        this.dateJieShu = dateJieShu;
    }

    public LocalDateTime getDateHuanShu() {
        return dateHuanShu;
    }

    public void setDateHuanShu(LocalDateTime dateHuanShu) {
        this.dateHuanShu = dateHuanShu;
    }

    public LocalDateTime getDateNowHuanShu() {
        return dateNowHuanShu;
    }

    public void setDateNowHuanShu(LocalDateTime dateNowHuanShu) {
        this.dateNowHuanShu = dateNowHuanShu;
    }

    public Integer getJsStart() {
        return jsStart;
    }

    public void setJsStart(Integer jsStart) {
        this.jsStart = jsStart;
    }

    public JieShuData(){}

    public JieShuData(
            Integer bkID, Integer rdID, LocalDateTime dateJieShu, LocalDateTime dateHuanShu,
            LocalDateTime dateNowHuanShu, Integer jsStart) {
        this.bkID = bkID;
        this.rdID = rdID;
        this.dateJieShu = dateJieShu;
        this.dateHuanShu = dateHuanShu;
        this.dateNowHuanShu = dateNowHuanShu;
        this.jsStart = jsStart;
    }
}
