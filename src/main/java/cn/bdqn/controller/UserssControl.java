package cn.bdqn.controller;

import cn.bdqn.pojo.Userss;
import cn.bdqn.service.houtai.UserssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserssControl {
    @Autowired
    private UserssService userssService;

    //进入页面，系统入口
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "Login";
    }

    //异步验证用户名密码
    @RequestMapping("/checkLogin")
    @ResponseBody
    public Object login(String name,String password){
        System.out.println("进入方法");
        Map<String,String> map = new HashMap<String,String>();
        String result="";
        Userss userss= userssService.findbyUserssName(name);
        try{
            if(userss!=null){
                if(userss.getUserpassword().equals(password)){
                    result="yes";
                }else{
                    result="no";
                }
            }else{
                result="noexist";
            }
        }catch(Exception e){
            result="excep";
            e.printStackTrace();
        }
        map.put("result",result);
        System.out.println(result);
        return map;
    }

    /*跳转到首页面*/
    @RequestMapping("/toIndex2")
    public String toIndex2(){
        return "SystemLoginDefaultPage";
    }
    /*在首页面点击后台管理跳入用户管理页面*/
    @RequestMapping("/toUserManagement")
    public String toIndex3(){
        return "UserManagement";
    }
    /*在首页面点击角色管理跳入角色管理页面*/
    @RequestMapping("/toRoleManagement")
    public String toIndex4(){
        return "RoleManagement";
    }
    /*在首页面点击权限管理跳入权限管理页面*/
    @RequestMapping("/toAccessManagement")
    public String toIndex5(){
        return "AccessManagement";
    }
    /*在首页面点击权限管理跳入权限管理页面*/
    @RequestMapping("/toAnnouncementManagement")
    public String toIndex6(){
        return "AnnouncementManagement";
    }
}
