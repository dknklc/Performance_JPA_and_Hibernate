package com.dekankilic.performance;

import com.dekankilic.performance.domain.BankTransfer;
import com.dekankilic.performance.domain.BankTransferRepository;
import org.springframework.stereotype.Service;

@Service
public class SettleBankTransferUseCase {
    private final BankTransferRepository bankTransferRepository;

    public SettleBankTransferUseCase(BankTransferRepository bankTransferRepository) {
        this.bankTransferRepository = bankTransferRepository;
    }

    public void execute(String bankTransferId) {
        BankTransfer bankTransfer = bankTransferRepository.findByIdOrThrow(bankTransferId);
        bankTransfer.settle();
        bankTransferRepository.save(bankTransfer);
    }
}
