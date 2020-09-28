package com.booleandev.data.filter;

import com.booleandev.data.enums.FilterType;

/**
 * 行权限拦截器顶层接口
 *
 * @author Jiantao Yan
 * @title: IFilter
 * @date 2020/9/28 15:32
 */
public interface IFilter {

    /**
     * 拦截器的类型
     * @return  filterType
     */
    FilterType getType();
}
