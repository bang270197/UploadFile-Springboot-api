package com.codegym.testuploadfileapi.service.impl;

import com.codegym.testuploadfileapi.Model.Human;
import com.codegym.testuploadfileapi.Repository.HumanRepository;
import com.codegym.testuploadfileapi.service.HumanService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static org.apache.commons.io.FileUtils.getFile;

@Service
public class HumanServiceImpl implements HumanService {
    private HumanRepository humanRepository;

    @Autowired
    public HumanServiceImpl (HumanRepository humanRepository){
        this.humanRepository = humanRepository;
    }


    @Value("${file.upload-dir}")
    private String uploadFile;


    @Override
    public Iterable<Human> showAll() {
        return humanRepository.findAll();
    }

    @Override
    public void save(Human human) {
       humanRepository.save(human);
    }

    @Override
    public Optional<Human> findById(Long id) {
        return humanRepository.findById(id);
    }

    @Override
    public void deleteHuman(Long id) {
        humanRepository.deleteById(id);
    }

    @Override
    public void deleteAvatar(Optional<Human> human) {
        String pathFile = uploadFile + human.get().getNameImage();
        try {
            File avatar = getFile(pathFile);
            FileUtils.forceDelete(avatar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveImageName(MultipartFile[] multipartFiles) {
        ArrayList<String> file =new ArrayList<>();
        for (MultipartFile files: multipartFiles){
            file.add(files.getOriginalFilename());
        }
    }


}
