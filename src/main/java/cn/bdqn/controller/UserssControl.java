package cn.bdqn.controller;
import cn.bdqn.pojo.Membertype;
import cn.bdqn.pojo.Role;
import cn.bdqn.pojo.Userss;
import cn.bdqn.service.houtai.UserssService;
import cn.bdqn.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    public Object login(String name, String password, HttpSession session){
        System.out.println("进入方法");
        Map<String,String> map = new HashMap<String,String>();
        String result="";
        Userss userss= userssService.findbyUserssName(name);
        try{
            if(userss!=null){
                if(userss.getUserpassword().equals(password)){
                    session.setAttribute("user",userss);
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

    /**
     *  在首页面点击后台管理跳入用户管理页面
     * @param model
     * @return
     */
    @RequestMapping("/toUserManagement")
    public String toIndex3(Model model){
        List<Object[]> list=userssService.getAllListByUsername("u");
        model.addAttribute("list",list);
        return "UserManagement";
    }
    //用户页面查询全部数据，分页，排序，模糊差
    @RequestMapping(value = "/toPage")
    @ResponseBody
    public String  testPage(){
        PageParam pp=new PageParam();
        pp.setPageNo(1);
        pp.setPageSize(2);
        Page<Userss> list= userssService.getUsersPage(pp,"n");
        for(Userss uu:list){
            System.out.println(uu.getUsername()+"====="+uu.getLastupdatetime()+"======="+uu.getRole().getRolename()+"======"+uu.getMembertype().getMembername());
        }
        return "1517cdy";
    }

    //新增用户
    //用户页面查询全部数据，分页，排序，模糊差
    @RequestMapping(value = "/toAddUserPage")
    @ResponseBody
    public String  addUserss(){
        Userss uu=new Userss();
        uu.setUserid(3);
        uu.setUsername("ls");
        uu.setAddress("河南");
        uu.setEmail("15172267807@163.com");
        uu.setEcode("036520");
        uu.setUsername("man");
        uu.setReallyname("lwj");
        uu.setIdentitycardz("1.image");
        uu.setIdentitycardf("2.image");

        Role role =new Role();
        role.setRoleid(1);
        uu.setRole(role);
        role.getUsersses().add(uu);

        Membertype mm=new Membertype();
        mm.setMemberid(2);
        mm.getUsersses().add(uu);
        uu.setMembertype(mm);

        userssService.addUserss(uu);
        return "新增";
    }
    //新增用户
    //用户页面查询全部数据，分页，排序，模糊差
    @RequestMapping(value = "/toUpdateUserPage")
    @ResponseBody
    public String  updateUserss(){
        Userss uu=new Userss();
        uu.setUserid(3);
        uu.setUsername("陈大大2");
        uu.setUserpassword("123456");
        userssService.updateUserss(uu);
        return "修改";
    }

    //删除用户
    //新增用户
    //用户页面查询全部数据，分页，排序，模糊差
    @RequestMapping(value = "/toDeleteUserPage")
    @ResponseBody
    public String  deleteUserss(){
        Userss uu=new Userss();
        uu.setUserid(3);
        userssService.deleteUserss(uu);
        return "删除";
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









    //没用，只是前期用来做多表联合查询实验
    @RequestMapping(value = "/ha2")
    @ResponseBody
    public String  userInfo2(){
        List<Object[]> list=userssService.getAllListByUsername("u");
        for(Object[] user:list){
            System.out.println(user[0]+"------  "+user[1]+"======"+user[2]+"========"+user[3]+"------  "+user[4]+"======"+user[5]+"======"+user[6]);
        }
        return "yuyyy";
    }



}