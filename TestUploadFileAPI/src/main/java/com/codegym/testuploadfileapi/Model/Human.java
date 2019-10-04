package com.codegym.testuploadfileapi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "Human")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotEmpty
    private String Name;

    @Column(name = "birthDate")
    private LocalDate BirthDate;

    @Column(name = "NameImage")
        private ArrayList<String> NameImage;

    public Human() {
    }

    public Human(@NotEmpty String name, LocalDate birthDate, ArrayList<String> nameImage) {
        Name = name;
        BirthDate = birthDate;
        NameImage = nameImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public ArrayList<String> getNameImage() {
        return NameImage;
    }

    public void setNameImage(ArrayList<String> nameImage) {
        NameImage = nameImage;
    }
}
