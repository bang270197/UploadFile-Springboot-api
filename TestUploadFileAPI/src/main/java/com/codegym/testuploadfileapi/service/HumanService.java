package com.codegym.testuploadfileapi.service;

import com.codegym.testuploadfileapi.Model.Human;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface HumanService {
    Iterable<Human> showAll();

    void save(Human human);

    Optional<Human> findById(Long id);

    void deleteHuman(Long id);

    void deleteAvatar(Optional<Human> human);

    void saveImageName(MultipartFile[] multipartFiles);

}
