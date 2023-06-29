package com.letssatrt.java_advanced.repository;

import com.letssatrt.java_advanced.characters.CharacterType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import com.letssatrt.java_advanced.characters.Character;

import java.util.*;

@Repository
public class CharacterCollectionRepository {
    private final List<Character> characterList = new ArrayList<>();
    public  CharacterCollectionRepository(){

    }

    public List<Character> findAll(){
        characterList.sort(Comparator.comparing(Character::id));
        return characterList;
    }

    public Optional<Character> findById(Integer id){
        return characterList.stream().filter(c->c.id().equals(id)).findFirst();
    }

//    @PostConstruct
//    private void init(){
//        Character newCharacter = new Character(1,"aze", CharacterType.Mage, 8);
//        characterList.add(newCharacter);
//    }

    public void save(Character character){
        characterList.removeIf(c->c.id().equals(character.id()));
        characterList.add(character);
    }

    public boolean existById(Integer id) {
        return characterList.stream().filter(c->c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        characterList.removeIf(c->c.id().equals(id));
    }
}
