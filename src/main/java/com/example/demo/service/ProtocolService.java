package com.example.demo.service;

import com.example.demo.dto.ProtocolDto;
import com.example.demo.model.Protocol;
import java.util.List;

public interface ProtocolService {

    List<Protocol> getAll();

//    Protocol findByUsername(String username);

    Protocol findById(Long id);
    ProtocolDto save(ProtocolDto dto);
    void delete(Long id);
}
