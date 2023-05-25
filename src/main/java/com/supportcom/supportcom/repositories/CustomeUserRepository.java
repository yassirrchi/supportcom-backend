package com.supportcom.supportcom.repositories;

import com.supportcom.supportcom.entities.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomeUserRepository extends JpaRepository<CustomUser,Long> {
    CustomUser findByUsername(String username);
}
