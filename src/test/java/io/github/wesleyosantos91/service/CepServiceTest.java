package io.github.wesleyosantos91.service;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.github.wesleyosantos91.domain.response.Root;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"cep.url=http://localhost:${wiremock.server.port}"})
@AutoConfigureWireMock(port = 0)
class CepServiceTest {

    @Autowired
    private CepService cepService;

    @Test
    void name() {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/v1/zipcode/72405033"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("cep.json")));

        Root root = cepService.findByCep("72405033");

        assertThat(root).isNotNull().satisfies(r -> {
            assertThat(r.result().street()).isEqualTo("Quadra 3 Projeção 3");
            assertThat(r.result().district()).isEqualTo("Setor Central (Gama)");
            assertThat(r.result().city()).isEqualTo("Brasília");
            assertThat(r.result().state()).isEqualTo("Distrito Federal");
            assertThat(r.result().zipcode()).isEqualTo("72405033");
        });
    }
}