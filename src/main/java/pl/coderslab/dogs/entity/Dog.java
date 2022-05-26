package pl.coderslab.dogs.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "Name is mandatory")
    private String name;

    @NotBlank (message = "Breed is mandatory")
    private String breed;
    @NotBlank
    private String size;

    @Size(max=500)
    private String character;

    @ManyToOne(cascade = CascadeType.ALL)
    private Shelter shelter;

    public Dog(Long id, String name, String breed, String size, String character, Shelter shelter) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.size = size;
        this.character = character;
        this.shelter = shelter;
    }

    public Dog() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", size='" + size + '\'' +
                ", character='" + character + '\'' +
                ", shelter=" + shelter +
                '}';
    }
}
