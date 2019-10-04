package com.codegym.testuploadfileapi.service.impl;

import com.codegym.testuploadfileapi.Model.FormHuman;
import com.codegym.testuploadfileapi.Model.Human;
import com.codegym.testuploadfileapi.service.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import static org.springframework.util.ResourceUtils.getFile;

@Service
public class FileServiceImpl implements FileService {
    @Value("${file.upload-dir}")
    private String uploadFile;

    @Override
    public void saveFile(MultipartFile[] multipartFile) {
        for (MultipartFile file : multipartFile) {
            File uploadedFile = new File(uploadFile, file.getOriginalFilename());
            try {
                uploadedFile.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
                fileOutputStream.write(file.getBytes());
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public File callFile(Optional<Human> human) throws FileNotFoundException {
        String pathFile = uploadFile + human.get().getNameImage();
        File fileName = getFile(pathFile);
        return fileName;
    }

    @Override
    public void delete(File file) throws IOException {
        FileUtils.forceDelete(file);
    }
}
