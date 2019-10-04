package com.codegym.testuploadfileapi.service;

import com.codegym.testuploadfileapi.Model.FormHuman;
import com.codegym.testuploadfileapi.Model.Human;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Optional;

public interface FileService {
    void saveFile(MultipartFile[] multipartFile);
        File callFile(Optional<Human> human) throws FileNotFoundException;
        void delete(File file) throws IOException;
}
