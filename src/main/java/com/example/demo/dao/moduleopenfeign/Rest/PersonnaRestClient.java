package com.example.demo.dao.moduleopenfeign.Rest;

import com.example.demo.dao.moduleopenfeign.Personna;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.QueryParam;
@FeignClient("PERSONNA-SERVICE")
public interface PersonnaRestClient {

    @GetMapping(path = "/personnas/{id}")
    public Personna getPersoonaById( @PathVariable("id") long id);

    @GetMapping(path = "/personnas")
    public PagedModel<Personna> personnaPagedModel(@RequestParam(value = "page") int page, @RequestParam(value = "size")int size);




}
