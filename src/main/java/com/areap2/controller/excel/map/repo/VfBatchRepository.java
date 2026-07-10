package com.areap2.controller.excel.map.repo;

import java.util.List;

import com.areap2.controller.excel.map.enity.VillageLandClassEntity;

public interface VfBatchRepository {

    void saveBatch(List<VillageLandClassEntity> records);

}
