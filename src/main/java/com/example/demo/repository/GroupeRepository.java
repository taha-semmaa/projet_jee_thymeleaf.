package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe,Long> {

}
