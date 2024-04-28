package com.rtacps.sensores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtacps.sensores.entities.Leitura;

public interface LeitorRepository extends JpaRepository<Leitura, Long> {

}
