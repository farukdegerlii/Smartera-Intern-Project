package com.farukdegerli.ItemService.service;

import com.farukdegerli.ItemService.dto.ItemReadDto;
import com.farukdegerli.ItemService.dto.ItemWriteDto;
import com.farukdegerli.ItemService.dto.SearchOperationRequest;
import com.farukdegerli.ItemService.utilities.Tpage;
import org.springframework.data.domain.Pageable;

public interface ItemService {
    ItemReadDto save(Long userId,String pass,ItemWriteDto itemWriteDto);

    ItemReadDto getById(Long id);


    ItemReadDto getByItemName(String itemName);

   Boolean delete(String itemName);

    Boolean delete(Long id);

    ItemReadDto update(ItemWriteDto itemWriteDto);

    Tpage<ItemReadDto> findAll(Pageable pageable);

    Tpage<ItemReadDto> findItemWithPredicate(Pageable pageable, SearchOperationRequest searchOperationRequest);
}
