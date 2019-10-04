package com.codegym.testuploadfileapi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

public class FormHuman {
    private Long id;


    private String Name;


    private LocalDate BirthDate;


    private MultipartFile[] fileImage;

    public FormHuman() {
    }

    public FormHuman(Long id, String name, LocalDate birthDate, MultipartFile[] fileImage) {
        this.id = id;
        Name = name;
        BirthDate = birthDate;
        this.fileImage = fileImage;
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

    public MultipartFile[] getFileImage() {
        return fileImage;
    }

    public void setFileImage(MultipartFile[] fileImage) {
        this.fileImage = fileImage;
    }
}
