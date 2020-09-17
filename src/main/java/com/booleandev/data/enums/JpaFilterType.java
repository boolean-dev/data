package com.booleandev.data.enums;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: JpaFilterType
 * @date 2020/9/17 16:00
 */
public enum  JpaFilterType {

    /**
     * APP: app行权限
     * CLIENT: client 行权限
     */
    NONE(0, "none"),
    APP(1,"appFilter"),
    CLIENT(2,"clientFilter");

    private int value;
    private String name;

    JpaFilterType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
