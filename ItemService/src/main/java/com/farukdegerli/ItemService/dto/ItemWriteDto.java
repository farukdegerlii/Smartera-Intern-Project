package com.farukdegerli.ItemService.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Data
public class ItemWriteDto {
    private BigDecimal itemPrice;
    private String itemCode;
    private Long inStock;

    @NotNull
    private String itemName;
}
