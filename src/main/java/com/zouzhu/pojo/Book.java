package com.zouzhu.pojo;


import lombok.Data;

@Data
public class Book {

    private Integer bkID;
    private String bkName;
    private String bkAuthor;
    private String bkPress;
    private double bkPrice;
    private Integer bkStatus;
    private Integer bkIsDelete;

    public Integer getBkIsDelete() {
        return bkIsDelete;
    }

    public void setBkIsDelete(Integer bkIsDelete) {
        this.bkIsDelete = bkIsDelete;
    }

    public Integer getBkID() {
        return bkID;
    }

    public void setBkID(Integer bkID) {
        this.bkID = bkID;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public String getBkAuthor() {
        return bkAuthor;
    }

    public void setBkAuthor(String bkAuthor) {
        this.bkAuthor = bkAuthor;
    }

    public String getBkPress() {
        return bkPress;
    }

    public void setBkPress(String bkPress) {
        this.bkPress = bkPress;
    }

    public double getBkPrice() {
        return bkPrice;
    }

    public void setBkPrice(double bkPrice) {
        this.bkPrice = bkPrice;
    }

    public Integer getBkStatus() {
        return bkStatus;
    }

    public void setBkStatus(Integer bkStatus) {
        this.bkStatus = bkStatus;
    }

    Book(){}

    public Book(Integer bkID,
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
