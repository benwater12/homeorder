package com.home.order.Enitiy;
import java.util.List;

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

public Merchant(String  merchant_name, String location, boolean inBusiness){
    this.inBusiness=inBusiness;
    this.location=location;
    this.merchant_name=merchant_name;

}
}
