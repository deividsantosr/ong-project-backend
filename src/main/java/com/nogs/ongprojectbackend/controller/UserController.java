package com.nogs.ongprojectbackend.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import io.swagger.annotations.Api;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author DeividSantosR
 */
@RestController
@RequestMapping("/api/v1/user")
@Api(value = "API that contains User operations")
public class UserController {
    @GetMapping("/teste")
    public RepresentationModel teste() {
        RepresentationModel rootResource = new RepresentationModel();

        rootResource.add(linkTo(methodOn(UserController.class).teste()).withSelfRel(),
                linkTo(methodOn(UserController.class)).withRel("user"));

        return rootResource;
    }
}
