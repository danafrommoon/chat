package kz.aitu.chat1906.repository;

import kz.aitu.chat1906.model.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    void delete(Users user);

    void save(Users user);
}
