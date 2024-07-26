package com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.dto;

public interface BetterPlayerFullNameIntf {
    String getFirstName();
    String getLastName();

    default String getFullName() {
        return getLastName() + ", " + getFirstName();
    }
}
