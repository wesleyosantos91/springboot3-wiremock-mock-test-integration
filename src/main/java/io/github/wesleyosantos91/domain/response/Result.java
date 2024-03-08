package io.github.wesleyosantos91.domain.response;

public record Result(
        String street,
        String complement,
        String district,
        Integer districtId,
        String city,
        Integer cityId,
        Integer ibgeId,
        String state,
        String stateShortname,
        String zipcode

) {
}
