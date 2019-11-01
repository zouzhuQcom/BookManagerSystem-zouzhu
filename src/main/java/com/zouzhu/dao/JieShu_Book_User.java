package com.zouzhu.dao;

import com.zouzhu.pojo.JieShuData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
@Mapper
public interface JieShu_Book_User {
    /*
    *     描述 : 借书的数据表，这个会与用户表和图书表关联一起操作
    *
    *     author : zouzhu
    *
    *     time : 2019/10/15
    * */
    @Insert("insert into jieshu values(#{bkID}, #{rdID}, #{dateJieShu}, #{dateHuanShu}, #{dateNowHuanShu}, #{jsStart})")
    public void insertJieShuData(JieShuData jieShuDataPojo);




    @Select("select * from jieshu,book where jieshu.rdID=#{rdID} and jieshu.bkID=book.bkID and jieshu.jsStart=0;")
    /*
    *     描述 ：查询未还的图书的出借记录
    *
    *     author ：zouzhu
    *
    *     time : 2019/10/19
    * */
    public List<JieShuData> selectByIdNameAllJieShuData(Integer rdID);



    @Select("select * from jieshu,book where jieshu.rdID=#{rdID} and jieshu.bkID=book.bkID and jsStart=1")
    /*
     *     描述 ：查询指定用户图书的出借所有记录
     *
     *     author ：zouzhu
     *
     *     time : 2019/10/19
     * */
    public List<JieShuData> selectAllJieShuLog(Integer rdID);



    @Update("update jieshu set jsStart=1, dateNowHuanShu=#{dateNowHuanShu} where bkID=#{bkID} and rdID=#{rdID} and jsStart=0")
    /*
    *    描述 ： 借书记录更新，主要作用是还书, 前提条件下, 先查对应ID,在确定状态为借出状态时，才能还书
    *
    *    author : zouzhu
    *
    *   time : 2019/10/18    16:08
    * */
    public void updateJieShuDateStart(Integer bkID, Integer rdID, LocalDateTime dateNowHuanShu);
}
