//package com.letssatrt.java_advanced.repository;
//
//import com.letssatrt.java_advanced.dao.CharacterDao;
//import org.springframework.stereotype.Repository;
//import com.letssatrt.java_advanced.characters.Character;
//
//import java.util.*;
//
//@Repository
//public class CharacterCollectionRepository implements CharacterDao {
//    private final List<Character> characterList = new ArrayList<>();
//    public  CharacterCollectionRepository(){
//
//    }
//
//    @Override
//    public List<Character> findAll(){
//        characterList.sort(Comparator.comparing(Character::getId));
//        return characterList;
//    }
//
//    @Override
//    public Character findById(int id){
//        return characterList.stream().filter(c->c.getId()==id).findFirst().orElse(null);
//    }
//
//    @Override
//    public Character save(Character character){
//        characterList.removeIf(c->c.getId()==character.getId());
//        characterList.add(character);
//        return character;
//    }
//
//    public boolean existById(int id) {
//        return characterList.stream().filter(c->c.getId()==id).count() == 1;
//    }
//
//    public void delete(int id) {
//        characterList.removeIf(c->c.getId()==id);
//    }
//}
