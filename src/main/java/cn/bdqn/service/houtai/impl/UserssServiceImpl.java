package cn.bdqn.service.houtai.impl;

import antlr.StringUtils;
import cn.bdqn.dao.houtai.UserssDao;
import cn.bdqn.pojo.Userss;
import cn.bdqn.service.houtai.UserssService;
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
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service("userssService")
public class UserssServiceImpl implements UserssService {
    @Autowired
    private UserssDao userssDao;

    @Override
    public List<Userss> findAllUserss() {
        return userssDao.findAll();
    }

    @Override
    public Userss findbyUserssName(String userName) {
        return userssDao.findByUsername(userName);
    }

    @Override
    public List<Object[]> getAllListByUsername(String name) {
        return userssDao.getAllListByUsername(name);
    }

    @Override
    public Page<Userss> getUsersPage(PageParam pageParam, String username) {
        Specification<Userss> specification = new Specification<Userss>(){
            public Predicate toPredicate(Root<Userss> root, CriteriaQuery<?> query, CriteriaBuilder cb){
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if(null!=username && ""!=username){ //添加断言
                    Predicate likeNickName = cb.like(root.get("username").as(String.class),"%"+username+"%");
                    predicates.add(likeNickName);
                }
                return cb.and(predicates.toArray(new javax.persistence.criteria.Predicate[0]));
            }

        };
        //分页信息
        Pageable pageable = new PageRequest(pageParam.getPageNo()-1,pageParam.getPageSize(), Sort.Direction.DESC,"lastupdatetime"); //页码：前端从1开始，jpa从0开始，做个转换
        //查询
        return this.userssDao.findAll(specification,pageable);
    }

    //新增用户
    @Override
    public void addUserss(Userss uu) {
        try{
            userssDao.save(uu);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateUserss(Userss uu) {
        try{
            Userss user=userssDao.getOne(uu.getUserid());
            if(uu.getUsername()!=null && uu.getUsername()!=""){
                user.setUsername(uu.getUsername());
            }
            if(uu.getUserpassword()!=null && uu.getUserpassword()!=""){
                user.setUserpassword(uu.getUserpassword());
            }
            if(uu.getEmail()!=null && uu.getEmail()!=""){
                user.setEmail(uu.getEmail());
            }

            userssDao.save(user);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserss(Userss ss) {
        try{
            userssDao.delete(ss);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
