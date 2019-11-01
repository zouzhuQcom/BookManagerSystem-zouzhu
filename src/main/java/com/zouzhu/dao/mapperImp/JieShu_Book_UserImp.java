package com.zouzhu.dao.mapperImp;

import com.zouzhu.dao.JieShu_Book_User;
import com.zouzhu.pojo.JieShuData;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class JieShu_Book_UserImp {

    @Autowired
    private JieShu_Book_User jieShu_book_user;

    public void insertJieShuData(JieShuData jieShuDataPojo){

        jieShu_book_user.insertJieShuData(jieShuDataPojo);
    }



    public List<JieShuData> selectByIdNameAllJieShuData(Integer rdID){
        return jieShu_book_user.selectByIdNameAllJieShuData(rdID);
    }


    public List<JieShuData> selectAllJieShuLog(Integer rdID){
        /*
         *     描述 ：查询指定用户图书的出借所有记录, Mapper 的实现类
         *
         *     author ：zouzhu
         *
         *     time : 2019/10/19
         * */
        return jieShu_book_user.selectAllJieShuLog(rdID);
    }


    public void updateJieShuDateStart(Integer bkID, Integer rdID){
        /*
         *    描述 ： 借书记录更新，主要作用是还书, 前提条件下, 先查对应ID,在确定状态为借出状态时，才能还书
         *
         *    mapper 的实现类
         *
         *    author : zouzhu
         *
         *   time : 2019/10/18    16:08
         * */

        jieShu_book_user.updateJieShuDateStart(bkID, rdID, LocalDateTime.now());
    }

}
