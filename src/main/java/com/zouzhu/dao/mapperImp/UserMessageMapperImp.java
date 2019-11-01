package com.zouzhu.dao.mapperImp;

import com.zouzhu.dao.UserMessageMapper;
import com.zouzhu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserMessageMapperImp {
    /*
    *   描述 ：用户登录接口的实现类
    *
    *   author : zouzhu
    *
    *   time : 2019/10/11  18:46
    * */

    @Autowired
    private UserMessageMapper userMessageMapper;


    public User userLoginXiaoYang(User user){
        /*
        *   描述 : 用户登录验证功能, 登录成功返回1, 登录失败返回0
        *
        *   author : zouzhu
        *
        *   time : 2019/10/11  19:00
        * */
        User u = userMessageMapper.userLoginXiaoYang(user);
        return u;
    }

    public void userAddMessage(User user){
        /*
        *   描述 : 新用户注册的实现方法
        *
        *   author : zouzhu
        *
        *   time : 2019/10/11
        * */
        userMessageMapper.userAddMessage(user);
    }


    public User selectAllByNameUserAndType(User user){
        /*
         *   描述 : 用户登录验证功能, 登录成功返回1, 登录失败返回0，登录功能的第二次程序更新
         *
         *   author : zouzhu
         *
         *   time : 2019/10/16   19:19
         * */
        return userMessageMapper.selectAllByNameUserAndType(user);
    }

}
