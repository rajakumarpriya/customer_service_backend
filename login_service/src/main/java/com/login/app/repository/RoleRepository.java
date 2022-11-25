package com.login.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.app.models.CRole;
import com.login.app.models.Role;
//import com.login.app.models.ERole;
//import com.login.app.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(CRole name);
}
