package com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class ChessGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private int round;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChessTournament chessTournament;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChessPlayer playerWhite;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChessPlayer playerBlack;

    @Version
    private int version;
}
