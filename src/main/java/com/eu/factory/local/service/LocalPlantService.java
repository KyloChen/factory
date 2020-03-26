package com.eu.factory.local.service;

import com.eu.factory.local.entity.LocalPlant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalPlantService extends JpaRepository<LocalPlant, String> {
    public LocalPlant getByPlantId(String plantId);
}
