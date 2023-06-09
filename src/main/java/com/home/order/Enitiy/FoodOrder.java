package com.home.order.Enitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class FoodOrder {
//uid
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column
private long food_order_id;

@ManyToOne
@JoinColumn(name = "PERSON_ID")
 private Person person;
 @ManyToOne
@JoinColumn(name = "ITEM_ID")
 private Item item;
 @ManyToOne
@JoinColumn(name = "MERCHANT_ID")
 private Merchant merchant;
 @Column
 private java.util.Date order_date;
 @Column
 private int order_cost;
 //text field
 @Column
 @Lob
 private String order_specific; 
 


}
