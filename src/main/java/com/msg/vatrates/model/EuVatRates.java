package com.msg.vatrates.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Objects;

public class EuVatRates {

    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("disclaimer")
    private String disclaimer;

    @JsonProperty("rates")
    private HashMap<String, VatRate> rates;

    public EuVatRates(){}

    public EuVatRates(String lastUpdated, String disclaimer, HashMap<String, VatRate> rates) {
        this.lastUpdated = lastUpdated;
        this.disclaimer = disclaimer;
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "EuVatRates{" +
                "lastUpdated=" + lastUpdated +
                ", disclaimer='" + disclaimer + '\'' +
                ", rates=" + rates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EuVatRates that = (EuVatRates) o;
        return Objects.equals(lastUpdated, that.lastUpdated) && Objects.equals(disclaimer, that.disclaimer) && Objects.equals(rates, that.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastUpdated, disclaimer, rates);
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public void setRates(HashMap<String, VatRate> rates) {
        this.rates = rates;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public HashMap<String, VatRate> getRates() {
        return rates;
    }
}
