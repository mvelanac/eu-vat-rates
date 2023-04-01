package com.msg.vatrates.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VatRateRaw {

    @JsonProperty("country")
    private Object country;

    @JsonProperty("standard_rate")
    private Object standardRate;

    @JsonProperty("reduced_rate")
    private Object reducedRate;

    @JsonProperty("reduced_rate_alt")
    private Object reducedRateAlt;

    @JsonProperty("super_reduced_rate")
    private Object superReducedRate;

    @JsonProperty("parking_rate")
    private Object parkingRate;

    @JsonProperty("iso_duplicate_of")
    private Object isoDuplicateOf;
}
