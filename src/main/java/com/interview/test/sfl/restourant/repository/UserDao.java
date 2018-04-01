package com.interview.test.sfl.restourant.repository;

import com.interview.test.sfl.restourant.model.User;
import com.interview.test.sfl.restourant.model.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {
    List<User> findUserByUserType(UserType userType);
}
