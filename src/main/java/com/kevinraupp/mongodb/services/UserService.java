package com.kevinraupp.mongodb.services;

import com.kevinraupp.mongodb.domain.User;
import com.kevinraupp.mongodb.dto.UserDTO;
import com.kevinraupp.mongodb.repository.UserRepository;
import com.kevinraupp.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findByID(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Id not found"));
    }
    public User insert(User user){
        return userRepository.insert(user);
    }
    public void delete(String id){
        findByID(id);
        userRepository.deleteById(id);
    }
    public User update(User user){
        User newOjb = userRepository.findById(user.getId()).get();
        updateData(newOjb,user);
        return userRepository.save(newOjb);
    }

    private void updateData(User newOjb, User user) {
        newOjb.setName(user.getName());
        newOjb.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getName(),userDTO.getEmail());
    }
}
