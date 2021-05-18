package crud.dao;

import crud.model.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUser(int id);
    void add(User user);
    void update(User user);
    void delete (int id);
}
