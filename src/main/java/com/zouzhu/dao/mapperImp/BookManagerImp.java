package com.zouzhu.dao.mapperImp;

import com.zouzhu.dao.BookManagerMapper;
import com.zouzhu.pojo.Book;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BookManagerImp {

    @Autowired
    private BookManagerMapper bookManagerMapper;


    public Integer selectAfterBookID(){
        return bookManagerMapper.selectAfterBookID();
    }


    public List<Book> downloadAllBook(){
        /*
        *       描述 ：用于加载图书的所有信息
        *
        *       author : zouzhu
        *
        *       time : 2019/10/10  13:00
        *
        *       状态 : 完成
        * */
        return bookManagerMapper.downloadAllBook();
    }


    public Book selectByNameBook(String book_name){
        /*
        *       描述 ：根据书本名称查询图书信息
        *
        *       author : zouzhu
        *
        *       time : 2019/10/10  19:25
        *
        *       状态 ：完成
        * */
        return bookManagerMapper.selectByNameBook(book_name);
    }


    public Book selectByIDBook(Integer bkID){
        /*
         *       描述 : 根据 id 查询图书
         *
         *       auther : zouzhu
         *
         *       time : 2019/10/14  20:33
         *
         * */
        return bookManagerMapper.selectByIDBook(bkID);
    };



    public int addBook(Book book){
        /*
        *       描述 ： 用于添加图书
        *
        *       auther : zouzhu
        *
        *       time : 2019/10/10  20:03
        *
        *       状态 ：完成
        * */
        try{
            bookManagerMapper.addBook(book);
        }catch(Exception e){
            System.out.println("管理员图书上架失败 ! code : 500");
            return 0;
        }
        return 1;
    }


    public void updateDeleteBook(Book book){
        /*
        *       描述 ：用于删除图书
        *
        *       author : zouzhu
        *
        *       time : 2019/10/11  11:00
        *
        *       状态 :
        * */
        bookManagerMapper.updateDeleteBook(book);
    }


    public void updateJieShuBook(Book book){
        /*
        *       描述 : 更新图书
        *
        *       author : zouzhu
        *
        *       time : 2019/10/11  11:00
        *
        *       状态 :
        * */
        bookManagerMapper.updateJieShuBook(book);
    }

}
