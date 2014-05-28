package de.mh.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mh.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
