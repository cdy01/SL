package cn.bdqn.service.houtai;

import cn.bdqn.pojo.Userss;
import cn.bdqn.util.PageParam;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserssService {
    List<Userss> findAllUserss();
    List<Object[]> getAllListByUsername(String name);

    //用户增删改查----------------
    //1.登录
    Userss findbyUserssName(String userName);
    //查询用户，分页模糊 排序
    Page<Userss> getUsersPage(PageParam pageParam, String username);
    //新增用户
    void addUserss(Userss uu);
    //修改用户
    void updateUserss(Userss uu);
    //删除用户
    void deleteUserss(Userss ss);

}
