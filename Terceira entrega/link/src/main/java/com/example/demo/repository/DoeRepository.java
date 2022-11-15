package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Doe;

public interface DoeRepository extends JpaRepository<Doe, Long>{

}
