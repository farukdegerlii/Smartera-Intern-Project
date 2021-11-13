package com.farukdegerli.ItemService.controller;


import com.farukdegerli.ItemService.dto.ItemReadDto;
import com.farukdegerli.ItemService.dto.ItemWriteDto;
import com.farukdegerli.ItemService.dto.SearchOperationRequest;
import com.farukdegerli.ItemService.service.ItemService;
import com.farukdegerli.ItemService.utilities.Tpage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/item-service")
@RequiredArgsConstructor
@Api(value = "/item-service", description = "Item API")
public class ItemController {
    private final ItemService itemService;



    @GetMapping("/{id}")
    @ApiOperation(value = "Get BY ID OPERATION ", response = ItemReadDto.class)
    public ResponseEntity<ItemReadDto> getById(@PathVariable("id") Long id) {
        ItemReadDto itemReadDto = itemService.getById(id);

        return ResponseEntity.ok(itemReadDto);
    }
    @GetMapping("/all")
    @ApiOperation(value = "Get All ", response = ItemReadDto.class)
    public ResponseEntity<Tpage<ItemReadDto>> getAll(Pageable pageable) {

        return ResponseEntity.ok(itemService.findAll(pageable));
    }


    @GetMapping("/allBySearchCriteria")
    @ApiOperation(value = "Get All By SearchCriteria", response = ItemReadDto.class)
    public ResponseEntity<Tpage<ItemReadDto>> getAllByCriteria(Pageable pageable,
                                                               @Valid @RequestBody SearchOperationRequest searchOperationRequest) {

        Tpage<ItemReadDto> itemReadDtoTpage = itemService.findItemWithPredicate(pageable,searchOperationRequest);

        return ResponseEntity.ok(itemReadDtoTpage);
    }



    @GetMapping("name/{name}")
    @ApiOperation(value = "Get BY NAME OPERATION ", response = ItemReadDto.class)
    public ResponseEntity<ItemReadDto> getByItemName(@PathVariable("name") String name) {
        ItemReadDto itemReadDto = itemService.getByItemName(name);

        return ResponseEntity.ok(itemReadDto);
    }


    @PostMapping("/save")
    @ApiOperation(value = "CREATE ITEM OPERATION ", response = ItemReadDto.class)
    public ResponseEntity<ItemReadDto> createItem(@RequestParam(value = "userId") Long userId,
                                                  @RequestParam(value = "pass") String pass,
                                                  @Valid @RequestBody ItemWriteDto itemWriteDto) {

        return ResponseEntity.ok(itemService.save(userId,pass,itemWriteDto));
    }


    @PutMapping("/update")
    @ApiOperation(value = "UPDATE OPERATION ", response = ItemWriteDto.class)
    public ResponseEntity<ItemReadDto> updateItem(@Valid @RequestBody ItemWriteDto itemWriteDto) {

        return ResponseEntity.ok(itemService.update(itemWriteDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "DELETE OPERATION ", response = Boolean.class)
    public ResponseEntity<Boolean> deleteItem(@PathVariable(value = "id") Long id) {

        return ResponseEntity.ok(itemService.delete(id));
    }

}