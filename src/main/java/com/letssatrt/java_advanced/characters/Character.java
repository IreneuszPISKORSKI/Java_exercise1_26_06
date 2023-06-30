package com.letssatrt.java_advanced.characters;

import jakarta.persistence.*;

@Entity
@Table(name = "`character`")
public final class Character {
        @Id
        @GeneratedValue
        private int id;
        private String name;

        private CharacterType type;

        private int hp;
        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public CharacterType getType() {
                return type;
        }

        public void setType(CharacterType type) {
                this.type = type;
        }

        public int getHp() {
                return hp;
        }

        public void setHp(int hp) {
                this.hp = hp;
        }

        public Character(
                int id,
                String name,
                CharacterType type,
                int hp
        ) {
                this.id = id;
                this.name = name;
                this.type = type;
                this.hp = hp;
        }

        public Character() {

        }


}
