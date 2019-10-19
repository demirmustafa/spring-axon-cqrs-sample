package io.github.demirmustafa.springaxoncqrssample.domain.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBookByIdQuery {

    private String id;
}

