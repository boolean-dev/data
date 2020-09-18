package com.booleandev.data.filter;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: FtlFilter
 * @date 2020/9/17 16:38
 */
public interface EnableFilter<T> {

    /**
     * 获取开始 Filter 的实体类
     * @return  entity class
     */
    Class<T> getDomainClass();
}
