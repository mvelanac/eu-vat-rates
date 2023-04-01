package com.msg.vatrates.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashMap;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EuVatRates {

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("disclaimer")
    private String disclaimer;

    @JsonProperty("rates")
    private HashMap<String, VatRateRaw> rates;

}
