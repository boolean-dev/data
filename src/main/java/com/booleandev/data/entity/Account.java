package com.booleandev.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: Account
 * @date 2020/8/14 11:49
 */

@Data
@Entity
public class Account implements AppFilterInter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long appId;

    private String name;

    private Integer age;

    private String email;
}
