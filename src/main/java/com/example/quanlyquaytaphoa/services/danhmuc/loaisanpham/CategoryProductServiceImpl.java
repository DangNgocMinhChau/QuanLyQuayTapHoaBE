package com.example.quanlyquaytaphoa.services.danhmuc.loaisanpham;


import com.example.quanlyquaytaphoa.models.danhmuc.loaisanpham.CategoryProduct;
import com.example.quanlyquaytaphoa.models.danhmuc.loaisanpham.CategoryProductDto;
import com.example.quanlyquaytaphoa.repositorys.danhmuc.loaisanpham.CategoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {

    @Autowired
    CategoryProductRepository categoryProductRepository;

    @Override
    public CategoryProduct findById(Long categoryId) {
        return categoryProductRepository.findById(categoryId).orElse(null);
    }

    @Override
    public Map<String, Object> create(CategoryProductDto categoryProductDto) {
        Map<String, Object> result = new HashMap<>();
        CategoryProductDto resultCreate = new CategoryProductDto();
        try {
            CategoryProduct categoryProduct = new CategoryProduct();
            categoryProduct.setMa(categoryProductDto.getMa());
            categoryProduct.setTen(categoryProductDto.getTen());
            categoryProduct.setNguoiTao(categoryProductDto.getNguoiTao());
            categoryProduct.setIdNguoiTao(categoryProductDto.getIdNguoiTao());
            categoryProduct.setNgayTaoBanGhi(categoryProductDto.getNgayTaoBanGhi());
            categoryProduct.setFlag(true);
            categoryProductRepository.save(categoryProduct);

            resultCreate.setId(categoryProduct.getId());
            resultCreate.setMa(categoryProduct.getMa());
            resultCreate.setTen(categoryProduct.getTen());
            resultCreate.setNguoiTao(categoryProduct.getNguoiTao());
            resultCreate.setIdNguoiTao(categoryProduct.getIdNguoiTao());
            result.put("result", resultCreate);
            result.put("msg", "Thêm mới " + categoryProductDto.getTen() + " thành công");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, CategoryProductDto categoryProductDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            CategoryProduct object = categoryProductRepository.findById(id).get();
            object.setId(categoryProductDto.getId() != null ? categoryProductDto.getId() : object.getId());
            object.setMa(categoryProductDto.getMa() != null ? categoryProductDto.getMa() : object.getMa());
            object.setTen(categoryProductDto.getTen() != null ? categoryProductDto.getTen() : object.getTen());
            object.setNguoiTao(categoryProductDto.getNguoiTao() != null ? categoryProductDto.getNguoiTao() : object.getNguoiTao());
            object.setIdNguoiTao(categoryProductDto.getIdNguoiTao() != null ? categoryProductDto.getIdNguoiTao() : object.getIdNguoiTao());
            object.setNgayChinhSua(categoryProductDto.getNgayChinhSua());

            categoryProductRepository.save(object);
            result.put("result", object);
            result.put("msg", "Sửa thành công !");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Sửa thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String, Object> result = new HashMap<>();
        CategoryProduct categoryProduct = categoryProductRepository.findById(id).orElse(null);
        CategoryProductDto categoryProductDto = new CategoryProductDto();
        try {
            if (categoryProduct != null) {
                categoryProductDto.setId(categoryProduct.getId());
                categoryProductDto.setMa(categoryProduct.getMa());
                categoryProductDto.setTen(categoryProduct.getTen());
                categoryProductDto.setNguoiTao(categoryProduct.getNguoiTao());
                categoryProductDto.setIdNguoiTao(categoryProduct.getIdNguoiTao());
                result.put("result", categoryProductDto);
                result.put("status", true);
            }
        } catch (Exception e) {
            result.put("result", null);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> result = new HashMap<>();

        try {
            List<CategoryProduct> categoryProductList = categoryProductRepository.findAll();
            List<CategoryProductDto> categoryProductDtoList = new ArrayList<>();
            for (CategoryProduct categoryProduct : categoryProductList) {
                CategoryProductDto categoryProductDto = new CategoryProductDto();
                categoryProductDto.setId(categoryProduct.getId());
                categoryProductDto.setMa(categoryProduct.getMa());
                categoryProductDto.setTen(categoryProduct.getTen());
                categoryProductDto.setNguoiTao(categoryProduct.getNguoiTao());
                categoryProductDto.setIdNguoiTao(categoryProduct.getIdNguoiTao());
                if (categoryProduct.getFlag()) {
                    categoryProductDtoList.add(categoryProductDto);
                }
            }
            result.put("result", categoryProductDtoList);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lấy danh sách thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> delete(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();

        for (int i = 0; i < listIds.length; i++) {
            CategoryProduct categoryProduct = categoryProductRepository.findById(listIds[i]).orElse(null);
            categoryProduct.setFlag(false);

            categoryProductRepository.save(categoryProduct);
            result.put("listId", listIds);
            result.put("msg", "Xoá thành công !");
            result.put("status", true);
        }
        return result;
    }


    @Override
    public Map<String, Object> deleteVinhVien(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<CategoryProduct> listIdCategory = new ArrayList<>();
            for (Long id : listIds) {
                Optional<CategoryProduct> categoryProductOptional = categoryProductRepository.findById(id);
                if (categoryProductOptional.isPresent()) {
                    listIdCategory.add(categoryProductOptional.get());
                }
            }
            result.put("msg", "Xóa thành công !");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Xóa thất bại !");
            result.put("status", false);
        }
        return result;
    }
}
