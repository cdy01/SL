package cn.bdqn.service.houtai;

import cn.bdqn.pojo.Role;
import cn.bdqn.util.PageParam;
import org.springframework.data.domain.Page;

public interface RoleService {
    //查询用户，分页模糊 排序
    Page<Role> getRolePage(PageParam pageParam);
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(Role role);
    Role checkRoleByRoleid(Integer roleid);
}
