package com.nle.microservices.limitsservice.controller;

import com.nle.microservices.limitsservice.bean.Limits;
import com.nle.microservices.limitsservice.configuration.LimitsConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Data
public class LimitsController {
    private LimitsConfig limitsConfig;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return Limits.builder()
                .maxLimit(limitsConfig.getMaximum())
                .minLimit(limitsConfig.getMinimum())
                .build();
    }
}
