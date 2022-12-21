package com.example.demo.rest;

import com.example.demo.dto.ProtocolDto;
import com.example.demo.model.Protocol;
import com.example.demo.model.Student;
import com.example.demo.service.ProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/protocol")
public class ProtocolRestControllerV1 {
    private final ProtocolService protocolService;
    @Autowired
    public ProtocolRestControllerV1(ProtocolService protocolService) {
        this.protocolService = protocolService;
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<ProtocolDto> getUserById(@PathVariable(name = "id") Long id) {
        Protocol user = protocolService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ProtocolDto result = ProtocolDto.fromProtocol(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping(value = "/create/")
    ResponseEntity<ProtocolDto> createProtocol(@RequestBody ProtocolDto dto) {
        return ResponseEntity.ok().body(protocolService.save(dto));
    }
    @GetMapping(value = "/protocols/")
    public ResponseEntity<List<Protocol>> getAll() {
        return ResponseEntity.ok(protocolService.getAll());
    }
}
