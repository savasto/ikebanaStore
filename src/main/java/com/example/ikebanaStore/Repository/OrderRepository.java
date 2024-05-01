package com.example.ikebanaStore.Repository;

import com.example.ikebanaStore.Model.BouquetOrder;
import org.springframework.data.repository.CrudRepository;
//import bouquets.BouquetOrder;

public interface OrderRepository extends CrudRepository<BouquetOrder, Long> {
}
