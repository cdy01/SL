package cn.bdqn.pojo;

import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name="USERSS")
/*@Proxy(lazy = false)*/ //关闭延迟加载，不然测试单元总是报错
public class Userss {
    private Integer userid;
    private Integer roleid;
    private Integer referrerid;
    private Integer userstatus;
    private String username;
    private String reallyname;
    private String userpassword;
    private String usercountpasswword;
    private String email;
    private String telephone;
    private String ecode;
    private String address;
    private String accountbank;
    private String accountnum;
    private String accountman;
    private String bankcard;
    private Long banksurplusmoney;
    private Long identitycard;
    private String identitycardz;
    private String identitycardf;
    private Time lastupdatetime;
    private Integer identitysign;
    private Integer membertypeid;
    private Integer basicbank;

    @Id
    @Column(name = "USERID", nullable = false, precision = 0)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "ROLEID", nullable = true, precision = 0)
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Basic
    @Column(name = "REFERRERID", nullable = true, precision = 0)
    public Integer getReferrerid() {
        return referrerid;
    }

    public void setReferrerid(Integer referrerid) {
        this.referrerid = referrerid;
    }

    @Basic
    @Column(name = "USERSTATUS", nullable = true, precision = 0)
    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    @Basic
    @Column(name = "USERNAME", nullable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "REALLYNAME", nullable = true, length = 20)
    public String getReallyname() {
        return reallyname;
    }

    public void setReallyname(String reallyname) {
        this.reallyname = reallyname;
    }

    @Basic
    @Column(name = "USERPASSWORD", nullable = true, length = 20)
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Basic
    @Column(name = "USERCOUNTPASSWWORD", nullable = true, length = 20)
    public String getUsercountpasswword() {
        return usercountpasswword;
    }

    public void setUsercountpasswword(String usercountpasswword) {
        this.usercountpasswword = usercountpasswword;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "TELEPHONE", nullable = true, length = 20)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "ECODE", nullable = true, length = 20)
    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = true, length = 20)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "ACCOUNTBANK", nullable = true, length = 20)
    public String getAccountbank() {
        return accountbank;
    }

    public void setAccountbank(String accountbank) {
        this.accountbank = accountbank;
    }

    @Basic
    @Column(name = "ACCOUNTNUM", nullable = true, length = 20)
    public String getAccountnum() {
        return accountnum;
    }

    public void setAccountnum(String accountnum) {
        this.accountnum = accountnum;
    }

    @Basic
    @Column(name = "ACCOUNTMAN", nullable = true, length = 20)
    public String getAccountman() {
        return accountman;
    }

    public void setAccountman(String accountman) {
        this.accountman = accountman;
    }

    @Basic
    @Column(name = "BANKCARD", nullable = true, length = 255)
    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    @Basic
    @Column(name = "BANKSURPLUSMONEY", nullable = true, precision = 0)
    public Long getBanksurplusmoney() {
        return banksurplusmoney;
    }

    public void setBanksurplusmoney(Long banksurplusmoney) {
        this.banksurplusmoney = banksurplusmoney;
    }

    @Basic
    @Column(name = "IDENTITYCARD", nullable = true, precision = 0)
    public Long getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(Long identitycard) {
        this.identitycard = identitycard;
    }

    @Basic
    @Column(name = "IDENTITYCARDZ", nullable = true, length = 255)
    public String getIdentitycardz() {
        return identitycardz;
    }

    public void setIdentitycardz(String identitycardz) {
        this.identitycardz = identitycardz;
    }

    @Basic
    @Column(name = "IDENTITYCARDF", nullable = true, length = 255)
    public String getIdentitycardf() {
        return identitycardf;
    }

    public void setIdentitycardf(String identitycardf) {
        this.identitycardf = identitycardf;
    }

    @Basic
    @Column(name = "LASTUPDATETIME", nullable = true)
    public Time getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Time lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    @Basic
    @Column(name = "IDENTITYSIGN", nullable = true, precision = 0)
    public Integer getIdentitysign() {
        return identitysign;
    }

    public void setIdentitysign(Integer identitysign) {
        this.identitysign = identitysign;
    }

    @Basic
    @Column(name = "MEMBERTYPEID", nullable = true, precision = 0)
    public Integer getMembertypeid() {
        return membertypeid;
    }

    public void setMembertypeid(Integer membertypeid) {
        this.membertypeid = membertypeid;
    }

    @Basic
    @Column(name = "BASICBANK", nullable = true, precision = 0)
    public Integer getBasicbank() {
        return basicbank;
    }

    public void setBasicbank(Integer basicbank) {
        this.basicbank = basicbank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userss userss = (Userss) o;
        return Objects.equals(userid, userss.userid) &&
                Objects.equals(roleid, userss.roleid) &&
                Objects.equals(referrerid, userss.referrerid) &&
                Objects.equals(userstatus, userss.userstatus) &&
                Objects.equals(username, userss.username) &&
                Objects.equals(reallyname, userss.reallyname) &&
                Objects.equals(userpassword, userss.userpassword) &&
                Objects.equals(usercountpasswword, userss.usercountpasswword) &&
                Objects.equals(email, userss.email) &&
                Objects.equals(telephone, userss.telephone) &&
                Objects.equals(ecode, userss.ecode) &&
                Objects.equals(address, userss.address) &&
                Objects.equals(accountbank, userss.accountbank) &&
                Objects.equals(accountnum, userss.accountnum) &&
                Objects.equals(accountman, userss.accountman) &&
                Objects.equals(bankcard, userss.bankcard) &&
                Objects.equals(banksurplusmoney, userss.banksurplusmoney) &&
                Objects.equals(identitycard, userss.identitycard) &&
                Objects.equals(identitycardz, userss.identitycardz) &&
                Objects.equals(identitycardf, userss.identitycardf) &&
                Objects.equals(lastupdatetime, userss.lastupdatetime) &&
                Objects.equals(identitysign, userss.identitysign) &&
                Objects.equals(membertypeid, userss.membertypeid) &&
                Objects.equals(basicbank, userss.basicbank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, roleid, referrerid, userstatus, username, reallyname, userpassword, usercountpasswword, email, telephone, ecode, address, accountbank, accountnum, accountman, bankcard, banksurplusmoney, identitycard, identitycardz, identitycardf, lastupdatetime, identitysign, membertypeid, basicbank);
    }
}
