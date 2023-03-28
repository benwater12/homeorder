package com.home.order.Enitiy;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter

public class Item {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@PrimaryKeyJoinColumn(name = "ITEM_ID")
private long item_id;
@Column
@Lob
 private String item_name;
 @Column
 private int price;
@ManyToOne
@JoinColumn(name = "MERCHANT_ID")
 private Merchant merchant;
 //text field
 @Column
 @Lob
 private String item_specific; 
 @OneToMany(mappedBy = "item", cascade = CascadeType.ALL) 
 private List<FoodOrder> Orders= new ArrayList<FoodOrder>();

 
 public Item(String item_name, int price, String item_specific,Merchant merchant)
 {
    this.item_name=item_name;
    this.merchant=merchant;
    this.item_specific=item_specific;
    this.price=price;
 }
}
