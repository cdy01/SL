package cn.bdqn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sl")
public class SLController {
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "Login";
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
    /*在首页面点击后台管理跳入用户管理页面*/
    @RequestMapping("/txxoUserManagement")
    public String toIndex4(){
        return "UserManagement";
    }
    /*在首页面点击后台管理跳入用户管理页面*/
    @RequestMapping("/txx5")
    public String toIndex5(){
        return "UserManagement";
    }

}
