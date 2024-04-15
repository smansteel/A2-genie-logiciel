package fr.genepisep.icompetences.controllers;

import fr.genepisep.icompetences.services.EntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class EntityController<T, S extends EntityService<T, ?>> {
    protected final S entityService;

    protected EntityController(S entityService) {
        this.entityService = entityService;
    }

    // Testing purposes
    @GetMapping("/all")
    public ResponseEntity<List<T>> getAllEntities() {
        return ResponseEntity.ok(entityService.findAllEntities());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<T> getEntityById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(entityService.findEntityById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<T> addEntity(@RequestBody T entity) {
        return new ResponseEntity<>(entityService.addEntity(entity), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<T> updateEntity(@RequestBody T entity) {
        return ResponseEntity.ok(entityService.updateEntity(entity));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable("id") Integer id) {
        entityService.deleteEntity(id);
        return ResponseEntity.noContent().build();
    }


}

