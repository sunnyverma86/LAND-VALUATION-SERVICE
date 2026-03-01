package com.areap2.excel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.areap2.entity.LandDataExcel;

import jakarta.transaction.Transactional;

@Repository
public interface LandDataExcelRepository extends JpaRepository<LandDataExcel, Long> {

	Page<LandDataExcel> findByDistrictIgnoreCase(String district, Pageable pageable);

	@Modifying
	@Transactional
	@Query(value = """
			    UPDATE areap2landvaluation.areap2_land_data_excel ld
			    SET d_rl_cbd_slab = sd.slab_label
			    FROM public.slab_detail sd
			    JOIN public.slab_group sg ON sd.slab_group_id = sg.id
			    JOIN public.distance_type dt ON sg.distance_type_id = dt.id
			    WHERE ld.district = sg.district
			      AND sg.active = true
			      AND dt.code = 'CBD'
			      AND ld.d_rl_cbd BETWEEN sd.min_value AND sd.max_value
			""", nativeQuery = true)
	int updateDRlCbdSlab();
}