package lt.codeacademy.rest.services;

import lt.codeacademy.rest.entities.Role;
import lt.codeacademy.rest.entities.User;
import lt.codeacademy.rest.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Set<Role> findRoleByName(Set<String> roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles) {
            roleSet.add(roleRepository.findAllRoleByRole(role));
        }
        return roleSet;
    }

}
