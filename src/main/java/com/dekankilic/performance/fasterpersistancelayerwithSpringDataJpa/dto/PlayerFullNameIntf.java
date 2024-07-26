package com.dekankilic.performance.fasterpersistancelayerwithSpringDataJpa.dto;

import org.springframework.beans.factory.annotation.Value;

public interface PlayerFullNameIntf {

    @Value("#{target.lastName + ', ' + target.firstName}")
    String getFullName();
}
