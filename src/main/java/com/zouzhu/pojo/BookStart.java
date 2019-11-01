package com.zouzhu.pojo;

public enum BookStart {

    ZaiGuan(0,"在馆状态"), JieChu(1, "外借状态");

    private Integer num;
    private String start;

    BookStart(Integer num, String start){
        this.num=num;
        this.start=start;
    }

    public String getStart(){
        return start;
    }
}
