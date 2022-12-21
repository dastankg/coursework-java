package com.example.demo.service;

import com.example.demo.dto.ProtocolDto;
import com.example.demo.model.Protocol;
import com.example.demo.model.Student;
import org.springframework.security.core.parameters.P;

import javax.lang.model.type.PrimitiveType;
import java.util.List;

public interface ProtocolService {
    Protocol register(Protocol protocol);

    List<Protocol> getAll();

//    Protocol findByUsername(String username);

    Protocol findById(Long id);
    ProtocolDto save(ProtocolDto dto);
    void delete(Long id);
}
