package com.service.repository;

import com.service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
   // UserEntity findByUserId(Long userId);

    //UserEntity findByUserEntityId(Long userId);

    UserEntity findByUserId(Long userId);
}
