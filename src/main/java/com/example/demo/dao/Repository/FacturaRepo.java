package com.example.demo.dao.Repository;

import com.example.demo.dao.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FacturaRepo extends JpaRepository<Factura,Long> {
}
