package com.example.demo.dao.Repository;

import com.example.demo.dao.Articulos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ArticulosRepo extends JpaRepository<Articulos,Long> {

    public Collection<Articulos> findByFacturaId( long id);
}
