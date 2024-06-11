package com.porthole.porthole;

import com.porthole.porthole.entity.PortPos;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Pos 자동으로 넣어보기
 * */
@Profile("initPos")
@RequiredArgsConstructor
@Component
public class InitPortPos {

    private final InitPos initPos;

    @PostConstruct
    public void init(){
        initPos.init();
    }
    
    @Component
    @Data
    @RequiredArgsConstructor
    static class InitPos{

        @PersistenceContext
        private EntityManager em;

        @Transactional
        public void init(){
            em.persist(new PortPos(37.20959,126.9777));
        }
    }
}
