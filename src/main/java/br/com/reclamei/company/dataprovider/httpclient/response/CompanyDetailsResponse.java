package br.com.reclamei.company.dataprovider.httpclient.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompanyDetailsResponse {

    @JsonProperty("razao_social")
    private String socialReason;

    @JsonProperty("estabelecimento")
    private CommercialPlaceResponse commercialPlace;

    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CommercialPlaceResponse {
        private String cnpj;
        private String email;
        @JsonProperty("ddd1")
        private String ddd;
        @JsonProperty("telefone1")
        private String phone;

        @JsonProperty("atividade_principal")
        private MainActivityResponse mainActivity;

        @Getter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class MainActivityResponse {
            @JsonProperty("descricao")
            private String description;
        }
    }

}
