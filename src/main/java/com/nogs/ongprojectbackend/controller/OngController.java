package com.nogs.ongprojectbackend.controller;

import com.nogs.ongprojectbackend.model.dao.Ong;
import com.nogs.ongprojectbackend.service.OngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/ong")
public class OngController {
    @Autowired
    OngService firebaseService;

    @GetMapping
    public Ong getOng(@RequestParam String id) throws InterruptedException, ExecutionException {
        return firebaseService.getOngDetails(id);
    }

    @GetMapping("/list")
    public List<Ong> getOngs() throws InterruptedException, ExecutionException {
        return firebaseService.getOngDetails();
    }

    @PostMapping
    public String createOng(@RequestBody Ong ong) throws InterruptedException, ExecutionException {
        return firebaseService.saveOngDetails(ong);
    }

    @PutMapping
    public String updateOng(@RequestBody Ong ong) throws InterruptedException, ExecutionException {
        return firebaseService.updateOngDetails(ong);
    }

    @DeleteMapping
    public String deleteOng(@RequestParam String id) {
        return firebaseService.deleteOng(id);
    }
}