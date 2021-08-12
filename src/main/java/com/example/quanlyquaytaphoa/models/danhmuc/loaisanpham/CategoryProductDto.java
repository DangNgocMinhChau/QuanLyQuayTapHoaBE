package com.example.quanlyquaytaphoa.models.danhmuc.loaisanpham;

public class CategoryProductDto {
    private Long id;
    private String ma;
    private String ten;
    private String nguoiTao;
    private Long idNguoiTao;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public CategoryProductDto() {
    }

    public String getNgayTaoBanGhi() {
        return ngayTaoBanGhi;
    }

    public void setNgayTaoBanGhi(String ngayTaoBanGhi) {
        this.ngayTaoBanGhi = ngayTaoBanGhi;
    }

    public String getNgayChinhSua() {
        return ngayChinhSua;
    }

    public void setNgayChinhSua(String ngayChinhSua) {
        this.ngayChinhSua = ngayChinhSua;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public Long getIdNguoiTao() {
        return idNguoiTao;
    }

    public void setIdNguoiTao(Long idNguoiTao) {
        this.idNguoiTao = idNguoiTao;
    }
}
