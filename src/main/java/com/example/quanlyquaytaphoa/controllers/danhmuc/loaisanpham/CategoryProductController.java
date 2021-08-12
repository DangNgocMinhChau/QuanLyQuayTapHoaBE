package com.example.quanlyquaytaphoa.controllers.danhmuc.loaisanpham;

import com.example.quanlyquaytaphoa.models.danhmuc.loaisanpham.CategoryProductDto;
import com.example.quanlyquaytaphoa.services.danhmuc.loaisanpham.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlycategory")
public class CategoryProductController {

    @Autowired
    private CategoryProductService categoryProductService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return categoryProductService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody CategoryProductDto categoryProductDto) {
        return categoryProductService.create(categoryProductDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody CategoryProductDto categoryProductDto) {
        return categoryProductService.update(id, categoryProductDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return categoryProductService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return categoryProductService.fetchById(id);
    }
}
