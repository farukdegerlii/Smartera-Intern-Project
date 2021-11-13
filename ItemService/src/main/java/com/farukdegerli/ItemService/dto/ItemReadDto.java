package com.farukdegerli.ItemService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ItemReadDto extends ItemWriteDto{
    private Long id;
}
