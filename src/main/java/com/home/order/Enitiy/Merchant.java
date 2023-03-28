package com.home.order.Enitiy;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter

public class Merchant {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column(name = "MERCHANT_ID")
private long merchant_id;
@Column(unique=true)
@Lob
 private String merchant_name;
 //text field
 @Column
 @Lob
 private String location; 
 @Column
 private boolean inBusiness;
 
 @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL) 
 private transient List<FoodOrder> Orders;
 @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
 private transient  List<Item> Items;

public Merchant(){
}
}
