package cn.bdqn.dao.houtai;
import cn.bdqn.pojo.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Integer> {
    /**
     * 分页，排序，
     * 角色页面查询
     * @param spec
     * @param pageable
     * @return
     */

    Page<Role> findAll(Specification<Role> spec, Pageable pageable);
    /**
     * 异步验证角色编号是否唯一
     *
     */
    Role findByRoleid(Integer roleid);
}
