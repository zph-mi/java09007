package com.offcn.controller;

import com.offcn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller  //使用thymeleaf的时候不能用@RestController
public class TestController {

    @RequestMapping("/hello")
    public String index(Model model){
        model.addAttribute("message","欢迎来到王者荣耀");
        return "index01";
    }

    @RequestMapping("/findOne")
    public String findOne(Model model){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setAge(20);

        Map<String,Object> map = new HashMap<>();
        map.put("id","1");
        map.put("name","李四");
        map.put("sex","男");

        model.addAttribute("map",map);
        model.addAttribute("user",user);
        return "index02";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
        User user1 = new User();
        user1.setId(1);
        user1.setName("张三");
        user1.setAge(20);

        User user2 = new User();
        user2.setId(2);
        user2.setName("李四");
        user2.setAge(30);

        User user3 = new User();
        user3.setId(3);
        user3.setName("王五");
        user3.setAge(40);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        model.addAttribute("userList",userList);
        return "index03";
    }

    @RequestMapping("/index04")
    public String index04(Model model){
        model.addAttribute("message","欢迎来到王者荣耀");
        return "index04";
    }

    @RequestMapping("/index05")
    public String index05(Model model){
        model.addAttribute("flag","yes");

        model.addAttribute("menu","admin");
        model.addAttribute("manager","manager");

        return "index05";
    }

    @GetMapping("/index06")
    public String index06(Model model) {
        //日期时间
        Date date = new Date();
        model.addAttribute("date", date);
        //小数的金额
        double price = 123.456;
        model.addAttribute("number", price);
        //定义大文本数据
        String str = "Thymeleaf是Web和独立环境的现代服务器端Java模板引擎，能够处理HTML，XML，JavaScript，CSS甚至纯文本。\r\n" +
                "Thymeleaf的主要目标是提供一种优雅和高度可维护的创建模板的方式。为了实现这一点，它建立在自然模板的概念上，将其逻辑注入到模板文件中，不会影响模板被用作设计原型。这改善了设计的沟通，弥补了设计和开发团队之间的差距。\r\n" +
                "Thymeleaf也从一开始就设计了Web标准 - 特别是HTML5 - 允许您创建完全验证的模板，如果这是您需要的\r\n";
        model.addAttribute("str", str);
        return "index06";
    }

}
