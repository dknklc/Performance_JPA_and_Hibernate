package com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.dto;

import java.util.List;

public interface TournamentIntf {
    String getName();
    List<PlayerNameIntf> getPlayers();
}
