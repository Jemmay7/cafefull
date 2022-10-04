package com.backend.tierracafe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.tierracafe.models.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel,Long> {
    
}
