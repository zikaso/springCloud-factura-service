package com.example.demo;

import com.example.demo.dao.Articulos;
import com.example.demo.dao.Factura;
import com.example.demo.dao.Repository.ArticulosRepo;
import com.example.demo.dao.Repository.FacturaRepo;
import com.example.demo.dao.moduleopenfeign.Personna;
import com.example.demo.dao.moduleopenfeign.Producto;
import com.example.demo.dao.moduleopenfeign.Rest.PersonnaRestClient;
import com.example.demo.dao.moduleopenfeign.Rest.ProductoRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class FacrturaApplication implements  CommandLineRunner {

    @Autowired
    FacturaRepo facturaRepo;
    @Autowired
    ArticulosRepo articulosRepo;
    @Autowired
    PersonnaRestClient personnaRestClient;
    @Autowired
    ProductoRestClient productoRestClient;

    public static void main(String[] args) {
        SpringApplication.run(FacrturaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Personna personna=personnaRestClient.getPersoonaById(2);
        System.out.println("****personna :"+personna.toString());
        Factura factura = facturaRepo.save(new Factura(1 , new Date(),null,personna.getId() ,personna));

        Producto producto=productoRestClient.getProductoById(2);
        System.out.println("****Producto :"+producto.toString());

        PagedModel<Producto> productoPagedModel=productoRestClient.productoPagedModel();
        productoPagedModel.forEach( producto1 -> {

            System.out.println("----producto1:"+ producto1.toString() );

            Articulos articulos= new Articulos();
            articulos.setPrice(producto1.getPrice());
            articulos.setQuantity(1+ new Random().nextInt(100));
            articulos.setFactura(factura);
            articulos.setIdProducto(producto1.getId());
           // articulos.setProducto(producto1);
            articulosRepo.save(articulos);
        });



    }
}
