package br.com.reclamei.company.dataprovider.httpclient;

import br.com.reclamei.company.dataprovider.httpclient.response.GeocodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "geocode-client",
    dismiss404 = true
)
public interface GeocodeFeignClient {

    @GetMapping("/reverse")
    GeocodeResponse getLocalization(
        @RequestParam("lat") String latitude,
        @RequestParam("lon") String longitude);

}
