package main.java.com.boot.dto;

import java.util.Collection;
import java.util.Date;

/**
 * Created by hao huang on 14/07/2016.
 */
public class MenuDto extends BaseDto{

    private String name;

    private String url;

    private Integer order;

    private String flagActive;

    private String activeDate;

    private Collection<SubMenuDto> subMenuDtos;

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

    public String getFlagActive() {
        return flagActive;
    }

    public void setFlagActive(String flagActive) {
        this.flagActive = flagActive;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public Collection<SubMenuDto> getSubMenuDtos() {
        return subMenuDtos;
    }

    public void setSubMenuDtos(Collection<SubMenuDto> subMenuDtos) {
        this.subMenuDtos = subMenuDtos;
    }
}
