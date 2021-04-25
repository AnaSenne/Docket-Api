package com.docket.docketapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docket.docketapi.model.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long> {

}
