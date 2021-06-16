package com.nogs.ongprojectbackend.controller;

import com.nogs.ongprojectbackend.model.dao.Donation;
import com.nogs.ongprojectbackend.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/donation")
public class DonationController {
    @Autowired
    DonationService firebaseService;

    @GetMapping
    public Donation getDonation(@RequestParam String id) throws InterruptedException, ExecutionException {
        return firebaseService.getDonationDetails(id);
    }

    @GetMapping("/list")
    public List<Donation> getDonations() throws InterruptedException, ExecutionException {
        return firebaseService.getDonationDetails();
    }

    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) throws InterruptedException, ExecutionException {
        return firebaseService.saveDonationDetails(donation);
    }

    @PutMapping
    public String updateDonation(@RequestBody Donation donation) throws InterruptedException, ExecutionException {
        return firebaseService.updateDonationDetails(donation);
    }

    @DeleteMapping
    public String deleteDonation(@RequestParam String id) {
        return firebaseService.deleteDonation(id);
    }
}