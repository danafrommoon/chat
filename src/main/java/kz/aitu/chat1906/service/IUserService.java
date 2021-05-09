package kz.aitu.chat1906.service;

import kz.aitu.chat1906.model.Users;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUserService {
    UserService userService = new UserService();
    @PostMapping("")
    public static void add(@RequestBody Users user) {
        userService.add(user);
        ResponseEntity.ok("User successfully added");
    }

    @PutMapping("")
    public static ResponseEntity<?> edit(@RequestBody Users user) {
        try {
            userService.update(user);
        } catch (NullIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(user);
    }

    void add(Users user);

    List<User> getAll();

    @DeleteMapping("")
    public void delete(@RequestBody User user) {
        try {
            userService.delete(user);
        } catch (NullIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User successfully deleted");
    }

    void update(Users user) throws NullIdException;

    void delete(Users user) throws NullIdException;
}
