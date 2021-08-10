package com.example.quanlyquaytaphoa.services.danhmuc.quyen;


import com.example.quanlyquaytaphoa.models.danhmuc.quyen.Quyen;
import com.example.quanlyquaytaphoa.models.danhmuc.quyen.QuyenDto;
import com.example.quanlyquaytaphoa.repositorys.danhmuc.quyen.QuyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuyenServiceImpl implements QuyenService {

    @Autowired
    QuyenRepository quyenRepository;

    @Override
    public Quyen findById(Long quyenId) {
        return quyenRepository.findById(quyenId).orElse(null);
    }

    @Override
    public Map<String, Object> create(QuyenDto quyenDto) {
        Map<String, Object> result = new HashMap<>();
        QuyenDto resultCreate = new QuyenDto();
        try {
            Quyen quyen = new Quyen();
            quyen.setMa(quyenDto.getMa());
            quyen.setTen(quyenDto.getTen());
            quyen.setNgayTaoBanGhi(quyenDto.getNgayTaoBanGhi());
            quyen.setFlag(true);
            quyenRepository.save(quyen);

            resultCreate.setId(quyen.getId());
            resultCreate.setMa(quyenDto.getMa());
            resultCreate.setTen(quyenDto.getTen());
            result.put("result", resultCreate);
            result.put("msg", "Thêm mới " + quyenDto.getTen() + " thành công");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, QuyenDto quyenDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            Quyen object = quyenRepository.findById(id).get();
            object.setId(quyenDto.getId() != null ? quyenDto.getId() : object.getId());
            object.setMa(quyenDto.getMa() != null ? quyenDto.getMa() : object.getMa());
            object.setTen(quyenDto.getTen() != null ? quyenDto.getTen() : object.getTen());
            object.setNgayChinhSua(quyenDto.getNgayChinhSua());

            quyenRepository.save(object);
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
        Quyen quyen = quyenRepository.findById(id).orElse(null);
        QuyenDto quyenDto = new QuyenDto();
        try {
            if (quyen != null) {
                quyenDto.setId(quyen.getId());
                quyenDto.setMa(quyen.getMa());
                quyenDto.setTen(quyen.getTen());
                result.put("result", quyenDto);
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
            List<Quyen> quyenList = quyenRepository.findAll();
            List<QuyenDto> quyenDtoList = new ArrayList<>();
            for (Quyen quyen : quyenList) {
                QuyenDto quyenDto = new QuyenDto();
                quyenDto.setId(quyen.getId());
                quyenDto.setMa(quyen.getMa());
                quyenDto.setTen(quyen.getTen());
                if (quyen.getFlag()) {
                    quyenDtoList.add(quyenDto);
                }
            }
            result.put("result", quyenDtoList);
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
            Quyen quyen = quyenRepository.findById(listIds[i]).orElse(null);
            quyen.setFlag(false);

            quyenRepository.save(quyen);
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
            List<Quyen> listIdQuyen = new ArrayList<>();
            for (Long id : listIds) {
                Optional<Quyen> quyenOptional = quyenRepository.findById(id);
                if (quyenOptional.isPresent()) {
                    listIdQuyen.add(quyenOptional.get());
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
