package com.farukdegerli.ItemService.repository;

import com.farukdegerli.ItemService.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemRepository extends JpaRepository<Item,Long>, JpaSpecificationExecutor<Item> {
    Item getByItemName(String string);

    Item getByIdAndIdIsNotNull(Long id);
}
