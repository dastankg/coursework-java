package com.example.demo.repository;

import com.example.demo.model.Protocol;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProtocolRepository extends JpaRepository<Protocol, Long> {
//    Protocol findByUsername(String name);

}
