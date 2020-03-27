package booksList.service;

import booksList.model.User;
import booksList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    public User findByUsername(String username){
        return userRepository.findById(username).get();
    }
}
