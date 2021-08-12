package com.example.quanlyquaytaphoa.controllers.quanlyfile;



import com.example.quanlyquaytaphoa.models.message.ResponseMessage;
import com.example.quanlyquaytaphoa.models.quanlyfiles.FileDB;
import com.example.quanlyquaytaphoa.models.quanlyfiles.ResponseFile;
import com.example.quanlyquaytaphoa.services.quanlyfile.FileStorageDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
@CrossOrigin("http://localhost:3000")
public class FileController {

    @Autowired
//  private FileStorageService storageService;
    private FileStorageDBService fileStorageDBService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            File convertFile = new File("D:/lamViec/IT/DuAn/QuanLyQuayTapHoa_PJ/FE/QuanLyQuayTapHoa_FE/src/filedinhkem/file-img" + file.getOriginalFilename());
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fileStorageDBService.create(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = fileStorageDBService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();
            return new ResponseFile(
                    dbFile.getId(),
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length,
                    dbFile.getPath()
            );

        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        FileDB fileDB = fileStorageDBService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }

    //  @DeleteMapping(value = "/files/{id}")
////  public void delete(@PathVariable String id) {
////     storageService.deleteFile(id);
////  }
    @DeleteMapping(value = "/files/{id}")
    public Map<String, Object> delete(@PathVariable String id) {
        return fileStorageDBService.deleteFile(id);
    }

    @GetMapping("/files/img")
    public ResponseEntity<List<ResponseFile>> getListFilesImg() {
        List<ResponseFile> files = fileStorageDBService.getAllFilesImg().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();
            return new ResponseFile(
                    dbFile.getId(),
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length,
                    dbFile.getPath()
            );
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/txt")
    public ResponseEntity<List<ResponseFile>> getListFilesText() {
        List<ResponseFile> files = fileStorageDBService.getAllFilesTxt().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();
            return new ResponseFile(
                    dbFile.getId(),
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length,
                    dbFile.getPath());

        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

}
