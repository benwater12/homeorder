package com.home.order.Enitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
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
}
