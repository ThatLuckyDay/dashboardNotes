package com.data.dashboardNotes.dao;

import com.data.dashboardNotes.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
    List<Sample> findSampleByDeviceType(String type);

    List<Sample> findSampleByDeviceTypeAndNumber(String type, long number);
}
