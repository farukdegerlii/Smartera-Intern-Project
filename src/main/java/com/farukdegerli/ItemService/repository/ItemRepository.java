package com.farukdegerli.ItemService.repository;

import com.farukdegerli.ItemService.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Page<Item> findAll(Pageable pageable);

    List<Item> getByItemName(String itemName);


    Item getByIdAndIdIsNotNull(Long id);
}
