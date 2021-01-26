package com.example.demo.web;

import com.example.demo.dao.Factura;
import com.example.demo.dao.Repository.ArticulosRepo;
import com.example.demo.dao.Repository.FacturaRepo;
import com.example.demo.dao.moduleopenfeign.Producto;
import com.example.demo.dao.moduleopenfeign.Rest.PersonnaRestClient;
import com.example.demo.dao.moduleopenfeign.Rest.ProductoRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacturaRestContoller {


    private  FacturaRepo facturaRepo;

    private  ArticulosRepo articulosRepo;

    private  PersonnaRestClient personnaRestClient;

    private  ProductoRestClient productoRestClient;


    public FacturaRestContoller(FacturaRepo facturaRepo, ArticulosRepo articulosRepo, PersonnaRestClient personnaRestClient, ProductoRestClient productoRestClient) {
        this.facturaRepo = facturaRepo;
        this.articulosRepo = articulosRepo;
        this.personnaRestClient = personnaRestClient;
        this.productoRestClient = productoRestClient;
    }



    @GetMapping("/todosfacturas/{id}")
    public Factura getFactoura( @PathVariable("id") long id) {

        Factura   factura= facturaRepo.findById(id).get();
        factura.setPersonna(personnaRestClient.getPersoonaById(factura.getPersonnaID()));
        factura.getArticulos().forEach( articulos -> {
            //System.out.println(" id Prodeco :"+articulos.getIdProducto());
            articulos.setProducto(productoRestClient.getProductoById(articulos.getIdProducto()));
        });




      return factura ;
    }


}
