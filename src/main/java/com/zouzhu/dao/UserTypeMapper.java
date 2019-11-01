package com.zouzhu.dao;

import com.zouzhu.pojo.UserType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserTypeMapper {

    @Select("select * from usertype where psType=#{psType}")
    public UserType selectUserTypeByID(Integer psType);
}
