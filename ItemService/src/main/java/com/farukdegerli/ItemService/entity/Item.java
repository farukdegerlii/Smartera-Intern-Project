package com.farukdegerli.ItemService.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "items")
@Setter
@Getter
@RequiredArgsConstructor

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @Column(name = "item_name", length = 100,unique = true)
    private String itemName;

    @Column(name = "item_price", length = 100)
    private BigDecimal itemPrice;

    @Column(name = "item_code", length = 100)
    private String itemCode;

    @Column(name = "in_Stock", length = 100)
    private Long inStock;


    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

}
