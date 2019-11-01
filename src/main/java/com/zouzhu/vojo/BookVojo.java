package com.zouzhu.vojo;


import lombok.Data;

@Data
public class BookVojo {

    private Integer bkID;
    private String bkName;
    private String bkAuthor;
    private String bkPress;
    private double bkPrice;
    private Integer bkStatus;

    BookVojo(){}

    public BookVojo(Integer bkID,
                String bkName,
                String bkAuthor,
                String bkPress,
                double bkPrice,
                Integer bkStatus){
        this.setBkID(bkID);
        this.setBkName(bkName);
        this.setBkAuthor(bkAuthor);
        this.setBkPress(bkPress);
        this.setBkPrice(bkPrice);
        this.setBkStatus(bkStatus);
    }
}
