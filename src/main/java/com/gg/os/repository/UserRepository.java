package com.gg.os.repository;

import com.gg.os.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
    boolean existsByUserEmail(String userEmail);
    List<UserEntity> findByUserEmailAndUserPassword(String userEmail, String userPassword);
}
