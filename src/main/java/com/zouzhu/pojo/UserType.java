package com.zouzhu.pojo;

import lombok.Data;

@Data
public class UserType {
    private Integer psType;
    private String psTypeName;
    private Integer psBookNumber;
    private Integer psBookDay;
    private Double psFaKuangBaiFenLv;
    private Integer psZhengJiangData;

    UserType(){};

    public UserType(Integer psType, String psTypeName, Integer psBookNumber, Integer psBookDay, Double psFaKuangBaiFenLv, Integer psZhengJiangData) {
        this.psType = psType;
        this.psTypeName = psTypeName;
        this.psBookNumber = psBookNumber;
        this.psBookDay = psBookDay;
        this.psFaKuangBaiFenLv = psFaKuangBaiFenLv;
        this.psZhengJiangData = psZhengJiangData;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "psType=" + psType +
                ", psTypeName='" + psTypeName + '\'' +
                ", psBookNumber=" + psBookNumber +
                ", psBookDay=" + psBookDay +
                ", psFaKuangBaiFenLv=" + psFaKuangBaiFenLv +
                ", psZhengJiangData=" + psZhengJiangData +
                '}';
    }
}
