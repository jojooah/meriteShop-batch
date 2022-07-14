package com.metanet.meriteshopbatch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@DynamicInsert
@NoArgsConstructor
@Table(name = "item")
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    private String category;

    @Column(name = "item_name")
    private String itemName;

    private int price;
    private String description;
    private boolean shipping;
    private String imgUrl;
    private double rate;

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imgUrl='" + imgUrl + '\'' +
                '}';


    }

}