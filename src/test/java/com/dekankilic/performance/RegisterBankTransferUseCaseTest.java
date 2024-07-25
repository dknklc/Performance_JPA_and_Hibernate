package com.dekankilic.performance;

import com.dekankilic.performance.domain.Amount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@UseCaseTest
class RegisterBankTransferUseCaseTest {

    @Autowired
    private RegisterBankTransferUseCase useCase;

    @Test
    void executes() {
        useCase.execute(UUID.randomUUID().toString(), "my reference", "sender-id", "receiver-id", Amount.of(10, "EUR"));
    }

}