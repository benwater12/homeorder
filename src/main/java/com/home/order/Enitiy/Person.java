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
import jakarta.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table
@Getter
@Setter
public class Person {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column(name = "PERSON_ID")
private long person_id;
@Column(unique=true)
@Lob
 private String person_name;
 //text field
 @Column
 private int balance; 
 @OneToMany(mappedBy = "person", cascade = CascadeType.ALL) 
 private transient List<FoodOrder> Orders;

}
