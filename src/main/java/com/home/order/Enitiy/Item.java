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

public class Item {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long item_id;
@Column
@Lob
 private String item_name;
 @Column
 private int price;
 @Column
 private long merchant_id;

 //text field
 @Column
 @Lob
 private String order_specific; 
}
