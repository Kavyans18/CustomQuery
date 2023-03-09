package com.pw.custom_query.service;

import com.pw.custom_query.entity.User;
import com.pw.custom_query.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository repository;
    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user, int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        User us = optional.get();
        us.setFirstName(user.getFirstName());
        us.setLastName(user.getLastName());
        us.setGender(user.getGender());
        us.setEmail(user.getEmail());
        us.setPhoneNumber(user.getPhoneNumber());
        return repository.save(us);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        return optional.get();
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()) {
            System.out.println("Id not found");
        }
        User us = optional.get();
        repository.delete(us);
    }

   public User getUserByEmail(String email){
        Optional<User> optional = repository.findUserByEmail(email);
        if(optional.isEmpty()) {
            System.out.println("Email id not found");
            return null;
        }
        return optional.get();
   }
    public User getUserByPhone(long phoneNumber){
        Optional<User> optional = repository.findUserByPhoneNumber(phoneNumber);
        if(optional.isEmpty()) {
            System.out.println("Phone Number Not Found");
            return null;
        }
        return optional.get();
    }

    public List<User> getUserByFirstName(String firstName) {
        List<User> list = repository.findUserByFirstName(firstName);
        return list;
    }

    public List<User> getUserByLastName(String lastName) {
        List<User> list = repository.findUserByLastName(lastName);
        return list;
    }

       public List<User> getUserByGender(String gender) {
        List<User> list = repository.findUserByGender(gender);
        return list;
    }
}
