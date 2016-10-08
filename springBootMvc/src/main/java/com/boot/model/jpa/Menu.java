package main.java.com.boot.model.jpa;

import main.java.com.boot.model.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by hao huang on 13/07/2016.
 */
@Entity
@Table(name="MENU")
public class Menu extends BaseEntity{

    private static final long serialVersionUID = 2827009934261484042L;

    @Column(name="NAME")
    private String name;

    @Column(name="URL")
    private String url;

    @Column(name="ORDER")
    private Integer order;

    @Column(name="FLAG_ACTIVE")
    @Type(type = "yes_no")
    private boolean flagActive;

    @Column(name="ACTIVE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activeDate;

    @OneToMany
    @JoinColumn(name = "MAIN_MENU_ID", referencedColumnName = "ID")
    private Collection<SubMenu> subMenus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public boolean isFlagActive() {
        return flagActive;
    }

    public void setFlagActive(boolean flagActive) {
        this.flagActive = flagActive;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Collection<SubMenu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(Collection<SubMenu> subMenus) {
        this.subMenus = subMenus;
    }
}
