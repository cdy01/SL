package cn.bdqn.dao.houtai;

import cn.bdqn.pojo.Userss;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserssDao extends JpaRepository<Userss,Integer> {
    Userss findByUsername(String username);
}
