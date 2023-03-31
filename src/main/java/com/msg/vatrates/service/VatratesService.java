package com.msg.vatrates.service;

import com.msg.vatrates.model.EuVatRates;
import com.msg.vatrates.model.VatRate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VatratesService {


    public List<VatRate> getLowestReducedVatRates(EuVatRates euVatRates);

    public List<VatRate> getHigestStandardVatRates(EuVatRates euVatRates);

    }
