package com.booleandev.data.service;

import com.booleandev.data.aop.FtlFilter;
import com.booleandev.data.dao.UserRepository;
import com.booleandev.data.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: UserService
 * @date 2020/8/13 22:13
 */

@Slf4j
@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private EntityManager entityManager;

    @FtlFilter(entities = User.class)
    public List<User> findAll() {
//        accountService.findAll();111
        log.info(entityManager.toString());
        return userRepository.findAll();
    }
}
