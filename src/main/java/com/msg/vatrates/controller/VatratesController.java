package com.msg.vatrates.controller;

import com.msg.vatrates.model.EuVatRates;
import com.msg.vatrates.model.VatRate;
import com.msg.vatrates.service.VatratesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VatratesController {

    private VatratesService vatratesService;

   public VatratesController(VatratesService vatratesService){
       this.vatratesService = vatratesService;
   }

    @PostMapping("/getHighestStandardVatRates")
    public List<VatRate> getHighestStandardVatRates(@RequestBody EuVatRates euVatRates){
        return vatratesService.getHigestStandardVatRates(euVatRates);
    }

    @PostMapping("/getLowestReducedVatRates")
    public List<VatRate> getLowestReducedVatRates(@RequestBody EuVatRates euVatRates){
        return vatratesService.getLowestReducedVatRates(euVatRates);
    }
}
