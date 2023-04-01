package com.msg.vatrates;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msg.vatrates.model.EuVatRates;
import com.msg.vatrates.model.VatRate;
import com.msg.vatrates.service.VatratesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class VatratesApplicationTests {

	@Autowired
	private VatratesService vatratesService;

	public void setVatratesService(VatratesService vatratesService) {
		this.vatratesService = vatratesService;
	}

	private EuVatRates euVatRates;

	@BeforeEach
	public void setup() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		InputStream is = Test.class.getResourceAsStream("/vatrates.json");
		euVatRates = mapper.readValue(is, EuVatRates.class);
	}

	@Test
	void getHigest3StandardVatRatesTest() {
		List<VatRate> highest3 = vatratesService.getHigestStandardVatRates(euVatRates, Integer.valueOf(3));
		assertTrue(highest3.size() == 3);
		assertTrue(highest3.get(0).getCountry().equals("Hungary"));
		assertTrue(highest3.get(1).getCountry().equals("Denmark"));
		assertTrue(highest3.get(2).getCountry().equals("Croatia"));

		System.out.println(euVatRates);
	}
	@Test
	void getLowest3ReducedVatRates() {

		List<VatRate> lowest3 = vatratesService.getLowestReducedVatRates(euVatRates, Integer.valueOf(3));
		assertTrue(lowest3.size() == 3);
		assertTrue(lowest3.get(0).getCountry().equals("Denmark"));
		assertTrue(lowest3.get(1).getCountry().equals("United Kingdom"));
		assertTrue(lowest3.get(2).getCountry().equals("Netherlands"));

		System.out.println(euVatRates);


	}

}
