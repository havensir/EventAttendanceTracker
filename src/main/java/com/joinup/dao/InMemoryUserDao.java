package com.joinup.dao;

import com.joinup.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryUserDao implements IUserDao {

    private final Map<Long, User> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(seq.getAndIncrement());
        }
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public boolean deleteById(Long id) {
        return store.remove(id) != null;
    }

    @Override
    public void deleteAll() {
        store.clear();
    }

    @Override
    public long count() {
        return store.size();
    }
}
