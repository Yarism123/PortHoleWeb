package com.porthole.porthole.service;

import com.porthole.porthole.entity.PortPos;
import com.porthole.porthole.repository.PortPosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class PortPosService {

    private final PortPosRepository portPosRepository;

    @Transactional
    public void save(PortPos portPos){
        log.info("[PortPosService.save] pos = {}", portPos);
        portPosRepository.save(portPos);
    }

    public List<PortPos> findAll(){
        return portPosRepository.findAll();
    }
}
