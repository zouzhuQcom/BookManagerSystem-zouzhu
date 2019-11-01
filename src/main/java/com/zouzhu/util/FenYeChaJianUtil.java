package com.zouzhu.util;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FenYeChaJianUtil<T> {

    private Integer oneIndexDateLength;
    private List<T> date;
    private Integer shengyuDate;

    public void setFenYeChaJianUtil(Integer oneIndexDateLength, List<T> date){
        /*
        *   @oneIndexDateLength : 一页显示数据的长度
        *   @t : 数据类型
        *   描述 : 构造分页插件
        *   author : zouzhu
        *   date : 2019/20/28
        * */
        this.oneIndexDateLength=oneIndexDateLength;
        this.date=date;
    }

    public Integer getIndexNumber(Integer dataInteger){
        /*
        *   @dataInteger : 数据长度
        *   描述 : 分析页数
        *   author : zouzhu
        *   date : 2019/10/28
        * */
        int a = dataInteger/oneIndexDateLength;
        int b = dataInteger%oneIndexDateLength;
        this.shengyuDate = b;
        if (b>0) a+=1;
        return a;
    }

    public List<T> getIndexDate(Integer number){
        /*
        *   @number : 第几页
        *   描述 : 返回指定页的数据
        *   author : zouzhu
        *   date : 2019/10/28
        * */
        List<T> list;
        try{
            list = this.date.subList(oneIndexDateLength * (number - 1), oneIndexDateLength * number);
        }catch (Exception e){
            list = this.date.subList(oneIndexDateLength * (number - 1), oneIndexDateLength * (number - 1) + shengyuDate);
        }
        return list;
    }


}
