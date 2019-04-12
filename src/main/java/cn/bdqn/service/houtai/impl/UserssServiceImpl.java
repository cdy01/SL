package cn.bdqn.service.houtai.impl;

import cn.bdqn.dao.houtai.UserssDao;
import cn.bdqn.pojo.Userss;
import cn.bdqn.service.houtai.UserssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
