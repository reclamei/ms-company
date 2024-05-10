package br.com.reclamei.company.entrypoint.api.controller;

import br.com.reclamei.company.entrypoint.api.facade.HeadFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heads")
public class HeadController implements HeadsApi {

    private final HeadFacade facade;

    @Override
    @PatchMapping("/{externalId}/confirm")
    public ResponseEntity<Void> confirmHead(UUID externalId) {
        facade.confirmHead(externalId);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
