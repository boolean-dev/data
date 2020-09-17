package com.booleandev.data.jpa;


import javax.persistence.PrePersist;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: AppAuditListener
 * @date 2020/9/1 16:59
 */
public class AppAuditListener {

    @PrePersist
    public void setAppId ( AppAuditable appAuditable) {
        AppAudit appAudit = appAuditable.getAppAudit();

        if (appAudit == null) {
            appAudit = new AppAudit();
            appAuditable.setAppAudit(appAudit);
        }

        appAudit.setAppId(2L);
    }
}
