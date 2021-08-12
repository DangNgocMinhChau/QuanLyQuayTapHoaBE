package com.example.quanlyquaytaphoa.services.danhmuc.cmnd;


import com.example.quanlyquaytaphoa.models.danhmuc.cmnd.CMND;
import com.example.quanlyquaytaphoa.models.danhmuc.cmnd.CMND_Dto;
import com.example.quanlyquaytaphoa.models.danhmuc.quyen.Quyen;
import com.example.quanlyquaytaphoa.models.danhmuc.quyen.QuyenDto;
import com.example.quanlyquaytaphoa.repositorys.danhmuc.cmnd.CMNDRepository;
import com.example.quanlyquaytaphoa.repositorys.danhmuc.quyen.QuyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CMNDServiceImpl implements CMNDService {

    @Autowired
    CMNDRepository cmndRepository;

    @Override
    public CMND findById(Long quyenId) {
        return cmndRepository.findById(quyenId).orElse(null);
    }

    @Override
    public Map<String, Object> create(CMND_Dto cmnd_dto) {
        Map<String, Object> result = new HashMap<>();
        CMND_Dto resultCreate = new CMND_Dto();
        try {
            CMND cmnd = new CMND();
            cmnd.setIdNguoiTao(cmnd_dto.getIdNguoiTao());
            cmnd.setNguoiTao(cmnd_dto.getNguoiTao());
            cmnd.setSoCMND(cmnd_dto.getSoCMND());
            cmnd.setNgayTaoBanGhi(cmnd_dto.getNgayTaoBanGhi());
            cmnd.setFlag(true);
            cmndRepository.save(cmnd);

            resultCreate.setId(cmnd.getId());
            resultCreate.setIdNguoiTao(cmnd_dto.getIdNguoiTao());
            resultCreate.setNguoiTao(cmnd_dto.getNguoiTao());
            resultCreate.setSoCMND(cmnd_dto.getSoCMND());
            result.put("result", resultCreate);
            result.put("msg", "Thêm mới " + cmnd_dto.getSoCMND() + " thành công");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, CMND_Dto cmnd_dto) {
        Map<String, Object> result = new HashMap<>();
        try {
            CMND object = cmndRepository.findById(id).get();
            object.setId(cmnd_dto.getId() != null ? cmnd_dto.getId() : object.getId());
            object.setSoCMND(cmnd_dto.getSoCMND() != null ? cmnd_dto.getSoCMND() : object.getSoCMND());
            object.setIdNguoiTao(cmnd_dto.getIdNguoiTao() != null ? cmnd_dto.getIdNguoiTao() : object.getIdNguoiTao());
            object.setNguoiTao(cmnd_dto.getNguoiTao() != null ? cmnd_dto.getNguoiTao() : object.getNguoiTao());
            object.setNgayChinhSua(cmnd_dto.getNgayChinhSua());

            cmndRepository.save(object);
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
        CMND cmnd = cmndRepository.findById(id).orElse(null);
        CMND_Dto cmnd_dto = new CMND_Dto();
        try {
            if (cmnd != null) {
                cmnd_dto.setId(cmnd.getId());
                cmnd_dto.setSoCMND(cmnd.getSoCMND());
                cmnd_dto.setIdNguoiTao(cmnd.getIdNguoiTao());
                cmnd_dto.setNguoiTao(cmnd.getNguoiTao());
                result.put("result", cmnd_dto);
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
            List<CMND> cmndList = cmndRepository.findAll();
            List<CMND_Dto> cmnd_dtoList = new ArrayList<>();
            for (CMND cmnd : cmndList) {
                CMND_Dto cmnd_dto = new CMND_Dto();
                cmnd_dto.setId(cmnd.getId());
                cmnd_dto.setNguoiTao(cmnd.getNguoiTao());
                cmnd_dto.setIdNguoiTao(cmnd.getIdNguoiTao());
                cmnd_dto.setSoCMND(cmnd.getSoCMND());
                if (cmnd.getFlag()) {
                    cmnd_dtoList.add(cmnd_dto);
                }
            }
            result.put("result", cmnd_dtoList);
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
            CMND cmnd = cmndRepository.findById(listIds[i]).orElse(null);
            cmnd.setFlag(false);

            cmndRepository.save(cmnd);
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
            List<CMND> listIdCMND = new ArrayList<>();
            for (Long id : listIds) {
                Optional<CMND> cmndOptional = cmndRepository.findById(id);
                if (cmndOptional.isPresent()) {
                    listIdCMND.add(cmndOptional.get());
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
