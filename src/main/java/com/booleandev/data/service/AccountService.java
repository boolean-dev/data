package com.booleandev.data.service;

import com.booleandev.data.aop.DbFilter;
import com.booleandev.data.dao.AccountRepository;
import com.booleandev.data.entity.Account;
import com.booleandev.data.enums.FilterType;
import com.booleandev.data.filter.EnableFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: AccountService
 * @date 2020/8/14 11:51
 */
@Slf4j
@Service
@DbFilter(filters = FilterType.APP)
public class AccountService implements EnableFilter<Account> {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Class<Account> getDomainClass() {
        return Account.class;
    }
}
