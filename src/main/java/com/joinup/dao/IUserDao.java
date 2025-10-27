package com.joinup.dao;

import com.joinup.model.User;
import java.util.List;
import java.util.Optional;

public interface IUserDao {
    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);       // create or update (by id)
    boolean deleteById(Long id);
    void deleteAll();
    long count();
}
