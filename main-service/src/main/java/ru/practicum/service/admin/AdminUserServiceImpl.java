package ru.practicum.service.admin;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.exceptions.EmailExistsException;
import ru.practicum.exceptions.NotFoundException;
import ru.practicum.model.user.User;
import ru.practicum.repository.UserRepository;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    UserRepository repository;

    @Override
    public User create(User user) throws EmailExistsException {
        try {
            return repository.save(user);
        } catch (ConstraintViolationException e) {
            throw new EmailExistsException(e.getMessage());
        }
    }

    @Override
    public List<User> get(List<Integer> usersId, Integer from, Integer size) {
        Pageable pageable = PageRequest.of(from / size, size);
        if (usersId != null) {
            return repository.findAllById(usersId);
        }
        return repository.findAll(pageable).toList();
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        User user = repository.findById(id).orElseThrow(() -> new NotFoundException("User with id " + id +
                " was not found"));
        repository.delete(user);
    }
}