package com.criptografia.criptografia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.criptografia.criptografia.domain.user.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findUserById(long id);
    

}
