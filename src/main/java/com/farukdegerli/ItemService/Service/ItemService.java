package com.farukdegerli.ItemService.Service;

import com.farukdegerli.ItemService.dto.ItemDto;
import com.farukdegerli.ItemService.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    ItemDto save(ItemDto itemDto);

    ItemDto getById(Long id);

    Page<Item> getAllPageable(Pageable pageable);

    List<Item> getByItemName(String itemName);

    Boolean delete(String itemName);

    ItemDto update(Long id, ItemDto itemDto);
}
