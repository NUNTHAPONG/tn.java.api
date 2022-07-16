package com.tn.java.api.service;

import com.tn.java.api.model.ContentDB;
import com.tn.java.api.repository.ContentDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class ContentService {
    @Autowired
    private ContentDBRepository contentDBRepository;
    public ContentDB upToDB(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ContentDB FileDB = new ContentDB(fileName, file.getContentType(), file.getBytes());
        return contentDBRepository.save(FileDB);
    }
    public ContentDB download(String id) {

        return contentDBRepository.findById(id).get();
    }

    public Stream<ContentDB> getContentList() {
        return contentDBRepository.findAll().stream();
    }
}
