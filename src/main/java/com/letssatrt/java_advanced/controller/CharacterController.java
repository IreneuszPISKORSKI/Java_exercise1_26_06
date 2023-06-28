package com.letssatrt.java_advanced.controller;

import com.letssatrt.java_advanced.characters.Character;
import com.letssatrt.java_advanced.repository.CharacterCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {
    private CharacterCollectionRepository repository;

    public CharacterController(CharacterCollectionRepository repository){
        this.repository = repository;
    }

    @GetMapping("")
    public List<Character> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Character findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Character character){
        repository.save(character);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Character character, @PathVariable Integer id){
        if(!repository.existById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found");
        }
        repository.save(character);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.delete(id);
    }
}
