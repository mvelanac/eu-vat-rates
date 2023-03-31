package com.msg.vatrates.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    public VatRate(){}

    public VatRate(String country, Double standardRate, Double reducedRate, Object reducedRateAlt, Object superReducedRate, Object parkingRate) {
        this.country = country;
        this.standardRate = standardRate;
        this.reducedRate = reducedRate;
        this.reducedRateAlt = reducedRateAlt;
        this.superReducedRate = superReducedRate;
        this.parkingRate = parkingRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatRate vatRate = (VatRate) o;
        return Objects.equals(country, vatRate.country) && Objects.equals(standardRate, vatRate.standardRate) && Objects.equals(reducedRate, vatRate.reducedRate) && Objects.equals(reducedRateAlt, vatRate.reducedRateAlt) && Objects.equals(superReducedRate, vatRate.superReducedRate) && Objects.equals(parkingRate, vatRate.parkingRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, standardRate, reducedRate, reducedRateAlt, superReducedRate, parkingRate);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(Double standardRate) {
        this.standardRate = standardRate;
    }

    public Double getReducedRate() {
        return reducedRate;
    }

    public void setReducedRate(Double reducedRate) {
        this.reducedRate = reducedRate;
    }

    public Object getReducedRateAlt() {
        return reducedRateAlt;
    }

    public void setReducedRateAlt(Object reducedRateAlt) {
        this.reducedRateAlt = reducedRateAlt;
    }

    public Object getSuperReducedRate() {
        return superReducedRate;
    }

    public void setSuperReducedRate(Object superReducedRate) {
        this.superReducedRate = superReducedRate;
    }

    public Object getParkingRate() {
        return parkingRate;
    }

    public void setParkingRate(Object parkingRate) {
        this.parkingRate = parkingRate;
    }
}
