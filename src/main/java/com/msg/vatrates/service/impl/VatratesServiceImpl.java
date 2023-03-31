package com.msg.vatrates.service.impl;

import com.msg.vatrates.model.EuVatRates;
import com.msg.vatrates.model.VatRate;
import com.msg.vatrates.service.VatratesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@Service
public class VatratesServiceImpl implements VatratesService {

    public List<VatRate> getLowestReducedVatRates(EuVatRates euVatRates) {
        List<VatRate> lowestVatRates = euVatRates.getRates().values().stream()
                .collect(
                        collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(VatRate::getCountry))), ArrayList::new)
                )
                .stream()
                .sorted(Comparator.comparing(VatRate::getReducedRate))
                .limit(3).map(n -> n).collect(Collectors.toList());
        return lowestVatRates;
    }

    public List<VatRate> getHigestStandardVatRates(EuVatRates euVatRates) {
        List<VatRate> highestVatRates = euVatRates.getRates().values().stream()
                .sorted(Comparator.comparing(VatRate::getStandardRate).reversed())
                .limit(3).map(n -> n).collect(Collectors.toList());

        return highestVatRates;
    }
}
