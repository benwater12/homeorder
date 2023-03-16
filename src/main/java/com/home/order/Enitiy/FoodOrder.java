package com.home.order.Enitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@GeneratedValue(strategy = GenerationType.AUTO)
private long order_id;
@Column
 private long person_ID;
 @Column
 private long item_ID;
 @Column
 private long merchant_ID;
 @Column
 private java.util.Date order_date;

 //text field
 @Column
 @Lob
 private String order_specific; 
 


}
