package main.java.com.boot.model.jpa;

import main.java.com.boot.model.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hao huang on 13/07/2016.
 */
@Entity
@Table(name="SUB_MENU")
public class SubMenu extends BaseEntity{

    private static final long serialVersionUID = 5535510054561340671L;

    @Column(name="NAME")
    private String name;

    @Column(name="URL")
    private String url;

    @Column(name="ORDER")
    private Integer order;

    @Column(name="MAIN_MENU_ID")
    private Long mainMenuId;

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

    public Long getMainMenuId() {
        return mainMenuId;
    }

    public void setMainMenuId(Long mainMenuId) {
        this.mainMenuId = mainMenuId;
    }
}
