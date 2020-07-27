package lt.codeacademy.rest.services;

import lt.codeacademy.rest.entities.Customer;
import lt.codeacademy.rest.entities.User;
import lt.codeacademy.rest.repositories.CustomerRepository;
import lt.codeacademy.rest.repositories.UserRepository;
import lt.codeacademy.rest.services.exceptions.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserDetailsServiceImpl(UserRepository userRepository,
                                  CustomerRepository customerRepository,
                                  RoleService roleService,
                                  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user found by name: " + username));
    }

    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " was not found"));
    }

    public Optional<Customer> getCustomerByUserId(Long id) {
        return customerRepository.findById(id);
    }

}
