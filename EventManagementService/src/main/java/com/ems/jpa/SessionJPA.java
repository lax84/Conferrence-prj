package com.ems.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ems.entities.*;

public interface SessionJPA extends JpaRepository<Session, Integer> {

}
