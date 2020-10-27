package com.booleandev.data.controller;

import com.booleandev.data.dao.UserRepository;
import com.booleandev.data.entity.Account;
import com.booleandev.data.entity.User;
import com.booleandev.data.service.AccountService;
import com.booleandev.data.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: UserController
 * @date 2020/8/13 22:14
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountService accountService;

    @PostMapping("/")
    public User insert(@RequestBody User user) {



        log.info("------>user={}", user);
        user.setEmail("--" + System.currentTimeMillis());
        return userRepository.save(user);
    }

    @GetMapping("/")
    public List<Account> list() {
        return accountService.findAll();
    }
}
