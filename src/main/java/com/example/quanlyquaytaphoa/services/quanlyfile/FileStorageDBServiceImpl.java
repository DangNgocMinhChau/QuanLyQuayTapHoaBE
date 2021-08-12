package com.example.quanlyquaytaphoa.services.quanlyfile;

import com.example.quanlyquaytaphoa.models.quanlyfiles.FileDB;
import com.example.quanlyquaytaphoa.repositorys.quanlyfiles.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class FileStorageDBServiceImpl implements FileStorageDBService {

    @Autowired
    private FileDBRepository fileDBRepository;

    @Override
    public FileDB create(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String pathFile = "D:/lamViec/IT/DuAn/QuanLyQuayTapHoa_PJ/FE/QuanLyQuayTapHoa_FE/src/filedinhkem/file-img" + fileName;
        FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), pathFile);
        return fileDBRepository.save(FileDB);
    }

    @Override
    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    @Override
    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }

    @Override
    public Map<String, Object> deleteFile(String id) {
        System.out.println(id);
        Map<String, Object> result = new HashMap<>();
        try {
            fileDBRepository.deleteById(id);
//            Files.deleteIfExists(Paths.get(fileDBRepository.getById(id).getPath()));
        } catch (Exception e) {
        }
        result.put("status", true);
        result.put("Trạng thái xoá file", "Xoá file thành công");
        return result;
    }

    @Override
    public Stream<FileDB> getAllFilesImg() {
        return fileDBRepository.findByFileTypeImg().stream();
    }

    @Override
    public Stream<FileDB> getAllFilesTxt() {
        return fileDBRepository.findByFileTypeTxt().stream();
    }


}
