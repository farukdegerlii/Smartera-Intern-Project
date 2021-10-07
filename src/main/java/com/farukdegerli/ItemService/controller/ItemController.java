package com.farukdegerli.ItemService.controller;


import com.farukdegerli.ItemService.Service.impl.ItemServiceImpl;
import com.farukdegerli.ItemService.dto.ItemDto;
import com.farukdegerli.ItemService.utilities.ItemPath;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ItemPath.BASE_PATH)
@RequiredArgsConstructor
@Api(value = ItemPath.BASE_PATH ,description = "Item APı")
public class ItemController {
    private final ItemServiceImpl itemServiceImpl;

    //Get Put Post Delete
    @GetMapping(ItemPath.id)
    @ApiOperation(value = "Get BY ID OPERATION " , response = ItemDto.class)
    public ResponseEntity<ItemDto> getById(@PathVariable("id") Long id){
        ItemDto itemDto = itemServiceImpl.getById(id);

        return  ResponseEntity.ok(itemDto);
    }


    @PostMapping(ItemPath.ItemSaveCtrl.CTRL)
    @ApiOperation(value = "CREATE ITEM OPERATION " , response = ItemDto.class)
    public ResponseEntity<ItemDto> createItem( @Valid @RequestBody ItemDto itemDto){
        System.out.println("save methodu name : "+itemDto.getItemName());

        return ResponseEntity.ok( itemServiceImpl.save(itemDto));
    }

    //TODO Dtoları write read diye ayrınca buraya gel
    @PutMapping(ItemPath.id)
    @ApiOperation(value = "UPDATE OPERATION " , response = ItemDto.class)
    public ResponseEntity<ItemDto> updateItem(@PathVariable(value = "id") Long id,@Valid @RequestBody ItemDto itemDto){
        System.out.println("update metodu name : "+itemDto.getItemName());
        return ResponseEntity.ok(itemServiceImpl.update(id,itemDto));
    }

    @DeleteMapping(ItemPath.id)
    @ApiOperation(value = "DELETE OPERATION " , response = Boolean.class)
    public ResponseEntity<Boolean> deleteItem(@PathVariable(value = "id")Long id){

        return ResponseEntity.ok(itemServiceImpl.delete(id));
    }

}
