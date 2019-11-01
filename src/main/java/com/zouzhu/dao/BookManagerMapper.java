package com.zouzhu.dao;

import com.zouzhu.pojo.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookManagerMapper {

    @Select("SELECT bkID FROM book ORDER BY bkID DESC LIMIT 1;")
    public Integer selectAfterBookID();

    @Select("select * from book where bkIsDelete=1")                                         // 1. 用于加载所有图书类信息
    public List<Book> downloadAllBook();



    @Select("select * from book where bkName=#{bkName}")                 // 2. 根据图书名称查询图书信息
    /*
    *       描述 : 根据名称查询图书
    *
    *       auther : zouzhu
    *
    *       time : 2019/10/11  10:31
    *
    * */
    public Book selectByNameBook(String bkName);



    @Select("select * from book where bkID=#{bkID}")                 // 3. 根据图书 ID 查询图书信息
    /*
     *       描述 : 根据 id 查询图书
     *
     *       auther : zouzhu
     *
     *       time : 2019/10/14  20:33
     *
     * */
    public Book selectByIDBook(Integer bkID);



    @Insert("insert into book values(#{bkID}, #{bkName}, #{bkAuthor}, #{bkPress}, #{bkPrice}, #{bkStatus})")
    /*
    *       描述 ：添加图书
    *
    *       auther : zouzhu
    *
    *       time : 2019/10/11  10:30
    * */
    public void addBook(Book javabook);



    @Delete("delete from book where bkID=#{bkID}")
    /*
    *       描述 ：删除图书, 根据编号删除, 获得数据的方式是路径匹配
    *
    *       auther : zouzhu
    *
    *       time : 2019/10/11  10:34
    * */
    public void deleteBook(Integer bkID);



    @Update("update book set bkStatus=#{bkStatus} where bkID=#{bkID}")
    /*
    *       描述 ：更新图书
    *
    *       author : zouzhu
    *
    *       time : 2019/10/11  11:00
    * */
    public void updateJieShuBook(Book book);

    @Update("update book set bkIsDelete=#{bkIsDelete} where bkID=#{bkID}")
    public void updateDeleteBook(Book book);
}
