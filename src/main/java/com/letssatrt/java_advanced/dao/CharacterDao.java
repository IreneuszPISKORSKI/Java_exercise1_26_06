package com.letssatrt.java_advanced.dao;

import com.letssatrt.java_advanced.characters.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterDao extends JpaRepository<Character, Integer> {
    List<Character> findAll();
    Character findById(int id);
    Character save(Character character);
}
