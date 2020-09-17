package com.booleandev.data.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * App行权限
 *
 * @author Jiantao Yan
 * @title: AppAudit
 * @date 2020/9/1 16:57
 */
@Data
@Embeddable
public class AppAudit {

    @Column(name = "app_id")
    private Long appId;
}
