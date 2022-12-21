package com.example.demo.dto;

import com.example.demo.model.Group;
import com.example.demo.model.Protocol;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProtocolDto {
    private Long id;
    private String agendas;
    private String hearing;
    private String decided;
    private Group group;

    public static ProtocolDto fromProtocol(Protocol protocol) {
        ProtocolDto protocolDto = new ProtocolDto();
        protocolDto.setId(protocol.getId());
        protocolDto.setAgendas(protocol.getAgendas());
        protocolDto.setHearing(protocol.getHearing());
        protocolDto.setDecided(protocol.getDecided());
        protocolDto.setGroup(protocol.getGroup());
        return protocolDto;
    }
    public Protocol toProtocol(){
        Protocol protocol = new Protocol();
        protocol.setId(id);
        protocol.setAgendas(agendas);
        protocol.setHearing(hearing);
        protocol.setDecided(decided);
        protocol.setGroup(group);
        return protocol;
    }


}
