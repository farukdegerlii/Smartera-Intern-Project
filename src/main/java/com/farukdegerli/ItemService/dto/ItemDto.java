package com.farukdegerli.ItemService.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@ApiModel(value = "item data transfer object")
public class ItemDto {
    @ApiModelProperty(value = "İtem---ID")
    private UUID id;

    @NotNull
    @ApiModelProperty(required = true,value = "İtem---Name")
    private String itemName;

}
