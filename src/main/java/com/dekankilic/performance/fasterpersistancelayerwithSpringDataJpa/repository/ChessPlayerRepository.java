package com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.repository;

import com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.dto.BetterPlayerFullNameIntf;
import com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.dto.PlayerFullNameIntf;
import com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.dto.PlayerName;
import com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.dto.PlayerNameIntf;
import com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.model.ChessPlayer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ChessPlayerRepository extends JpaRepository<ChessPlayer, Long> {

    //     @Query("SELECT p FROM ChessPlayer p LEFT JOIN FETCH p.tournaments t")
    @EntityGraph(attributePaths = "tournaments")
    List<ChessPlayer> findWithTournamentsBy();

    PlayerName findDtoByFirstName(String firstName);

    PlayerNameIntf findByFirstName(String firstName);

    @Query(value = "SELECT first_name as firstName, last_name as lastName FROM Chess_Player p WHERE p.first_name=:firstName",
            nativeQuery = true)
    PlayerNameIntf findNativeByFirstName(String firstName);

    @Query(value = "SELECT first_name as firstName, last_name as lastName FROM Chess_Player p WHERE p.first_name=:firstName",
            nativeQuery = true)
    PlayerNameIntf findDtoNativeByFirstName(String firstName);

    PlayerFullNameIntf findFullNameByFirstName(String firstName);

    BetterPlayerFullNameIntf findBetterFullNameByFirstName(String firstName);

    ChessPlayer findPlayerById(Long id);

    @Transactional(readOnly=true)
    ChessPlayer findPlayerReadOnlyById(Long id);
}
