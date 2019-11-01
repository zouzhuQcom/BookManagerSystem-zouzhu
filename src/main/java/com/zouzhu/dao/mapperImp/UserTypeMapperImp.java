package com.zouzhu.dao.mapperImp;


import com.zouzhu.dao.UserTypeMapper;
import com.zouzhu.pojo.UserType;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTypeMapperImp {


    @Autowired
    private UserTypeMapper userTypeMapper;

    public UserType selectUserTypeByID(Integer psType){
        return userTypeMapper.selectUserTypeByID(psType);
    }
}
