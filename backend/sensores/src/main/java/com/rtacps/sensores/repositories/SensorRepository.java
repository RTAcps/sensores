package com.rtacps.sensores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtacps.sensores.entities.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long>{

}
