package com.zouzhu.controller;

public class SystemBootStartCode {
    /*
    *       描述 : 用户状态包
    *
    *              608 用户暂为登录
    *
    *              606 用户登录成功
    *
    *
    *       author : zouzhu
    *
    *
    *       time : 2019/10/15   17:58
    *
    *
    * */
    static Integer code = 608;              // 网页的登录状态

    static Integer id=null;                 // 用户ID
    static String name=null;                // 用户名

    static Integer psType;                  // 用户类型 ID
    static String psTypeName;               // 用户类型名称
    static Integer psBookNumber;            // 用户借书图书量
    static Integer psBookDay;               // 用户借书图书时间
    static Double psFaKuangBaiFenLv;        // 用户借书的罚款率 ？元/天
    static Integer psZhengJiangData;        // 用户特权的到期时间

}
