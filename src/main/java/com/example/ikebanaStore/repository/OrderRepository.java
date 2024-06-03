package com.example.ikebanaStore.repository;

import com.example.ikebanaStore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import bouquets.BouquetOrder;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
