package com.example.quanlyquaytaphoa.controllers.danhmuc.cmnd;

import com.example.quanlyquaytaphoa.models.danhmuc.cmnd.CMND_Dto;
import com.example.quanlyquaytaphoa.services.danhmuc.cmnd.CMNDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlycmnd")
public class CMNDController {

    @Autowired
    private CMNDService cmndService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return cmndService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody CMND_Dto cmnd_dto) {
        return cmndService.create(cmnd_dto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody CMND_Dto cmnd_dto) {
        return cmndService.update(id, cmnd_dto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return cmndService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return cmndService.fetchById(id);
    }


}
