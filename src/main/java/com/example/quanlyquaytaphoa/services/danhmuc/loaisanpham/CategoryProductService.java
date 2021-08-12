package com.example.quanlyquaytaphoa.services.danhmuc.loaisanpham;


import com.example.quanlyquaytaphoa.models.danhmuc.loaisanpham.CategoryProduct;
import com.example.quanlyquaytaphoa.models.danhmuc.loaisanpham.CategoryProductDto;
import com.example.quanlyquaytaphoa.models.danhmuc.quyen.Quyen;
import com.example.quanlyquaytaphoa.models.danhmuc.quyen.QuyenDto;

import java.util.Map;

public interface CategoryProductService {
    CategoryProduct findById(Long categooryId);

    public Map<String, Object> create(CategoryProductDto categoryProductDto);

    public Map<String, Object> update(Long id, CategoryProductDto categoryProductDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

}
