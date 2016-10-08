package main.java.com.boot.model.jpa;

import main.java.com.boot.common.Constants;
import org.hibernate.annotations.Fetch;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by hao huang on 28/06/2016.
 */
@Entity
@Table(name = "USER")
public class User implements Serializable{

    private static final long serialVersionUID = 9199384938757913631L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="CODE")
    private String code;

    @Column(name="NAME")
    private String name;

    @Column(name="PASSWORD")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Collection<BootAuthority> bootAuthorities;

    public User() {
    }

    public User(String code, String name, String password) {
        this.code = code;
        this.name = name;
        this.password = new BCryptPasswordEncoder().encode(password+ Constants.SECURITY_SALT);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<BootAuthority> getBootAuthorities() {
        return bootAuthorities;
    }

    public void setBootAuthorities(Collection<BootAuthority> bootAuthorities) {
        this.bootAuthorities = bootAuthorities;
    }

    @Override
    public String toString() {
        return "User[id:"+id+",code:"+code+",name:"+name+"]";
    }
}
