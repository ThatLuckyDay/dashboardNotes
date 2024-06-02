package com.data.dashboardNotes.service;

import com.data.dashboardNotes.dao.DeviceRepository;
import com.data.dashboardNotes.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public void saveDevice(Device device) {
        deviceRepository.save(device);
    }

    public List<Device> findAllTypes() {
        return deviceRepository.findAll();
    }

    public Device findDeviceByType(String type) {
        return deviceRepository.findByType(type);
    }

    public Device findDeviceByCode(String code) {
        return deviceRepository.findByCode(code);
    }

    public void deleteDevice(String type) {
        if (type != null) {
            Device device = deviceRepository.findByType(type);
            deviceRepository.delete(device);
        }
    }

    public void deleteDevice(Device device) {
        if (device != null) {
            deviceRepository.delete(device);
        }
    }
}
