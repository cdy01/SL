package cn.bdqn.controller;

import cn.bdqn.pojo.Role;
import cn.bdqn.pojo.Userss;
import cn.bdqn.service.houtai.RoleService;
import cn.bdqn.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    //用户页面查询全部数据，分页，排序
    @RequestMapping(value = "/toPage")
    @ResponseBody
    public String  testPage(){
        PageParam pp=new PageParam();
        pp.setPageNo(1);
        pp.setPageSize(2);
        Page<Role> list= roleService.getRolePage(pp);
        System.out.println(list.getSize());
        for(Role role:list){
            System.out.println(role.getRolename()+"====="+role.getCreatemanid()+"======="+role.getLastupdatetime());
        }
        return "roleListPage";
    }
    //用户页面查询全部数据，分页，排序
    @RequestMapping(value = "/toAddPage")
    @ResponseBody
    public String  testAddRole(){
        Role role =new Role();
        role.setRoleid(3);
        role.setRolename("会员他爹");
        //角色状态，这里页面有选择
        role.setRolestatus(1);
        role.setLastupdatetime(new Date());
        //这里为创始人id,默认当前登录系统管理员编号
        //这里我没法定义
       /* role.setCreatemanid();*/
        roleService.addRole(role);
        return "addRolePage";
    }
    //用户页面查询全部数据，分页，排序
    @RequestMapping(value = "/toUpdatePage")
    @ResponseBody
    public String  testUpdateRole(){
        Role role =new Role();
        role.setRoleid(3);
        role.setRolename("会员他爹");
       /* role.setCreatemanid(2);*/
        roleService.updateRole(role);
        return "updateRolePage";
    }
    //用户页面查询全部数据，分页，排序
    @RequestMapping(value = "/toDeletePage")
    @ResponseBody
    public String  testDeletePage(){
        Role role =new Role();
        role.setRoleid(3);
        roleService.deleteRole(role);
        return "deleteRolePage";
    }

    //异步验证角色编号是否存在
    @RequestMapping(value = "/checkRoleId")
    @ResponseBody
    public Object  testCheckRoleId(){
        Map<String,Object> strMap=new HashMap<String,Object>();
        String result="";
        try{
            Role role=roleService.checkRoleByRoleid(3);
            if(role!=null){
                result="exist";
            }else{
                result="noexist";
            }
        }
        catch(Exception e){
            e.printStackTrace();
            result="excep";
        }
        strMap.put("result",result);
        return strMap.get("result");
    }
}
