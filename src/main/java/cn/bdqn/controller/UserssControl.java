package cn.bdqn.controller;

import cn.bdqn.pojo.Userss;
import cn.bdqn.service.houtai.UserssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserssControl {
    @Autowired
    private UserssService userssService;

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "Login";
    }
    @RequestMapping("/toIndex2")
    @ResponseBody
    public Object toIndex2(){
        List<Userss> list=userssService.findAllUserss();
        for(Userss uu:list){
            System.out.println(uu.getReallyname()+"\t"+uu.getEmail());
        }
        return "xxx";
    }
}
