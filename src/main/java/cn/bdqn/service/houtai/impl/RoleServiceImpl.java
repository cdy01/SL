package cn.bdqn.service.houtai.impl;

import cn.bdqn.dao.houtai.RoleDao;
import cn.bdqn.pojo.Role;
import cn.bdqn.pojo.Userss;
import cn.bdqn.service.houtai.RoleService;
import cn.bdqn.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public Page<Role> getRolePage(PageParam pageParam) {
        Specification<Role> specification = new Specification<Role>(){
            public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb){
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
               /* if(null!=rolename && ""!=rolename){ //添加断言
                    Predicate likeNickName = cb.like(root.get("rolename").as(String.class),"%"+rolename+"%");
                    predicates.add(likeNickName);
                }*/
                return cb.and(predicates.toArray(new javax.persistence.criteria.Predicate[0]));
            }

        };
        //分页信息
        Pageable pageable = new PageRequest(pageParam.getPageNo()-1,pageParam.getPageSize(), Sort.Direction.DESC,"lastupdatetime"); //页码：前端从1开始，jpa从0开始，做个转换
        //查询
        return this.roleDao.findAll(specification,pageable);
    }

    @Override
    public void addRole(Role role) {
        try{
            roleDao.save(role);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    //业务逻辑层，更新数据时候，一定要一一判断，否者可能会把没做更改的数据全部变为空
    public void updateRole(Role role) {
        try{
            Role rr=roleDao.getOne(role.getRoleid());
            if(role.getCreatemanid()!=null){
                rr.setCreatemanid(role.getCreatemanid());
            }
            if(role.getLastupdatetime()!=null){
                rr.setLastupdatetime(role.getLastupdatetime());
            }
            if(role.getRolename()!=null && role.getRolename()!=""){
                rr.setRolename(role.getRolename());
            }
            if(role.getRoleid()!=null){
                rr.setRoleid(role.getRoleid());
            }
            if(role.getRolestatus()!=null){
                rr.setRolestatus(role.getRolestatus());
            }
            roleDao.save(rr);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRole(Role role) {
        try{
            roleDao.delete(role);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Role checkRoleByRoleid(Integer roleid) {
        Role role =roleDao.findByRoleid(roleid);
        return role;
    }
}
