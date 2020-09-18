package com.booleandev.data.entity;

import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * order
 *
 * @author Jiantao Yan
 * @title: Order
 * @date 2020/8/13 22:03
 */
@Data
@Entity
public class User extends AppBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String email;
}
