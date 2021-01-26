package com.example.demo.dao;

import com.example.demo.dao.moduleopenfeign.Producto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Articulos {
    @Id @GeneratedValue
    private long id;
    private  double price;
    private  double quantity;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne()
    private  Factura factura;

    private long idProducto;
    //-------feign-----
    @Transient
    private Producto producto;


}
