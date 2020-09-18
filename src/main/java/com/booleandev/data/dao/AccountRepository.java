package com.booleandev.data.dao;

import com.booleandev.data.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: AccountRepository
 * @date 2020/8/14 11:49
 */
@Repository
public class AccountRepository extends BaseRepository<Account, Long> {

    public AccountRepository() {
        super(Account.class);
    }
}
