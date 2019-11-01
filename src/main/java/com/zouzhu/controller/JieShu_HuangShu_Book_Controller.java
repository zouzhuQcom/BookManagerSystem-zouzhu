package com.zouzhu.controller;

import com.zouzhu.dao.BookManagerMapper;
import com.zouzhu.dao.mapperImp.JieShu_Book_UserImp;
import com.zouzhu.pojo.Book;
import com.zouzhu.pojo.JieShuData;
import com.zouzhu.util.FenYeChaJianUtil;
import com.zouzhu.vojo.HuangShuLogVoJo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JieShu_HuangShu_Book_Controller {


    @Autowired
    private BookManagerMapper bookManagerMapper;
    @Autowired
    private JieShu_Book_UserImp jieshu_book_user;

    @Autowired
    private FenYeChaJianUtil<HuangShuLogVoJo> fenYeChaJianUtil;
    @RequestMapping(value = {"booksystem/huangshubook"})
    public String userHuangShuBook(Model model){
        /*
        *       描述 ： 还书数据填充, 拼凑数据
        *
        *       author ： zouzhu
        *
        *       time : 2019/10/17  20:50
        * */
        model.addAttribute("book_code", SystemBootStartCode.code);
        model.addAttribute("user_id", SystemBootStartCode.id);
        model.addAttribute("user_name", SystemBootStartCode.name);
        if (SystemBootStartCode.code==606){
            System.out.println(">>>>>>   " + SystemBootStartCode.id);
            List<JieShuData> jieShuDatas = jieshu_book_user.selectByIdNameAllJieShuData(SystemBootStartCode.id);
            List<HuangShuLogVoJo> huangShuLogVoJos = new ArrayList<>();
            for (JieShuData m : jieShuDatas) {
                HuangShuLogVoJo h = new HuangShuLogVoJo();
                h.setPsFaKuangBaiFenLv(SystemBootStartCode.psFaKuangBaiFenLv);
                LocalDate t1 = LocalDate.now();
                LocalDateTime t2 = m.getDateHuanShu();
                LocalDate t3 = LocalDate.of(t2.getYear(), t2.getMonth(), t2.getDayOfMonth());
                int day = (int) (t1.toEpochDay() - t3.toEpochDay());
                h.setDateDay(day);
                h.setMoney(day * SystemBootStartCode.psFaKuangBaiFenLv);
                BeanUtils.copyProperties(m, h);
                huangShuLogVoJos.add(h);
            }
            fenYeChaJianUtil.setFenYeChaJianUtil(9, huangShuLogVoJos);
            Integer indexNumber = fenYeChaJianUtil.getIndexNumber(huangShuLogVoJos.size());
            List<HuangShuLogVoJo> indexDate = fenYeChaJianUtil.getIndexDate(1);
            Integer[] length = new Integer[indexNumber];
            for (int i=0; i<(indexNumber); i++){
                length[i]=i;
            }
            model.addAttribute("book_length", length);
            model.addAttribute("JieShuData", indexDate);
        }
        return "huanshu";
    }


    @RequestMapping(value = {"booksystem/huangshubook/{index}"})
    public String userHuangShuIndexBook(@PathVariable Integer index, Model model){
        /*
         *       描述 ： 还书数据填充, 拼凑数据, index 指定页面
         *
         *       author ： zouzhu
         *
         *       time : 2019/10/17  20:50
         * */
        model.addAttribute("book_code", SystemBootStartCode.code);
        model.addAttribute("user_id", SystemBootStartCode.id);
        model.addAttribute("user_name", SystemBootStartCode.name);
        if (SystemBootStartCode.code==606){
            System.out.println(">>>>>>   " + SystemBootStartCode.id);
            List<JieShuData> jieShuDatas = jieshu_book_user.selectByIdNameAllJieShuData(SystemBootStartCode.id);
            List<HuangShuLogVoJo> huangShuLogVoJos = new ArrayList<>();
            for (JieShuData m : jieShuDatas) {
                HuangShuLogVoJo h = new HuangShuLogVoJo();
                h.setPsFaKuangBaiFenLv(SystemBootStartCode.psFaKuangBaiFenLv);
                LocalDate t1 = LocalDate.now();
                LocalDateTime t2 = m.getDateHuanShu();
                LocalDate t3 = LocalDate.of(t2.getYear(), t2.getMonth(), t2.getDayOfMonth());
                int day = (int) (t1.toEpochDay() - t3.toEpochDay());
                h.setDateDay(day);
                h.setMoney(day * SystemBootStartCode.psFaKuangBaiFenLv);
                BeanUtils.copyProperties(m, h);
                huangShuLogVoJos.add(h);
            }
            fenYeChaJianUtil.setFenYeChaJianUtil(9, huangShuLogVoJos);
            Integer indexNumber = fenYeChaJianUtil.getIndexNumber(huangShuLogVoJos.size());
            List<HuangShuLogVoJo> indexDate = fenYeChaJianUtil.getIndexDate(index);
            Integer[] length = new Integer[indexNumber];
            for (int i=0; i<(indexNumber); i++){
                length[i]=i;
            }
            model.addAttribute("book_length", length);
            model.addAttribute("JieShuData", indexDate);
        }
        return "huanshu";
    }


    @RequestMapping("systembook/userbooklog")
    public String userHuangShuBookLog(Model model){
        /*
         *     描述 ：查询指定用户图书的出借所有记录请求
         *
         *     author ：zouzhu
         *
         *     time : 2019/10/19
         * */
        model.addAttribute("book_code", SystemBootStartCode.code);
        model.addAttribute("user_id", SystemBootStartCode.id);
        model.addAttribute("user_name", SystemBootStartCode.name);
        List<JieShuData> jieShuDatas = jieshu_book_user.selectAllJieShuLog(SystemBootStartCode.id);
        List<HuangShuLogVoJo> huangShuLogVoJos = new ArrayList<>();
        jieShuDatas.stream().forEach(m -> {
            HuangShuLogVoJo h = new HuangShuLogVoJo();
            h.setPsFaKuangBaiFenLv(SystemBootStartCode.psFaKuangBaiFenLv);
            LocalDate t1 = LocalDate.now();
            LocalDateTime t2 = m.getDateHuanShu();
            LocalDate t3 = LocalDate.of(t2.getYear(), t2.getMonth(), t2.getDayOfMonth());
            int day = (int)(t1.toEpochDay() - t3.toEpochDay());
            h.setDateDay(day);
            h.setMoney(day*SystemBootStartCode.psFaKuangBaiFenLv);
            BeanUtils.copyProperties(m, h);
            huangShuLogVoJos.add(h);
        });
        fenYeChaJianUtil.setFenYeChaJianUtil(9, huangShuLogVoJos);
        Integer indexNumber = fenYeChaJianUtil.getIndexNumber(huangShuLogVoJos.size());
        List<HuangShuLogVoJo> indexDate = fenYeChaJianUtil.getIndexDate(1);
        Integer[] length = new Integer[indexNumber];
        for (int i=0; i<(indexNumber); i++){
            length[i]=i;
        }
        model.addAttribute("book_length", length);
        model.addAttribute("JieShuLog", indexDate);
        return "log";
    }


    @RequestMapping("systembook/userbooklog/{index}")
    public String userHuangShuBookLog(@PathVariable Integer index, Model model){
        /*
         *     描述 ：查询指定用户图书的出借所有记录请求
         *
         *     author ：zouzhu
         *
         *     time : 2019/10/19
         * */
        model.addAttribute("book_code", SystemBootStartCode.code);
        model.addAttribute("user_id", SystemBootStartCode.id);
        model.addAttribute("user_name", SystemBootStartCode.name);
        List<JieShuData> jieShuDatas = jieshu_book_user.selectAllJieShuLog(SystemBootStartCode.id);
        List<HuangShuLogVoJo> huangShuLogVoJos = new ArrayList<>();
        jieShuDatas.stream().forEach(m -> {
            HuangShuLogVoJo h = new HuangShuLogVoJo();
            h.setPsFaKuangBaiFenLv(SystemBootStartCode.psFaKuangBaiFenLv);
            LocalDate t1 = LocalDate.now();
            LocalDateTime t2 = m.getDateHuanShu();
            LocalDate t3 = LocalDate.of(t2.getYear(), t2.getMonth(), t2.getDayOfMonth());
            int day = (int)(t1.toEpochDay() - t3.toEpochDay());
            h.setDateDay(day);
            h.setMoney(day*SystemBootStartCode.psFaKuangBaiFenLv);
            BeanUtils.copyProperties(m, h);
            huangShuLogVoJos.add(h);
        });
        fenYeChaJianUtil.setFenYeChaJianUtil(9, huangShuLogVoJos);
        Integer indexNumber = fenYeChaJianUtil.getIndexNumber(huangShuLogVoJos.size());
        List<HuangShuLogVoJo> indexDate = fenYeChaJianUtil.getIndexDate(index);
        Integer[] length = new Integer[indexNumber];
        for (int i=0; i<(indexNumber); i++){
            length[i]=i;
        }
        model.addAttribute("book_length", length);
        model.addAttribute("JieShuLog", indexDate);
        return "log";
    }




    @ResponseBody
    @PostMapping(value = {"booksystem/jieshu_request_controller/{bkID}"})
    public Integer userJieShuBook(@PathVariable Integer bkID){
        /*
        *   描述 : 借书 ajax 用户请求, 步骤如下  1. 插入数据库的借书数据表  2. 将图书状态改为不在馆状态
        *
        *   author : zouzhu
        *
        *   time : 2019/10/16  13:42
        * */
        System.out.println("服务器接收到借书请求 bookID : " +bkID);
        Book book = bookManagerMapper.selectByIDBook(bkID);
        if (book != null){
            LocalDateTime localDateTime1 = LocalDateTime.now();
            LocalDateTime localDateTime2 = localDateTime1.plusDays(SystemBootStartCode.psBookDay);
            jieshu_book_user.insertJieShuData(
                    new JieShuData(bkID, SystemBootStartCode.id, localDateTime1 , localDateTime2, null,0)
            );
            book.setBkStatus(0);
            bookManagerMapper.updateJieShuBook(book);
            return 1;
        }else{
            return 0;
        }
    }



    @ResponseBody
    @PostMapping(value = {"/booksystem/huanshu_request_controller/{huanshu_book_ID}/{huanshu_user_ID}"})
    public Integer userHuanShuAjaxBook(@PathVariable Integer huanshu_book_ID, @PathVariable Integer huanshu_user_ID){
        System.out.println("huanshu_book_ID : " + huanshu_book_ID + "      " + "huanshu_user_ID : " + huanshu_user_ID);
        /*
        *       描述 : 还书按钮 ajax 请求, 如果在还书状态下的事务处理经过报错则返回 0，如果没有发生异常返回 1
        *             如果还书成功后, 将图书状态改为在线状态
        *
        *       author : zouzhu
        *
        *       time : 2019/10/17  20:53
        * */
        try{
            jieshu_book_user.updateJieShuDateStart(huanshu_book_ID, huanshu_user_ID);
            Book book = bookManagerMapper.selectByIDBook(huanshu_book_ID);
            System.out.println(book);
            book.setBkStatus(1);
            System.out.println(book);
            bookManagerMapper.updateJieShuBook(book);
        }catch(Exception e){
            return 0;
        }
        return 1;
    }
}
