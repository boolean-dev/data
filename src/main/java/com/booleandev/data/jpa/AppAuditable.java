package com.booleandev.data.jpa;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: AppAuditable
 * @date 2020/9/1 17:05
 */
public interface AppAuditable {
    /**
     *
     * @return
     */
    AppAudit getAppAudit();

    /**
     *
     * @param appAudit
     */
    void setAppAudit(AppAudit appAudit);
}
