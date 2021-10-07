package com.farukdegerli.ItemService.Service.impl;

import com.farukdegerli.ItemService.Service.ItemService;
import com.farukdegerli.ItemService.dto.ItemDto;
import com.farukdegerli.ItemService.entity.Item;
import com.farukdegerli.ItemService.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;


    @Override
    public ItemDto save(ItemDto itemDto) {

        Item itemDb = modelMapper.map(itemDto, Item.class);
        itemRepository.save(itemDb);
        itemDto = modelMapper.map(itemDb, ItemDto.class);

        return itemDto;
    }


    @Override
    public ItemDto getById(Long id) {

        /*if (itemRepository.getById(id).getId().toString()!= id.toString()){
            throw new IllegalArgumentException("hata");
        }*/
        if (itemRepository.getByIdAndIdIsNotNull(id)==null){
            throw new IllegalArgumentException("hata");
        }

        return modelMapper.map(itemRepository.getById(id), ItemDto.class);
    }

    @Override
    public Page<Item> getAllPageable(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    @Override
    public List<Item> getByItemName(String itemName) {
        return itemRepository.getByItemName(itemName);
    }

    @Override
    public Boolean delete(String itemName) {
        return null;
    }


    public Boolean delete(Long id) {
        itemRepository.delete(itemRepository.getById(id));
        return itemRepository.getByIdAndIdIsNotNull(id) == null;
    }


    @Override
    public ItemDto update(Long id, ItemDto itemDto) {
        Item item = itemRepository.getById(id);
        if(item==null){
            throw new IllegalArgumentException("db has not this item ID: "+ id);
        }
        System.out.println("set etmeden önce id: "+id+" "+item.getItemName());
        item.setItemName(itemDto.getItemName());
        System.out.println("set sonra id: "+id+" "+item.getItemName());
        itemRepository.save(item);

        return modelMapper.map(item,ItemDto.class);
    }
}
