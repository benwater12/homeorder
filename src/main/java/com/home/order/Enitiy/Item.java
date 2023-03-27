package com.home.order.Enitiy;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
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
 @OneToOne(cascade=CascadeType.ALL)
 @JoinColumn(name="MERCHANT_ID")
 private Merchant merchant;
 //text field
 @Column
 @Lob
 private String item_specific; 

 public Item(String item_name, int price, String item_specific,Merchant merchant)
 {
    this.item_name=item_name;
    this.merchant=merchant;
    this.item_specific=item_specific;
    this.price=price;
 }
}
