package com.booleandev.data.dao;

import com.booleandev.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: UserRepository
 * @date 2020/8/13 22:12
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
