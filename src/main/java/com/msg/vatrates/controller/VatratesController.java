package com.msg.vatrates.controller;

import com.msg.vatrates.model.EuVatRates;
import com.msg.vatrates.model.VatRate;
import com.msg.vatrates.service.VatratesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getHighestStandardVatRates(@RequestBody EuVatRates euVatRates, @RequestParam Optional<Integer> resultNo){
        Integer n = resultNo.isPresent() ? resultNo.get() : null;
        List<VatRate> response = vatratesService.getHigestStandardVatRates(euVatRates, n);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/lowest-reduced-vatrates")
    public ResponseEntity getLowestReducedVatRates(@RequestBody EuVatRates euVatRates, @RequestParam Optional<Integer> resultNo){
        Integer n = resultNo.isPresent() ? resultNo.get() : null;
        List<VatRate> response = vatratesService.getLowestReducedVatRates(euVatRates, n);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
