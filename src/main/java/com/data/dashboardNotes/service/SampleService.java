package com.data.dashboardNotes.service;

import com.data.dashboardNotes.dao.SampleRepository;
import com.data.dashboardNotes.model.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {
    private final SampleRepository sampleRepository;

    @Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public List<Sample> findByType(String type) {
        return sampleRepository.findSampleByDeviceType(type);
    }

    public Sample findSampleById(long id) {
        return sampleRepository.findById(id).orElse(null);
    }

    public List<Sample> findByTypeAndNumber(String type, long number) {
        return sampleRepository.findSampleByDeviceTypeAndNumber(type, number);
    }

    public void saveSample(Sample sample) {
        sampleRepository.save(sample);
    }

    public void deleteSample(Sample sample) {
        sampleRepository.delete(sample);
    }
}
