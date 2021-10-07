package com.farukdegerli.ItemService.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "items")
@Setter
@Getter
@RequiredArgsConstructor
public class Item {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id")
    private UUID id;;


    @Column( name = "item_name",length = 100)
    private String itemName;

    @Column(name = "item_price", length = 100)
    private Long itemPrice;

    @Column(name = "item_info", length = 100)
    private String itemInfo;

    @Column(name = "item_code", length = 100)
    private String itemCode;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    private Date date;


}
