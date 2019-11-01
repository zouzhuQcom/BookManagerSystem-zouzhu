package com.zouzhu.controller;


import com.zouzhu.dao.mapperImp.BookManagerImp;
import com.zouzhu.pojo.Book;
import com.zouzhu.util.FenYeChaJianUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BookSystemJiChuController {

    @GetMapping(value = {"/index"})
    public String sendIndex(Model model){
        model.addAttribute("book_code", SystemBootStartCode.code);
        model.addAttribute("user_name", SystemBootStartCode.name);
        model.addAttribute("user_type_name", SystemBootStartCode.psTypeName);
        return "index.html";
    }


    @Autowired
    private BookManagerImp selectBookManagerImp;

    @Autowired
    private FenYeChaJianUtil<Book> fenYeChaJianUtil;

    @GetMapping("/booksystem/allbook")
    public String allBook(Model model){
        /*
         *       描述 : 查询出所有图书
         *
         *       auther : zouzhu
         *
         *       time : 2019/10/10  8:18
         * */
        List<Book> books = selectBookManagerImp.downloadAllBook();
        fenYeChaJianUtil.setFenYeChaJianUtil(9, books);
        Integer indexNumber = fenYeChaJianUtil.getIndexNumber(books.size());
        List<Book> indexDate = fenYeChaJianUtil.getIndexDate(1);
        Integer[] length = new Integer[indexNumber];
        for (int i=0; i<(indexNumber); i++){
            length[i]=i;
        }
        model.addAttribute("allbook", indexDate);
        model.addAttribute("book_length", length);
        model.addAttribute("book_code", SystemBootStartCode.code);
        return "jieshu";
    }


    @GetMapping("/booksystem/allbook/{index}")
    public String allBookIndexNumber(@PathVariable Integer index, Model model){
        /*
        *       描述 : 查询出所有图书
        *
        *       auther : zouzhu
        *
        *       time : 2019/10/10  8:18
        * */
        List<Book> books = selectBookManagerImp.downloadAllBook();
        fenYeChaJianUtil.setFenYeChaJianUtil(9, books);
        Integer indexNumber = fenYeChaJianUtil.getIndexNumber(books.size());
        List<Book> indexDate = fenYeChaJianUtil.getIndexDate(index);
        Integer[] length = new Integer[indexNumber];
        for (int i=0; i<(indexNumber); i++){
            length[i]=i;
        }
        model.addAttribute("allbook", indexDate);
        model.addAttribute("book_length", length);
        model.addAttribute("book_code", SystemBootStartCode.code);
        return "jieshu";
    }


    @ResponseBody
    @GetMapping("/booksystem/book")
    public Book selectByNameBookController(@Param("book_name") String book_name){
        /*
        *       描述 ：查询图书, 根据书名查询
        *
        *       auther : zouzhu
        *
        *       time : 2019/10/10 8:12
        * */
        Book book = selectBookManagerImp.selectByNameBook(book_name);
        return book;
    }

    @ResponseBody
    @GetMapping("booksystem/addbook")
    public int addBookController(Book book){
        /*
        *       描述 : 添加图书请求, 请求类型, 管理员权限类型
        *
        *       auther : zouzhu
        *
        *       time : 2019/10/10  20:08
        * */
        selectBookManagerImp.addBook(book);

        return 1;
    }
}
