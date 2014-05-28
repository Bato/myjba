package de.mh.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mh.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
