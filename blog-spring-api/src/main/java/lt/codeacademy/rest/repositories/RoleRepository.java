package lt.codeacademy.rest.repositories;

import lt.codeacademy.rest.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findAllRoleByRole(String role);
}