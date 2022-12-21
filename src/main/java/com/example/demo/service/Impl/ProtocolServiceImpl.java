package com.example.demo.service.Impl;

import com.example.demo.dto.ProtocolDto;
import com.example.demo.mapper.ProtocolMapper;
import com.example.demo.model.Protocol;
import com.example.demo.model.Student;
import com.example.demo.repository.ProtocolRepository;
import com.example.demo.service.ProtocolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class ProtocolServiceImpl implements ProtocolService {
    private final ProtocolRepository protocolRepository;
    @Autowired
    public ProtocolServiceImpl(ProtocolRepository protocolRepository) {
        this.protocolRepository = protocolRepository;
    }

    @Override
    public Protocol register(Protocol protocol) {
        return null;
    }

    @Override
    public List<Protocol> getAll() {
        List<Protocol> groups = protocolRepository.findAll();
        log.info("IN getAll - {} group found", groups.size());
        return groups;
    }

//    @Override
//    public Protocol findByUsername(String username) {
//        Protocol result =  protocolRepository.findByUsername(username);
//        log.info("IN findByName - group: {} found by name {}", result, username);
//        return result;
//    }

    @Override
    public Protocol findById(Long id) {
        Protocol result = protocolRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no group r found by id: {}", id);
            return null;
        }

        log.info("IN findById - group: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public ProtocolDto save(ProtocolDto dto) {
        Protocol protocol = ProtocolMapper.DtoToEntity(dto);
        protocolRepository.save(protocol);
        return ProtocolMapper.EntityToDto(protocol);
    }


    @Override
    public void delete(Long id) {

    }

//    @Override
//    public Protocol findByName(String username) {
//        Protocol result =  protocolRepository.findByName(username);
//        log.info("IN findByName - group: {} found by name {}", result, username);
//        return result;
//    }


}
