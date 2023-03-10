package com.pw.custom_query.repository;

import com.pw.custom_query.entity.User;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

   @Query("select u from User u where u.email = :email ")
    Optional<User> findUserByEmail(String email);

    @Query("select u from User u where u.phoneNumber = :phoneNumber")
    Optional<User> findUserByPhoneNumber(long phoneNumber);

    @Query("select u from User u where u.firstName = :firstName")
    List<User> findUserByFirstName(String firstName);

    @Query("select u from User u where u.lastName = :lastName")
    List<User> findUserByLastName(String lastName);

    @Query("select u from User u where u.gender = :gender")
    List<User> findUserByGender(String gender);

}
