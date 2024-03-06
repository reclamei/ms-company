package br.com.reclamei.company.dataprovider.httpclient;

import br.com.reclamei.company.dataprovider.httpclient.response.CompanyDetailsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "cnpj-ws-client",
        dismiss404 = true
)
public interface CnpjFeignClient {

    @GetMapping("/cnpj/{cnpj}")
    CompanyDetailsResponse getDetailsByCnpj(@PathVariable("cnpj") String cnpj);

}
