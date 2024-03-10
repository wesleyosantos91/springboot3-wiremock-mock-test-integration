package io.github.wesleyosantos91.client;

import io.github.wesleyosantos91.domain.response.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cepClient", url = "${cep.url}")
public interface CepClient {

    @GetMapping("/api/v1/zipcode/{cep}")
    Root findByCep(@PathVariable("cep") String cep);
}
