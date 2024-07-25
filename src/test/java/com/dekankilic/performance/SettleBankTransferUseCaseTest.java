package com.dekankilic.performance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@UseCaseTest
class SettleBankTransferUseCaseTest {
    @Autowired
    private SettleBankTransferUseCase useCase;

    @Test
    void executes() {
        useCase.execute("bank-transfer-id");
    }
}