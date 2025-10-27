package com.joinup.service.impl;

import com.joinup.dao.IUserDao;
import com.joinup.model.User;
import com.joinup.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserDao dao;

    public UserServiceImpl(IUserDao dao) { this.dao = dao; }

    @Override public List<User> getAll() { return dao.findAll(); }

    @Override public User getById(Long id) {
        return dao.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not found"));
    }

    @Override public User create(User user) {
        user.setId(null);
        return dao.save(user);
    }

    @Override public User update(Long id, User incoming) {
        User existing = getById(id);
        existing.setFirstName(incoming.getFirstName());
        existing.setLastName(incoming.getLastName());
        existing.setCompany(incoming.getCompany());
        existing.setEmail(incoming.getEmail());
        existing.setPhone(incoming.getPhone());
        existing.setRole(incoming.getRole());
        return dao.save(existing);
    }

    @Override public void delete(Long id) {
        if (!dao.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not found");
        }
    }
}
