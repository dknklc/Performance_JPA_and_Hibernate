package com.dekankilic.performance.connections;

import org.springframework.stereotype.Service;

@Service
public class ExternalService {

    public void externalCall() {
        Sleep.sleep(200);
    }
}
