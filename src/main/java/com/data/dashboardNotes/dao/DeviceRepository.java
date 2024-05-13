package com.data.dashboardNotes.dao;

import com.data.dashboardNotes.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByType(String type);
    Device findByCode(String code);
}
