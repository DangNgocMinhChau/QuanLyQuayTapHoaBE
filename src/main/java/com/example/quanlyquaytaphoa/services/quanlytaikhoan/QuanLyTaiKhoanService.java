package com.example.quanlyquaytaphoa.services.quanlytaikhoan;



import com.example.quanlyquaytaphoa.models.quanlytaikhoan.QuanLyTaiKhoan;
import com.example.quanlyquaytaphoa.models.quanlytaikhoan.QuanLyTaiKhoanDTO;

import java.util.Map;

public interface QuanLyTaiKhoanService {
    public Map<String, Object> create(QuanLyTaiKhoanDTO quanLyTaiKhoanDTO);

    public Map<String, Object> update(Long id, QuanLyTaiKhoanDTO quanLyTaiKhoanDTO);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAllTaiKhoan();

    public Map<String, Object> delete(Long[] listIds);

    QuanLyTaiKhoan findById(Long id);

    public Map<String, Object> loginUser(String account, String password);

    public Map<String, Object> getAccoutByTenDangNhap(String account);


}
