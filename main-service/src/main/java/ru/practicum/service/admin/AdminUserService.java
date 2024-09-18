package ru.practicum.service.admin;

import ru.practicum.exceptions.EmailExistsException;
import ru.practicum.exceptions.NotFoundException;
import ru.practicum.model.user.User;

import java.util.List;

public interface AdminUserService {

    public User create(User user) throws EmailExistsException;

    public List<User> get(List<Integer> usersId, Integer from, Integer size);

    public void delete(Integer id) throws NotFoundException;
}