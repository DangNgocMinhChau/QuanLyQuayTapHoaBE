package com.example.quanlyquaytaphoa.services.quanlyfile;


import com.example.quanlyquaytaphoa.models.quanlyfiles.FileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

public interface FileStorageDBService {
    public FileDB create(MultipartFile file) throws IOException;

    public FileDB getFile(String id);

    public Stream<FileDB> getAllFiles();

    public Map<String, Object> deleteFile(String id);

    public Stream<FileDB> getAllFilesImg();

    public Stream<FileDB> getAllFilesTxt();


}
