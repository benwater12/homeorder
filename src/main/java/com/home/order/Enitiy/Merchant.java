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

public class Merchant {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long merchant_id;
@Column
@Lob
 private String name;
 //text field
 @Column
 @Lob
 private String location; 
}
