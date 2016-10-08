package main.java.com.boot.model.jpa;

import main.java.com.boot.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hao huang on 20/07/2016.
 */
@Entity
@Table(name="AUTHORITY")
public class BootAuthority extends BaseEntity{

    private static final long serialVersionUID = -25938398299070864L;

    @Column(name="AUTHORITY")
    private String authority;

    @Column(name="USER_ID")
    private Long userId;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
