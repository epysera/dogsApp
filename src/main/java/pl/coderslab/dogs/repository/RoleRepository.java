package pl.coderslab.dogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dogs.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
