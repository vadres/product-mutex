package com.vadres.procuct_mutex.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vadres.procuct_mutex.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
