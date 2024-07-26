package com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Cacheable
@Getter
@Setter
public class ChessTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToMany
    // private List<ChessPlayer> players = new ArrayList<>();
    private Set<ChessPlayer> players = new HashSet<>();

    @OneToMany
    private Set<ChessGame> games = new HashSet<>();

    @Version
    private int version;

}
