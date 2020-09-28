package com.booleandev.data.dao;

import com.booleandev.data.aop.DbFilter;
import com.booleandev.data.entity.User;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: UserRepository
 * @date 2020/8/13 22:12
 */
@Repository
@DbFilter()
public class UserRepository extends BaseRepository<User, Long> {

    public UserRepository() {
        super(User.class);
    }
}
