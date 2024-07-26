package com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Cacheable
@Getter
@Setter
public class ChessPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "playerWhite")
    private Set<ChessGame> gamesWhite;

    @OneToMany(mappedBy = "playerBlack")
    private Set<ChessGame> gamesBlack;

    // don't use FetchType.EAGER
    @ManyToMany(mappedBy = "players")
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    private Set<ChessTournament> tournaments;

    @Version
    private int version;
}
