package com.farukdegerli.ItemService.service.impl;

import com.farukdegerli.ItemService.dto.ItemReadDto;
import com.farukdegerli.ItemService.dto.ItemWriteDto;
import com.farukdegerli.ItemService.entity.Item;
import com.farukdegerli.ItemService.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.Mockito.*;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)

class ItemServiceImplTest {
    @InjectMocks
    private ItemServiceImpl itemService;
    @Mock
    private ItemRepository itemRepository;
    @Mock
    private ModelMapper modelMapper;

    /*@Ignore
    @Test
    void testSave() {
        //Given
        final var item = getValidItem();
        final var itemWriteDto = new ItemWriteDto();
        itemWriteDto.setItemCode(item.getItemCode());
        itemWriteDto.setItemName(item.getItemName());
        itemWriteDto.setItemPrice(item.getItemPrice());
        itemWriteDto.setInStock(item.getInStock());

        when(itemRepository.save(item)).thenReturn(item);
        final var expectedReadDto = modelMapper.map(itemWriteDto, ItemReadDto.class);

        //When
        final var itemReadDto = itemService.save(itemWriteDto);
        //Then
        org.assertj.core.api.Assertions.assertThat(itemReadDto)
                .isEqualTo(expectedReadDto);

    }*/

    @Test
    void getById() {
    }

    @Test
    void getByItemName() {
    }

    @Test
    void delete() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }

    private Item getValidItem() {
        final var item = new Item();
        item.setId(1L);
        item.setItemCode("CODE-001");
        item.setItemPrice(BigDecimal.valueOf(5L));
        item.setInStock(5L);
        item.setItemName("ITEM-001");
        item.setDate(new Date());
        return item;
    }

    @Test
    void findItemWithPredicate() {
    }
}