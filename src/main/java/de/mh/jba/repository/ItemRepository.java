package de.mh.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mh.jba.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
