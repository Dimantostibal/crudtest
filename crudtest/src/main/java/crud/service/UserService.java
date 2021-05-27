package crud.service;

import crud.model.User;
import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    User getUser(Long id);
    void add(User user);
    void update(User user);
    void delete (Long id);
}
