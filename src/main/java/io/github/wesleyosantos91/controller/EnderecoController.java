package io.github.wesleyosantos91.controller;

import io.github.wesleyosantos91.domain.response.Root;
import io.github.wesleyosantos91.service.CepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/enderecos")
public record EnderecoController(CepService service) {

    @GetMapping("/{cep}")
    public Root findByCep(String cep) {
        return service.findByCep(cep);
    }
}
