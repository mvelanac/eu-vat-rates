package com.msg.vatrates.controller;

import com.msg.vatrates.model.EuVatRates;
import com.msg.vatrates.model.VatRate;
import com.msg.vatrates.service.VatratesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class VatratesController {

    private VatratesService vatratesService;

   public VatratesController(VatratesService vatratesService){
       this.vatratesService = vatratesService;
   }

    @PostMapping("/highest-standard-vatrates")
    public List<VatRate> getHighestStandardVatRates(@RequestBody EuVatRates euVatRates, @RequestParam Optional<Integer> resultNo){
        Integer n = resultNo.isPresent() ? resultNo.get() : null;
        return vatratesService.getHigestStandardVatRates(euVatRates, n);
    }

    @PostMapping("/lowest-reduced-vatrates")
    public List<VatRate> getLowestReducedVatRates(@RequestBody EuVatRates euVatRates, @RequestParam Optional<Integer> resultNo){
        Integer n = resultNo.isPresent() ? resultNo.get() : null;
        return vatratesService.getLowestReducedVatRates(euVatRates, n);
    }
}
