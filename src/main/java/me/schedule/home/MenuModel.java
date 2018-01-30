package me.schedule.home;

import org.nutz.dao.entity.annotation.Table;

@Table("tbl_menu")
public class MenuModel {
    private String memuId;
    private String menuTitle;
    private String menuIcon;
    private int menuLevel;
    private String parentId;
    private String menuUrl;

    public String getMemuId() {
        return memuId;
    }

    public void setMemuId(String memuId) {
        this.memuId = memuId;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
