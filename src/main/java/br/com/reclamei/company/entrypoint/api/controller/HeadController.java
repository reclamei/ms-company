package br.com.reclamei.company.entrypoint.api.controller;

import br.com.reclamei.company.entrypoint.api.dto.HeadCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.HeadResponse;
import br.com.reclamei.company.entrypoint.api.dto.HeadUpdateRequest;
import br.com.reclamei.company.entrypoint.api.facade.HeadFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heads")
public class HeadController implements HeadsApi {

    private final HeadFacade facade;

    @Override
    @PatchMapping("/{externalId}/approve")
    public ResponseEntity<Void> approveHead(@PathVariable UUID externalId) {
        facade.approveHead(externalId);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    @PatchMapping("/{externalId}/confirm")
    public ResponseEntity<Void> confirmHead(@PathVariable UUID externalId) {
        facade.confirmHead(externalId);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody HeadCreateRequest body) {
        facade.create(body);
        return ResponseEntity.status(CREATED).build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        facade.deleteById(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    @PatchMapping("/{externalId}/deny")
    public ResponseEntity<Void> denyHead(@PathVariable UUID externalId) {
        facade.denyHead(externalId);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<HeadResponse>> getAllHeadsByCompanyId(@PathVariable Long companyId) {
        return ResponseEntity.status(OK).body(facade.getAllHeadsByCompanyId(companyId));
    }

    @Override
    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody HeadUpdateRequest body) {
        facade.update(body);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
