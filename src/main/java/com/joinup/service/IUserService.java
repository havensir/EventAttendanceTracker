package com.joinup.service;

import com.joinup.model.User;
import java.util.List;

public interface IUserService {
    List<User> getAll();
    User getById(Long id);
    User create(User user);
    User update(Long id, User user);
    void delete(Long id);
}
