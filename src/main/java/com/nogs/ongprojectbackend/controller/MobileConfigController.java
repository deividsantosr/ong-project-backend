package com.nogs.ongprojectbackend.controller;

import com.nogs.ongprojectbackend.model.dao.MobileConfig;
import com.nogs.ongprojectbackend.service.MobileConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/mobileConfig")
public class MobileConfigController {
    @Autowired
    MobileConfigService firebaseService;

    @GetMapping
    public MobileConfig getMobileConfig(@RequestParam String id) throws InterruptedException, ExecutionException {
        return firebaseService.getMobileConfigDetails(id);
    }

    @GetMapping("/list")
    public List<MobileConfig> getMobileConfigs() throws InterruptedException, ExecutionException {
        return firebaseService.getMobileConfigDetails();
    }

    @PostMapping
    public String createMobileConfig(@RequestBody MobileConfig mobileConfig) throws InterruptedException, ExecutionException {
        return firebaseService.saveMobileConfigDetails(mobileConfig);
    }

    @PutMapping
    public String updateMobileConfig(@RequestBody MobileConfig mobileConfig) throws InterruptedException, ExecutionException {
        return firebaseService.updateMobileConfigDetails(mobileConfig);
    }

    @DeleteMapping
    public String deleteMobileConfig(@RequestParam String id) {
        return firebaseService.deleteMobileConfig(id);
    }
}