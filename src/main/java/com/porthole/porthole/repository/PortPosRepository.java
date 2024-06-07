package com.porthole.porthole.repository;

import com.porthole.porthole.entity.PortPos;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortPosRepository extends JpaRepository<PortPos, Long> {

}
