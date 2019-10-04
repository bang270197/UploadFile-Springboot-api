package com.codegym.testuploadfileapi.controller;

import com.codegym.testuploadfileapi.service.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import com.codegym.testuploadfileapi.Model.FormHuman;
import com.codegym.testuploadfileapi.Model.Human;
import com.codegym.testuploadfileapi.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.io.FileUtils.getFile;

@RestController
@PropertySource("classpath:application.properties")
public class FileUploadController {
    private HumanService humanService;
    private FileService fileService;
    @Autowired
    public FileUploadController(HumanService humanService,FileService fileService) {
        this.fileService=fileService;
        this.humanService = humanService;
    }



    //method for uploading single file
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadFile(@RequestParam("nameImage") MultipartFile[] multipartFile, FormHuman formHuman, UriComponentsBuilder uriComponentsBuilder) {
        fileService.saveFile(multipartFile);
        ArrayList<String> fileName=new ArrayList<>();
        for (MultipartFile file: multipartFile){
            String name=file.getOriginalFilename();
           fileName.add(file.getOriginalFilename());
        }

        Human human = new Human(formHuman.getName(), formHuman.getBirthDate(), fileName);
        humanService.save(human);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/uploadFile/{id}").buildAndExpand(human.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


//@PostMapping(value = "/uploadMultipartFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//public ResponseEntity<Void> uploadMultipartfile(@RequestParam("nameImage") MultipartFile[] multipartFiles){
//
//}





    @GetMapping("/uploadFile")
    public ResponseEntity<List<Human>> ShowListHuman() {
        List<Human> noteTypes = (List<Human>) humanService.showAll();
        if (noteTypes.isEmpty()) {
            return new ResponseEntity<List<Human>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Human>>(noteTypes, HttpStatus.OK);
    }

    @DeleteMapping("/uploadFile/{id}")
    public ResponseEntity<Human> deleteHuman(@PathVariable("id") Long id) {
        Optional<Human> human = humanService.findById(id);
        if (human==null) {
            return new ResponseEntity<Human>(HttpStatus.NOT_FOUND);
        }
        humanService.deleteHuman(human.get().getId());

        try {
            fileService.delete(fileService.callFile(human));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Human>(HttpStatus.OK);
    }
}
