package pl.coderslab.dogs.entity;

import javax.persistence.*;

@Entity
@Table(name="dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String breed;
    private String size_dog;
    private String character;

    @ManyToOne
    private Shelter shelter;

}
