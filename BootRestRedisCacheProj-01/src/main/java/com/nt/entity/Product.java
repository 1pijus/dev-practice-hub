package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "CACHE_PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
    @NonNull
	private String pname;
    @NonNull
	private Double price;
    @NonNull
	private Integer qty;
	
}
