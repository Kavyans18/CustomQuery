package com.pw.custom_query.service;
import com.pw.custom_query.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    User updateUser(User user, int id);
    User getUserById(int id);
    List<User> getAll();
    void deleteUser(int id);
    User getUserByEmail(String email);
    User getUserByPhone(long phoneNumber);
    List<User> getUserByFirstName(String firstName);
    List<User> getUserByLastName(String lastName);
    List<User> getUserByGender(String gender);

}
