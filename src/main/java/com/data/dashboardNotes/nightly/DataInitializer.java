package com.data.dashboardNotes.nightly;

import com.data.dashboardNotes.dao.DeviceRepository;
import com.data.dashboardNotes.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private DeviceRepository deviceRepository;

    @Bean
    public CommandLineRunner getCommandLineRunner() {
//        deviceRepository.deleteAll();
        return args -> {
            if(deviceRepository.count() == 0) {
                deviceRepository.save(new Device(null, "Black Cat", "007.007.007", null,null));
                deviceRepository.save(new Device(null, "White Cat", "003.003.003", null, null));
                deviceRepository.save(new Device(null, "Grey Cat", "006.006.006", null,null));
                deviceRepository.save(new Device(null, "Red Cat", "005.005.005", null, null));
                deviceRepository.save(new Device(null, "Brown Cat", "004.004.004", null, null));
                deviceRepository.save(new Device(null, "Yellow Cat", "002.002.002", null, null));
                deviceRepository.save(new Device(null, "Orange Cat", "001.001.001", null, null));
            }
        };
    }
}
