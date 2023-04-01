package com.msg.vatrates.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Objects;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VatRate {

    @JsonProperty("country")
    private String country;

    @JsonProperty("standard_rate")
    private Double standardRate;

    @JsonProperty("reduced_rate")
    private Double reducedRate;

    @JsonProperty("reduced_rate_alt")
    private Object reducedRateAlt;

    @JsonProperty("super_reduced_rate")
    private Object superReducedRate;

    @JsonProperty("parking_rate")
    private Object parkingRate;

}
