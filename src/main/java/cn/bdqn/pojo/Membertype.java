package cn.bdqn.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="MEMBERTYPE")
public class Membertype {

    private Integer memberid;
    private String membername;
    private Set<Userss> usersses=new HashSet<Userss>();

    @OneToMany(mappedBy = "membertype",cascade = CascadeType.ALL)
    public Set<Userss> getUsersses() {
        return usersses;
    }

    public void setUsersses(Set<Userss> usersses) {
        this.usersses = usersses;
    }

    @Id
    @Column(name = "MEMBERID", nullable = false, precision = 0)
    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    @Basic
    @Column(name = "MEMBERNAME", nullable = true, length = 20)
    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membertype that = (Membertype) o;
        return Objects.equals(memberid, that.memberid) &&
                Objects.equals(membername, that.membername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberid, membername);
    }
}
