package com.rahi.springsecurityc2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

/**
 * @Author Amimul Ehsan
 * @Created at 10/21/21
 * @Project spring-security-c1
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    private String userName;
    private String password;
}
