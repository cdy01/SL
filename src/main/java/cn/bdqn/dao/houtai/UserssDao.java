package cn.bdqn.dao.houtai;

import cn.bdqn.pojo.Userss;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserssDao extends JpaRepository<Userss,Integer> {


    /*
     *测试分页查询
     * 自己写的，程序用不到
     */
    @Query(value = "select u.userid,u.username,u.role.rolename,u.membertype.membername,u.referrerid,u.userstatus,u.lastupdatetime from Userss u where u.username like concat('%',:uName,'%')")
    List<Object[]> getAllListByUsername(@Param("uName") String name);


    //用户增删改查----------------------------------------------------------
    /**
     * 登录方法
     * @param username
     * @return
     */
    Userss findByUsername(String username);

    /**
     * 分页，排序，按姓名模糊查
     * 用户页面查询
     * @param spec
     * @param pageable
     * @return
     */

    Page<Userss> findAll(Specification<Userss> spec, Pageable pageable);



}
