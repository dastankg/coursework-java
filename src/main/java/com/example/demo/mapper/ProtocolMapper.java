package com.example.demo.mapper;

import com.example.demo.dto.ProtocolDto;
import com.example.demo.model.Protocol;

public class ProtocolMapper {
    public static Protocol DtoToEntity(ProtocolDto dto){
        Protocol protocol = new Protocol();
        protocol.setId(dto.getId());
        protocol.setAgendas(dto.getAgendas());
        protocol.setHearing(dto.getHearing());
        protocol.setDecided(dto.getDecided());
        protocol.setGroup(dto.getGroup());
        return protocol;
    }

    public static ProtocolDto EntityToDto(Protocol protocol){
        ProtocolDto dto  = new ProtocolDto();
        dto.setId(protocol.getId());
        dto.setAgendas(protocol.getAgendas());
        dto.setHearing(protocol.getHearing());
        dto.setDecided(protocol.getDecided());
        dto.setGroup(protocol.getGroup());
        return dto;
    }
}
