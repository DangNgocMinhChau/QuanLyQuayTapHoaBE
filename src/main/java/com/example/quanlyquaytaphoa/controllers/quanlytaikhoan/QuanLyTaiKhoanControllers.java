package com.example.quanlyquaytaphoa.controllers.quanlytaikhoan;

import com.example.quanlyquaytaphoa.models.quanlytaikhoan.QuanLyTaiKhoanDTO;
import com.example.quanlyquaytaphoa.services.quanlytaikhoan.QuanLyTaiKhoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlytaikhoan")
public class QuanLyTaiKhoanControllers {

    @Autowired
    private QuanLyTaiKhoanServiceImpl quanLyTaiKhoanService;

    @PostMapping()
    public Map<String, Object> create(@RequestBody QuanLyTaiKhoanDTO quanLyTaiKhoanDTO) {
        return quanLyTaiKhoanService.create(quanLyTaiKhoanDTO);
    }

    @GetMapping()
    public Map<String, Object> getDanhSachThuoc() {
        return quanLyTaiKhoanService.getAllTaiKhoan();
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return quanLyTaiKhoanService.delete(ids);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody QuanLyTaiKhoanDTO quanLyTaiKhoanDTO) {
        return quanLyTaiKhoanService.update(id, quanLyTaiKhoanDTO);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getQuanLyTaiKhoanById(@PathVariable Long id) {
        return quanLyTaiKhoanService.fetchById(id);
    }

    @GetMapping(value = "login")
    public Map<String, Object> loginUser(@RequestParam String account, String password) {
        return quanLyTaiKhoanService.loginUser(account, password);
    }

    @GetMapping(value = "findAccountByUser")
    public Map<String, Object> getAccoutByTenDangNhap(@RequestParam String account) {
        return quanLyTaiKhoanService.getAccoutByTenDangNhap(account);
    }
}
