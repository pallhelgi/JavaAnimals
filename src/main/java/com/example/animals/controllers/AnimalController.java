package com.example.animals.controllers;

import com.example.animals.model.Animal;
import com.example.animals.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/animals"})
public class AnimalController {

    private AnimalService service;

    AnimalController(AnimalService animalService) {
        this.service = animalService;
    }

    @GetMapping
    public List<Animal> findAll() {
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Animal> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        return service.create(animal);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<Animal> update(@PathVariable("id") Long id, @RequestBody Animal animal)  {
        Optional<Animal> oldAnimal = service.findById(id);
        if(oldAnimal.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            Animal newAnimal = oldAnimal.get();
            newAnimal.setName(animal.getName());
            newAnimal.setType(animal.getType());
            newAnimal.setSize(animal.getSize());
            newAnimal.setAge(animal.getAge());
            newAnimal.setOwnerName(animal.getOwnerName());
            newAnimal.setOwnerEmail(animal.getOwnerEmail());

            Animal updatedAnimal = service.update(newAnimal);
            return ResponseEntity.ok(updatedAnimal);
        }
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Optional<Animal> animal = service.findById(id);
        if(animal.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            service.delete(id);
            return ResponseEntity.ok().build();
        }
    }
}
