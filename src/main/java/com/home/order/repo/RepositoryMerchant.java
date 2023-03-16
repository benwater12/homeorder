package com.home.order.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.home.order.Enitiy.Merchant;

public interface RepositoryMerchant extends CrudRepository<Merchant,Integer> {
    @Query(value = "SELECT a FROM Merchant a WHERE a.merchant_name LIKE :Merchant_name")
    public List<Merchant> FindByMerchant_name(String Merchant_name);
}
