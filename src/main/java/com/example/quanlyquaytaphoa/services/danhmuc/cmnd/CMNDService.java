package com.example.quanlyquaytaphoa.services.danhmuc.cmnd;




import com.example.quanlyquaytaphoa.models.danhmuc.cmnd.CMND;
import com.example.quanlyquaytaphoa.models.danhmuc.cmnd.CMND_Dto;

import java.util.Map;

public interface CMNDService {
    CMND findById(Long quyenId);

    public Map<String, Object> create(CMND_Dto cmnd_dto);

    public Map<String, Object> update(Long id, CMND_Dto cmnd_dto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

}
