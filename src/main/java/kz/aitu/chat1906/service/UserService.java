package kz.aitu.chat1906.service;

import kz.aitu.chat1906.model.Users;
import kz.aitu.chat1906.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public void add(Users user) {
        userRepository.save(user);
    }

    @Override
    public ResponseEntity<?> edit(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(Users user) throws NullIdException {
        if (user.getId() == null) throw new NullIdException();
        userRepository.save(user);
    }

    @Override
    public void delete(Users user) throws NullIdException {
        if (user.getId() == null) throw new NullIdException();
        userRepository.delete(user);
    }
}