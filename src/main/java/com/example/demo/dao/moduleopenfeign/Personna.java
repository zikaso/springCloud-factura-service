package com.example.demo.dao.moduleopenfeign;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data @ToString
public class Personna {
    @JsonProperty(value = "personnaId")
    private  long id;
    private String name;
    private  String email;


}
