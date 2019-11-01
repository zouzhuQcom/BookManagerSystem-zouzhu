package com.zouzhu.pojo;


import lombok.Data;

@Data
public class User {

    /*
    *       描述 : User Pojo
    *
    *       author : zouzhu
    *
    *       time : 2019/10/11  16:10
    * */
    private Integer usID;
    private String usName;
    private String usPassword;

    private Integer psType;
    private String psTypeName;
    private Integer psBookNumber;
    private Integer psBookDay;
    private Double psFaKuangBaiFenLv;
    private Integer psZhengJiangData;

    User(){}

    public User(Integer usID, String usName, String usPassword,
                Integer psType, String psTypeName, Integer psBookNumber, Integer psBookDay, Double psFaKuangBaiFenLv, Integer psZhengJiangData) {
        this.usID = usID;
        this.usName = usName;
        this.usPassword = usPassword;
        this.psType = psType;
        this.psTypeName = psTypeName;
        this.psBookNumber = psBookNumber;
        this.psBookDay = psBookDay;
        this.psFaKuangBaiFenLv = psFaKuangBaiFenLv;
        this.psZhengJiangData = psZhengJiangData;
    }

    @Override
    public String toString() {
        return "User{" +
                "usID=" + usID +
                ", usName='" + usName + '\'' +
                ", usPassword='" + usPassword + '\'' +
                ", psType=" + psType +
                ", psTypeName='" + psTypeName + '\'' +
                ", psBookNumber=" + psBookNumber +
                ", psBookDay=" + psBookDay +
                ", psFaKuangBaiFenLv=" + psFaKuangBaiFenLv +
                ", psZhengJiangData=" + psZhengJiangData +
                '}';
    }

    public Integer getUsID() {
        return usID;
    }

    public void setUsID(Integer usID) {
        this.usID = usID;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }

    public Integer getPsType() {
        return psType;
    }

    public void setPsType(Integer psType) {
        this.psType = psType;
    }

    public String getPsTypeName() {
        return psTypeName;
    }

    public void setPsTypeName(String psTypeName) {
        this.psTypeName = psTypeName;
    }

    public Integer getPsBookNumber() {
        return psBookNumber;
    }

    public void setPsBookNumber(Integer psBookNumber) {
        this.psBookNumber = psBookNumber;
    }

    public Integer getPsBookDay() {
        return psBookDay;
    }

    public void setPsBookDay(Integer psBookDay) {
        this.psBookDay = psBookDay;
    }

    public Double getPsFaKuangBaiFenLv() {
        return psFaKuangBaiFenLv;
    }

    public void setPsFaKuangBaiFenLv(Double psFaKuangBaiFenLv) {
        this.psFaKuangBaiFenLv = psFaKuangBaiFenLv;
    }

    public Integer getPsZhengJiangData() {
        return psZhengJiangData;
    }

    public void setPsZhengJiangData(Integer psZhengJiangData) {
        this.psZhengJiangData = psZhengJiangData;
    }
}
