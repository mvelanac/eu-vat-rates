package com.msg.vatrates.service.impl;

import com.msg.vatrates.model.EuVatRates;
import com.msg.vatrates.model.VatRate;
import com.msg.vatrates.model.VatRateRaw;
import com.msg.vatrates.service.VatratesService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VatratesServiceImpl implements VatratesService {

    public List<VatRate> getHigestStandardVatRates(EuVatRates euVatRates, Integer resultNo) {
        resultNo = getResultNo(euVatRates, resultNo);

        List<VatRate> preprocessedVatRates = preprocessJson(euVatRates);

        List<VatRate> highestVatRates = preprocessedVatRates.stream()
                .sorted(Comparator.comparing(VatRate::getStandardRate).reversed())
                .limit(resultNo)
                .collect(Collectors.toList());

        return highestVatRates;
    }

    public List<VatRate> getLowestReducedVatRates(EuVatRates euVatRates, Integer resultNo) {
        resultNo = getResultNo(euVatRates, resultNo);

        List<VatRate> preprocessedVatRates = preprocessJson(euVatRates);

        List<VatRate> lowestVatRates = preprocessedVatRates.stream()
        .sorted(Comparator.comparing(VatRate::getReducedRate))
        .limit(resultNo)
        .collect(Collectors.toList());

        return lowestVatRates;
    }


    private List<VatRate> preprocessJson(EuVatRates euVatRates) {
        euVatRates.getRates().entrySet()
                .removeIf(entry -> entry.getValue().getIsoDuplicateOf() != null);

        List<VatRate> processedVatRates = euVatRates.getRates().values().stream().
                map(o -> mapVatRateRaw(o))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return processedVatRates;
    }

    private VatRate mapVatRateRaw(VatRateRaw o) {
        try {
            return new VatRate(o.getCountry().toString(),
                    Double.valueOf(o.getStandardRate().toString()),
                    Double.valueOf(o.getReducedRate().toString()),
                    o.getReducedRateAlt(),
                    o.getSuperReducedRate(),
                    o.getParkingRate(),
                    o.getIsoDuplicateOf());

        } catch (NumberFormatException e){
            System.out.println("Error with object: " + o.getCountry());
        }
        return null;
    }

    private static Integer getResultNo(EuVatRates euVatRates, Integer resultNo) {
        resultNo = resultNo == null ? 3 : resultNo;
        resultNo = resultNo > euVatRates.getRates().values().size() ? euVatRates.getRates().values().size() : resultNo;
        return resultNo;
    }

}
