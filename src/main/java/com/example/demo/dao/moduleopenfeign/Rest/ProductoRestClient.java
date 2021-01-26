package com.example.demo.dao.moduleopenfeign.Rest;

import com.example.demo.dao.moduleopenfeign.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.QueryParam;
@FeignClient("PRODUCTO-SERVICE")
public interface ProductoRestClient {
     @GetMapping("/productoes/{id}")
    public Producto getProductoById(@PathVariable("id") long id);

    @GetMapping("/productoes")
   PagedModel<Producto> productoPagedModel();

}
