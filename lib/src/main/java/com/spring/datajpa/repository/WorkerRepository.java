package com.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.datajpa.entity.Worker;
@Repository
//@Component
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

}
