package com.ConcertHallWebApp.repository;

import java.util.Optional;

import com.ConcertHallWebApp.model.Role;
import com.ConcertHallWebApp.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}