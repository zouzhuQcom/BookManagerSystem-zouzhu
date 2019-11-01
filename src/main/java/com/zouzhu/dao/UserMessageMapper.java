package com.zouzhu.dao;


import com.zouzhu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMessageMapper {

    @Select("select * from user where usName=#{usName} and usPassword=#{usPassword}")
    /*
     *   描述 : 用户登录验证的方法
     *
     *   author : zouzhu
     *
     *   time : 2019/10/11
     * */
    public User userLoginXiaoYang(User user);



    @Insert("insert into user values(#{usID},#{usName},#{usPassword},#{usSex},#{usType},#{usAdder},#{usBanZhengData},#{usJieShuNumber})")
    /*
    *   描述 : 用户注册功能, 进行新用户注册
    *
    *   author : zouzhu
    *
    *   time : 2019/10/11  20:08
    * */
    public void userAddMessage(User user);


    @Select("select * from user,usertype where user.usType=usertype.psType and user.usName=#{usName} and user.usPassword=#{usPassword};")
    /*
     *   描述 : 用户登录验证的方法
     *
     *   author : zouzhu
     *
     *   time : 2019/10/11
     * */
    public User selectAllByNameUserAndType(User user);
}
