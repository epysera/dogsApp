package pl.coderslab.dogs.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.coderslab.dogs.entity.Role;
import pl.coderslab.dogs.entity.User;
import pl.coderslab.dogs.repository.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
@Component
public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);

    void saveAdmin(User user);

    void deleteUser(User user);

}
