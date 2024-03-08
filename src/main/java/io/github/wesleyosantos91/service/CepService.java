package io.github.wesleyosantos91.service;

import io.github.wesleyosantos91.client.CepClient;
import io.github.wesleyosantos91.domain.response.Root;
import org.springframework.stereotype.Service;

@Service
public record CepService(CepClient client) {

    public Root findByCep(String cep) {
        return client.findByCep(cep);
    }
}
