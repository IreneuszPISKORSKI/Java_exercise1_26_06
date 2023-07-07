package com.letssatrt.java_advanced.characters;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;

@Entity
@Table(name = "my_character")
@Schema(name = "Schema of the character", description = "This is a schema of the character and example values")
public final class Character {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Schema(
                example = "5"
        )
        private int id;
        @Schema(
                example = "Tomato the Great"
        )
        private String name;
        @Schema(
                example = "Warrior"
        )
        private CharacterType type;

        @Schema(
                example = "9"
        )
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
