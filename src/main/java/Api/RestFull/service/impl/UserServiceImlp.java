package Api.RestFull.service.impl;

import Api.RestFull.model.User;
import Api.RestFull.repository.UserRepository;
import Api.RestFull.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImlp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImlp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw  new IllegalArgumentException("this Account number already exists");
        }
        return userRepository.save(userToCreate);
    }
}
