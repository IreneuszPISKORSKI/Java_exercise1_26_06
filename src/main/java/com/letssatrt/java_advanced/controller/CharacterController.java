package com.letssatrt.java_advanced.controller;

import com.letssatrt.java_advanced.characters.Character;
import com.letssatrt.java_advanced.dao.CharacterDao;
//import com.letssatrt.java_advanced.repository.CharacterCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/api/character")
@CrossOrigin
public class CharacterController {
    @Autowired
    private CharacterDao repository;

    public CharacterController(CharacterDao repository){
        this.repository = repository;
    }

    @GetMapping("")
    public List<Character> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Character findById(@PathVariable int id){
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Character character){
        repository.save(character);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Character character, @PathVariable int id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found");
        }
        repository.save(character);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        repository.deleteById(id);
    }
}
