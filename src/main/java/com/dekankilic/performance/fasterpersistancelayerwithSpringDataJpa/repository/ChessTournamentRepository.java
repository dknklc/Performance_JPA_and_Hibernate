package com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.repository;

import com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.dto.TournamentIntf;
import com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.model.ChessTournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChessTournamentRepository extends JpaRepository<ChessTournament, Long> {
    TournamentIntf findByName(String name);
}
