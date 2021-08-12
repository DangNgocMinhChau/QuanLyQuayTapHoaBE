package com.example.quanlyquaytaphoa.repositorys.quanlytaikhoan;

import com.example.quanlyquaytaphoa.models.quanlytaikhoan.QuanLyTaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuanLyTaiKhoanRepository extends JpaRepository<QuanLyTaiKhoan, Long> {
    @Query(value = "select * from quan_ly_tai_khoan u " +
            "where u.ten_dang_nhap like CONCAT('',:account,'') and u.mat_khau like CONCAT('',:password,'');"
            , nativeQuery = true)
    QuanLyTaiKhoan loginUser(@Param("account") String account, @Param("password") String password);

    @Query(value = "select * from quan_ly_tai_khoan u " +
            "where u.ten_dang_nhap like CONCAT(:account);"
            , nativeQuery = true)
    QuanLyTaiKhoan getAccoutByTenDangNhap(@Param("account") String account);

}
