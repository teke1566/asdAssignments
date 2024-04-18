package edu.miu.cs489.ads.services;

import edu.miu.cs489.ads.model.User;
import edu.miu.cs489.ads.repository.UserRepository;
import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

   public User updateUser(Long id , User users){
        User users1=userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not Found" +id));
        return userRepository.save(users1);

   }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

