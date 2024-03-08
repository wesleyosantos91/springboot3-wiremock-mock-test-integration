package io.github.wesleyosantos91.domain.response;

public record Meta(
        Integer currentPage,
        Integer itemsPerPage,
        Integer totalOfItems,
        Integer totalOfPages
) {
}
