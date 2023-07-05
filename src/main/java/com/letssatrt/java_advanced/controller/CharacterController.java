package com.letssatrt.java_advanced.controller;

import com.letssatrt.java_advanced.characters.Character;
import com.letssatrt.java_advanced.dao.CharacterDao;
//import com.letssatrt.java_advanced.repository.CharacterCollectionRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/api/character")
@CrossOrigin
@Tag(name = "We are controlling all the things here!")
public class CharacterController {
    @Autowired
    private CharacterDao repository;

    public CharacterController(CharacterDao repository){
        this.repository = repository;
    }

    @GetMapping("")
    @Operation(
            summary = "Get list of all characters",
            description = "This allows you to display all existing characters!",
            tags = "With more options in response!",
            responses ={
                    @ApiResponse(responseCode = "200", description = "Found the character",
                            content = {@Content(mediaType = "application/json")}),
                    @ApiResponse(responseCode = "404", description = "Beer not found, go buy new one!", content = @Content)
            }
    )
    public List<Character> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Show character with certain id"
    )
    public Character findById(@PathVariable int id){
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    @Operation(
            summary = "Here you can add new character"
//            parameters = {id}
    )
    public void create(@RequestBody Character character){
        repository.save(character);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    @Operation(
            summary = "Here you can update your character"
    )
    public void update(@RequestBody Character character, @PathVariable int id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found");
        }
        repository.save(character);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(
            summary = "This will delete your character with selected id"
    )
    public void delete(@PathVariable int id){
        repository.deleteById(id);
    }
}
