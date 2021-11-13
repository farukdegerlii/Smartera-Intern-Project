package com.farukdegerli.ItemService.dto;

import com.farukdegerli.ItemService.searchPackage.SearchOperation;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class SearchOperationRequest {
    private BigDecimal itemPrice;
    private Long inStock;
    private SearchOperation searchOperation;
    private SearchOperation searchOperation2;
}
