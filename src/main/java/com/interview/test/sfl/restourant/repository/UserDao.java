package com.interview.test.sfl.restourant.repository;

import com.interview.test.sfl.restourant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
