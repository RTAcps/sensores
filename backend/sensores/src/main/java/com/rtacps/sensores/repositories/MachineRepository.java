package com.rtacps.sensores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtacps.sensores.entities.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long> {

}
