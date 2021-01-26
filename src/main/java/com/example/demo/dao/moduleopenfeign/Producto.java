package com.example.demo.dao.moduleopenfeign;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data @ToString
public class Producto {
    @JsonProperty(value = "productoId")
    private  long id;
    private String name;
    private  double price;
    private  double quantity;
}
