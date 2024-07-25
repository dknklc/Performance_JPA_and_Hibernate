package com.dekankilic.performance;

import com.dekankilic.performance.domain.BankTransfer;
import com.dekankilic.performance.domain.BankTransferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SettleBankTransferUseCase {
    private final BankTransferRepository bankTransferRepository;

    public SettleBankTransferUseCase(BankTransferRepository bankTransferRepository) {
        this.bankTransferRepository = bankTransferRepository;
    }

    @Transactional
    public void execute(String bankTransferId) {
        BankTransfer bankTransfer = bankTransferRepository.findByIdOrThrow(bankTransferId);
        bankTransfer.settle();
        bankTransferRepository.save(bankTransfer);
    }
}
