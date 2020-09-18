package com.booleandev.data.dao;

import com.booleandev.data.aop.DbFilter;
import com.booleandev.data.entity.User;
import com.booleandev.data.enums.JpaFilterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
