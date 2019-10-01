package com.example.animals.service;

import com.example.animals.model.Animal;
import com.example.animals.repository.AnimalRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AnimalService {

    private AnimalRepository repository;

    AnimalService(AnimalRepository animalRepository) {
        this.repository = animalRepository;
    }

    public List<Animal> findAll() {
        return repository.findAll();
    }

    public Optional<Animal> findById(Long id) {
        return repository.findById(id);
    }

    public Animal create(Animal animal) {
        return repository.save(animal);
    }

    public Animal update(Animal animal) {
        return repository.save(animal);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
