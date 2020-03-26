package com.eu.factory.local.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LocalPlant {
    private String id;
    private String plantName;
    private int plantCode;
    private int clientX;
    private int clientY;
    private int alarmLevel;

    @Id
    @Column(nullable = false)
    public String getPlantId() {
        return id;
    }

    public void setPlantId(String plantId) {
        this.id = plantId;
    }

    @Column
    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    @Column
    public int getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(int plantCode) {
        this.plantCode = plantCode;
    }

    @Column
    public int getClientX() {
        return clientX;
    }

    public void setClientX(int clientX) {
        this.clientX = clientX;
    }

    @Column
    public int getClientY() {
        return clientY;
    }

    public void setClientY(int clientY) {
        this.clientY = clientY;
    }

    @Column
    public int getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(int alarmLevel) {
        this.alarmLevel = alarmLevel;
    }
}
