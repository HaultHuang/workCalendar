package main.java.com.boot.dto;

/**
 * Created by hao huang on 14/07/2016.
 */
public class SubMenuDto extends BaseDto{

    private String name;

    private String url;

    private Integer order;

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
