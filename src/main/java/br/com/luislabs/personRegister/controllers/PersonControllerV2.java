package br.com.luislabs.personRegister.controllers;

import br.com.luislabs.personRegister.data.vo.v2.PersonVOV2;
import br.com.luislabs.personRegister.services.PersonService;
import br.com.luislabs.personRegister.utils.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/person")
public class PersonControllerV2 {

    private final PersonService services;

    public PersonControllerV2(PersonService services) {
        this.services = services;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public List<PersonVOV2> findAll() {
        return services.findAllV2();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PersonVOV2 findById(@PathVariable(value = "id") Long id) {
        return services.findByIdV2(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PersonVOV2 create(@RequestBody PersonVOV2 person) {
        return services.createV2(person);
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PersonVOV2 update(@RequestBody PersonVOV2 person) {
        return services.updateV2(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
}
