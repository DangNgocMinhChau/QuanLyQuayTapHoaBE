package com.example.quanlyquaytaphoa.controllers.danhmuc.quyen;

import com.example.quanlyquaytaphoa.models.danhmuc.quyen.QuyenDto;
import com.example.quanlyquaytaphoa.services.danhmuc.quyen.QuyenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlyquyen")
public class QuyenController {

    @Autowired
    private QuyenServiceImpl quyenService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return quyenService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody QuyenDto quyenDto) {
        return quyenService.create(quyenDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody QuyenDto quyenDto) {
        return quyenService.update(id, quyenDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return quyenService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return quyenService.fetchById(id);
    }


}
