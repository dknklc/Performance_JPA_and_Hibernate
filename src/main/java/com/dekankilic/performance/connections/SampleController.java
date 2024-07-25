package com.dekankilic.performance.connections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    private final SampleService sampleService;
    private final ExternalService externalService;

    public SampleController(SampleService sampleService, ExternalService externalService) {
        this.sampleService = sampleService;
        this.externalService = externalService;
    }

    @GetMapping("/hello")
    public void hello() {
        sampleService.hello();
        externalService.externalCall();
    }

    @GetMapping("/external")
    public void external() {
        sampleService.withExternalServiceCall();
    }

    @GetMapping("/external-after")
    public void externalAfter() {
        sampleService.withExternalServiceCallAfter();
    }

    @GetMapping("/nested")
    public void nested() {
        sampleService.withNestedTransaction();
    }
}
