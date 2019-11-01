package com.zouzhu.controller;


import com.zouzhu.dao.mapperImp.BookManagerImp;
import com.zouzhu.pojo.Book;
import com.zouzhu.util.FenYeChaJianUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class ManagerBookSystemController {

    /*
    *   描述 : 管理员登陆请求类
    *
    *   author : zouzhu
    *
    *   time : 2019/10/19
    * */


    @Autowired
    private BookManagerImp bookManagerImp;

    @Autowired
    private FenYeChaJianUtil<Book> fenYeChaJianUtil;

    @RequestMapping(value = {"/systembook/manager"})
    public String managerAllBookSystemController(Model model){
        /*
         *    描述 ：管理员页面请求
         *
         *    author : zouzhu
         *
         *    time : 2019/10/22
         * */
        if (SystemBootStartCode.code == 909){
            List<Book> books = bookManagerImp.downloadAllBook();
            fenYeChaJianUtil.setFenYeChaJianUtil(9, books);
            Integer indexNumber = fenYeChaJianUtil.getIndexNumber(books.size());
            List<Book> indexDate = fenYeChaJianUtil.getIndexDate(1);
            model.addAttribute("book_all_dates", indexDate);
            model.addAttribute("book_code", SystemBootStartCode.code);
            Integer[] length = new Integer[indexNumber];
            for (int i=0; i<(indexNumber); i++){
                length[i]=i;
            }
            model.addAttribute("book_length", length);
        }
        return "manager";
    }

    @RequestMapping(value = {"/systembook/manager/{index}"})
    public String managerBookSystemController(@PathVariable Integer index, Model model){
        /*
        *    描述 ：管理员页面请求
        *
        *    author : zouzhu
        *
        *    time : 2019/10/22
        * */
        if (SystemBootStartCode.code == 909){
            List<Book> books = bookManagerImp.downloadAllBook();
            fenYeChaJianUtil.setFenYeChaJianUtil(9, books);
            Integer indexNumber = fenYeChaJianUtil.getIndexNumber(books.size());
            List<Book> indexDate = fenYeChaJianUtil.getIndexDate(index);
            model.addAttribute("book_all_dates", indexDate);
            model.addAttribute("book_code", SystemBootStartCode.code);
            Integer[] length = new Integer[indexNumber];
            for (int i=0; i<(indexNumber); i++){
                length[i]=i;
            }
            model.addAttribute("book_length", length);
        }
        return "manager";
    }





    @ResponseBody
    @PostMapping(value = {"systembook/manager/shangjia"})
    public Integer managerShangJiaBook(
            @PathParam("bkName")String bkName,
            @PathParam("bkAuthor")String bkAuthor,
            @PathParam("bkPress")String bkPress,
            @PathParam("bkPrice")Double bkPrice){
        /*
        *   描述 : 管理员添加图书操作
        *
        *   author : zouzhu
        *
        *   time : 2019/10/24
        * */
        Integer managerCodeStart = bookManagerImp.addBook(
                new Book(bookManagerImp.selectAfterBookID() + 1, bkName, bkAuthor, bkPress, bkPrice, 1)
        );
        return managerCodeStart;
    }


    @ResponseBody
    @PostMapping(value = {"systembook/manager/xiajia/{bkID}"})
    public Integer managerXiaJiaBook(@PathVariable Integer bkID){
        /*
        *   描述 : 管理员下架图书
        *
        *   author : zouzhu
        *
        *   time : 2019/10/25
        * */
        Book book = bookManagerImp.selectByIDBook(bkID);
        if (book != null){
            book.setBkIsDelete(0);
            bookManagerImp.updateDeleteBook(book);
            return 1;
        }else{
            return 0;
        }
    }

}
