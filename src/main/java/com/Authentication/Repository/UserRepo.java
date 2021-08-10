package com.Authentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Authentication.Models.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

	Users findByemailId(String email);

	Users findByemailIdAndPassword(String email, String pass);


}
