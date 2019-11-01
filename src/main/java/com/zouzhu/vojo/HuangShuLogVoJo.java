package com.zouzhu.vojo;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class HuangShuLogVoJo {

    private Integer bkID;
    private Integer rdID;
    private String bkName;
    private LocalDateTime dateJieShu;
    private LocalDateTime dateHuanShu;
    private int dateDay;
    private double psFaKuangBaiFenLv;
    private double money;
    private Integer jsStart;
    private LocalDateTime dateNowHuanShu;

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

    public int getDateDay() {
        return dateDay;
    }

    public void setDateDay(int dateDay) {
        this.dateDay = dateDay;
    }

    public double getPsFaKuangBaiFenLv() {
        return psFaKuangBaiFenLv;
    }

    public void setPsFaKuangBaiFenLv(double psFaKuangBaiFenLv) {
        this.psFaKuangBaiFenLv = psFaKuangBaiFenLv;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getJsStart() {
        return jsStart;
    }

    public void setJsStart(Integer jsStart) {
        this.jsStart = jsStart;
    }

    public LocalDateTime getDateNowHuanShu() {
        return dateNowHuanShu;
    }

    public void setDateNowHuanShu(LocalDateTime dateNowHuanShu) {
        this.dateNowHuanShu = dateNowHuanShu;
    }

    public HuangShuLogVoJo(){}

    public HuangShuLogVoJo(Integer bkID, String bkName, LocalDateTime dateJieShu, LocalDateTime dateHuanShu, int dateDay, double psFaKuangBaiFenLv, double money, Integer jsStart, LocalDateTime dateNowHuanShu) {
        this.bkID = bkID;
        this.bkName = bkName;
        this.dateJieShu = dateJieShu;
        this.dateHuanShu = dateHuanShu;
        this.dateDay = dateDay;
        this.psFaKuangBaiFenLv = psFaKuangBaiFenLv;
        this.money = money;
        this.jsStart = jsStart;
        this.dateNowHuanShu = dateNowHuanShu;
    }

    @Override
    public String toString() {
        return "HuangShuLogVoJo{" +
                "bkID=" + bkID +
                ", bkName='" + bkName + '\'' +
                ", dateJieShu=" + dateJieShu +
                ", dateHuanShu=" + dateHuanShu +
                ", dateDay=" + dateDay +
                ", psFaKuangBaiFenLv=" + psFaKuangBaiFenLv +
                ", money=" + money +
                ", jsStart=" + jsStart +
                ", dateNowHuanShu=" + dateNowHuanShu +
                '}';
    }
}
