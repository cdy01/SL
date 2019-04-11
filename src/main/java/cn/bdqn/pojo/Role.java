package cn.bdqn.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Role {
    private Integer roleid;
    private String rolename;
    private Integer createmanid;
    private Integer rolestatus;
    private Time lastupdatetime;

    @Id
    @Column(name = "ROLEID", nullable = false, precision = 0)
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Basic
    @Column(name = "ROLENAME", nullable = true, length = 20)
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Basic
    @Column(name = "CREATEMANID", nullable = true, precision = 0)
    public Integer getCreatemanid() {
        return createmanid;
    }

    public void setCreatemanid(Integer createmanid) {
        this.createmanid = createmanid;
    }

    @Basic
    @Column(name = "ROLESTATUS", nullable = true, precision = 0)
    public Integer getRolestatus() {
        return rolestatus;
    }

    public void setRolestatus(Integer rolestatus) {
        this.rolestatus = rolestatus;
    }

    @Basic
    @Column(name = "LASTUPDATETIME", nullable = true)
    public Time getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Time lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleid, role.roleid) &&
                Objects.equals(rolename, role.rolename) &&
                Objects.equals(createmanid, role.createmanid) &&
                Objects.equals(rolestatus, role.rolestatus) &&
                Objects.equals(lastupdatetime, role.lastupdatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleid, rolename, createmanid, rolestatus, lastupdatetime);
    }
}
