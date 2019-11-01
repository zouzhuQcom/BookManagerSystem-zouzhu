package com.zouzhu.controller;


import com.zouzhu.dao.mapperImp.UserMessageMapperImp;
import com.zouzhu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserYanZhangController {

    /*
    *       描述 : 用户身份验证请求类
    *
    *       author : zouzhu
    *
    *       time : 2019/10/11  16:07
    * */

    @Autowired
    private UserMessageMapperImp userMessageMapperImp;

    @RequestMapping(value = {"/booksystem/userlogin"})
    public String userLoginYangZheng(User user, Model model){
        /*
        *   描述 : 用户登录验证的实际方法, 如果用户登录成功服务器会向浏览器发送一个 Cookie 身份认证给予一些权限
        *
        *   author : zouzhu
        *
        *   time : 2019/10/11   17:14
        * */
        System.out.println("user : " + user.getUsName() + "; password : " + user.getUsPassword());
        User u = userMessageMapperImp.selectAllByNameUserAndType(user);
        if (u!=null){
            if (u.getPsType()==1015){
                /* 管理员身份 */
                SystemBootStartCode.code=909;                                        // 设置系统状态码
                SystemBootStartCode.id=u.getUsID();                                  // 设置用户 ID
                SystemBootStartCode.name=u.getUsName();                              // 设置用户名称
                SystemBootStartCode.psType=u.getPsType();                            // 设置用户身份ID
                SystemBootStartCode.psTypeName=u.getPsTypeName();                    // 设置用户身份名称
                SystemBootStartCode.psBookNumber=u.getPsBookNumber();                // 设置最大借书数量
                SystemBootStartCode.psBookDay=u.getPsBookDay();                      // 设置用户最长结束时间
                SystemBootStartCode.psFaKuangBaiFenLv=u.getPsFaKuangBaiFenLv();      // 设置用户图书的违章罚款
                SystemBootStartCode.psZhengJiangData=u.getPsZhengJiangData();        // 设置证件的到期时间
            }else{
                SystemBootStartCode.code=606;                                        // 设置系统状态码
                SystemBootStartCode.id=u.getUsID();                                  // 设置用户 ID
                SystemBootStartCode.name=u.getUsName();                              // 设置用户名称
                SystemBootStartCode.psType=u.getPsType();                            // 设置用户身份ID
                SystemBootStartCode.psTypeName=u.getPsTypeName();                    // 设置用户身份名称
                SystemBootStartCode.psBookNumber=u.getPsBookNumber();                // 设置最大借书数量
                SystemBootStartCode.psBookDay=u.getPsBookDay();                      // 设置用户最长结束时间
                SystemBootStartCode.psFaKuangBaiFenLv=u.getPsFaKuangBaiFenLv();      // 设置用户图书的违章罚款
                SystemBootStartCode.psZhengJiangData=u.getPsZhengJiangData();        // 设置证件的到期时间
            }
            return "redirect:/index";
        }else {
            return "登录失败 !";
        }
    }

    @GetMapping(value = "booksystem/userzhuxiao")
    public String userLoginZhuXiao(){
        SystemBootStartCode.code=608;                                        // 设置系统状态码
        SystemBootStartCode.id=null;                                         // 设置用户 ID
        SystemBootStartCode.name=null;                                       // 设置用户名称
        SystemBootStartCode.psType=null;                                     // 设置用户身份ID
        SystemBootStartCode.psTypeName=null;                                 // 设置用户身份名称
        SystemBootStartCode.psBookNumber=null;                               // 设置最大借书数量
        SystemBootStartCode.psBookDay=null;                                  // 设置用户最长结束时间
        SystemBootStartCode.psFaKuangBaiFenLv=null;                          // 设置用户图书的违章罚款
        SystemBootStartCode.psZhengJiangData=null;                           // 设置证件的到期时间
        return "redirect:/index";
    }



    @ResponseBody
    @RequestMapping(value = {"booksystem/userZhuCeLiuCheng"})
    public String userZhuCeLiuCheng(User user){
        /*
        *   描述 ： 用户注册方法
        *
        *   author : zouzhu
        *
        *   time : 2019/10/11  17:31
        * */
        userMessageMapperImp.userAddMessage(user);
        return "注册成功 !";
    }


    @ResponseBody
    @GetMapping(value = {"/user/login/test"})
    public User selectAllByNameUserAndType(User user){
        /*
        *   描述：登录功能测试类，包括了查询用户数据表和用户数据类型表
        *
        *   function : test
        *
        *   author : zouzhu
        *
        *   time : 2019/10/16  19:21
        * */
        return userMessageMapperImp.selectAllByNameUserAndType(user);
    }

}
