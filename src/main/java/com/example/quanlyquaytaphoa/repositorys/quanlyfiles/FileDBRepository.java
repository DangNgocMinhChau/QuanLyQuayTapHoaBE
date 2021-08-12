package com.example.quanlyquaytaphoa.repositorys.quanlyfiles;

import com.example.quanlyquaytaphoa.models.quanlyfiles.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
    @Query(value = "select * from files f  where f.type = 'image/png'" +
            " or f.type = 'image/jpg' " +
            " or f.type = 'image/jpeg' ", nativeQuery = true)
    List<FileDB> findByFileTypeImg();

    @Query(value = "select * from files f  where f.type <> 'image/png'" +
            " and f.type <> 'image/jpg' " +
            " and f.type <> 'image/jpeg' ", nativeQuery = true)
    List<FileDB> findByFileTypeTxt();

}
