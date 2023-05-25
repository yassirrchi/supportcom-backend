package com.supportcom.supportcom.repositories;

import com.supportcom.supportcom.entities.CustomRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoleRepository extends JpaRepository<CustomRole,Long> {
    CustomRole findByRolename(String rolename);
}
