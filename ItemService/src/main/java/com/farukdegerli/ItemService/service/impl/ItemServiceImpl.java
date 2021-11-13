package com.farukdegerli.ItemService.service.impl;

import com.farukdegerli.ItemService.dto.ItemReadDto;
import com.farukdegerli.ItemService.dto.ItemWriteDto;
import com.farukdegerli.ItemService.dto.SearchOperationRequest;
import com.farukdegerli.ItemService.entity.Item;
import com.farukdegerli.ItemService.repository.ItemRepository;
import com.farukdegerli.ItemService.searchPackage.GenericSpesification;
import com.farukdegerli.ItemService.searchPackage.SearchCriteria;
import com.farukdegerli.ItemService.service.ItemService;
import com.farukdegerli.ItemService.service.MemberClientService;
import com.farukdegerli.ItemService.utilities.Tpage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final MemberClientService memberClientService;
    private static final String ITEMPRICE = "itemPrice";
    private static final String INSTOCK = "inStock";

    @Override
    public ItemReadDto save(Long userId,String pass,ItemWriteDto itemWriteDto) {
        try {

            if(isManager(userId,pass)){
                if(itemRepository.getByItemName(itemWriteDto.getItemName())!=null){
                    throw new IllegalArgumentException("the item already exists");
                }
                final var itemDb = modelMapper.map(itemWriteDto, Item.class);
                return modelMapper.map(itemRepository.save(itemDb), ItemReadDto.class);
            }else {
                throw new IllegalArgumentException("You are not MANAGER");
            }

        }catch (Exception e){
            throw  new IllegalArgumentException(e.getMessage());

        }
    }

    @Override
    public ItemReadDto getById(Long id) {
        try {
            if(itemRepository.getById(id).getItemName()==null){
                throw new IllegalArgumentException("Item not found");
            }
            return modelMapper.map(itemRepository.getById(id), ItemReadDto.class);
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }


    @Override
    public ItemReadDto getByItemName(String itemName) {
        return modelMapper.map(itemRepository.getByItemName(itemName), ItemReadDto.class);
    }

    @Override
    public Boolean delete(String itemName) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        itemRepository.delete(itemRepository.getById(id));
        return itemRepository.getByIdAndIdIsNotNull(id) == null;
    }

    @Override
    public ItemReadDto update(ItemWriteDto itemWriteDto) {
        Item item = itemRepository.getByItemName(itemWriteDto.getItemName());
        if (item.getId() == null) {
            throw new IllegalArgumentException("db has not this item ID: " + itemWriteDto.getItemName());
        } else {

            item = modelMapper.map(itemWriteDto, Item.class);
            item.setId(itemRepository.getByItemName(item.getItemName()).getId());

            return modelMapper.map(itemRepository.save(item), ItemReadDto.class);
        }

    }

    @Override
    public Tpage<ItemReadDto> findAll(Pageable pageable) {

        Page<ItemReadDto> itemReadDtos = itemRepository.findAll(pageable).map(this::convertToDto);
        Tpage<ItemReadDto> itemReadDtoTpage =new Tpage<>();
        itemReadDtoTpage.setStat(itemReadDtos, Arrays.asList(modelMapper.map(itemReadDtos.getContent(),ItemReadDto[].class)));
        return itemReadDtoTpage;
    }


    @Override
    public Tpage<ItemReadDto> findItemWithPredicate(Pageable pageable,
                                                    SearchOperationRequest searchOperationRequest) {
        GenericSpesification genericSpesification = new GenericSpesification<Item>();
        genericSpesification.add(new SearchCriteria(ITEMPRICE, searchOperationRequest.getItemPrice(),
                                                    searchOperationRequest.getSearchOperation()));
        genericSpesification.add(new SearchCriteria(INSTOCK, searchOperationRequest.getInStock(),
                                                    searchOperationRequest.getSearchOperation2()));

        Page<ItemReadDto> itemReadDtos;
        itemReadDtos = itemRepository.findAll(genericSpesification, pageable).map(this::convertToDto);
        Tpage<ItemReadDto> itemReadDtoTpage =new Tpage<>();
        itemReadDtoTpage.setStat(itemReadDtos, Arrays.asList(modelMapper.map(itemReadDtos.getContent(),ItemReadDto[].class)));

        return itemReadDtoTpage;
    }


    private Boolean isManager(Long userId,String pass){
        return memberClientService.isManager(userId,pass);
    }

    private ItemReadDto convertToDto(Object object) {
        return modelMapper.map(object, ItemReadDto.class);
    }


    private ItemReadDto convertToDto(Item item) {
        return modelMapper.map(item, ItemReadDto.class);
    }
}
