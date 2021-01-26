package com.example.demo.dao;


import com.example.demo.dao.moduleopenfeign.Personna;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Factura {
    @Id @GeneratedValue
    private  long id;
    private Date facturaDate;
    @OneToMany(mappedBy = "factura")
    private Collection<Articulos> articulos;

    private Long personnaID;
    //-------feign-----
    @Transient
    private  Personna  personna;
}
