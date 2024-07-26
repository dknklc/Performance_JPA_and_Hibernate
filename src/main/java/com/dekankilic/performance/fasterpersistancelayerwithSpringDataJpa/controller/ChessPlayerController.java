package com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.controller;

import com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.model.ChessPlayer;
import com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.repository.ChessPlayerRepository;
import jakarta.persistence.NoResultException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/players")
public class ChessPlayerController {
    private final ChessPlayerRepository chessPlayerRepository;

    public ChessPlayerController(ChessPlayerRepository chessPlayerRepository) {
        this.chessPlayerRepository = chessPlayerRepository;
    }

    @GetMapping("/{id}")
    public ChessPlayer getPlayerById(@PathVariable Long id) {
        Optional<ChessPlayer> optionalChessPlayer = chessPlayerRepository.findById(id);
        if(!optionalChessPlayer.isPresent()){
            throw new NoResultException();
        }
        return optionalChessPlayer.get();
    }
}
