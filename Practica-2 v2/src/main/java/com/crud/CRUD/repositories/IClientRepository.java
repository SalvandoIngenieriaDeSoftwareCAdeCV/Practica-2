package com.crud.CRUD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.CRUD.models.ClientModel;

@Repository
public interface  IClientRepository extends JpaRepository<ClientModel, Long>{
    
    
}
