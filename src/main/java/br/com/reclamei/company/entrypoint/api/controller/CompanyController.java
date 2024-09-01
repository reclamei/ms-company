package br.com.reclamei.company.entrypoint.api.controller;

import br.com.reclamei.company.entrypoint.api.dto.CompanyCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.CompanyResponse;
import br.com.reclamei.company.entrypoint.api.dto.CompanyUpdateRequest;
import br.com.reclamei.company.entrypoint.api.facade.CompanyFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/companies")
public class CompanyController implements CompaniesApi {

    private final CompanyFacade facade;

    @Override
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody final CompanyCreateRequest body) {
        facade.create(body);
        return ResponseEntity.status(CREATED).build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        facade.deleteById(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CompanyResponse>> findAll() {
        return ResponseEntity.status(OK).body(facade.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> findById(@PathVariable final Long id) {
        return ResponseEntity.status(OK).body(facade.findById(id));
    }

    @Override
    @GetMapping("/pending-approval")
    public ResponseEntity<List<CompanyResponse>> getCompaniesPendingApproval() {
        return ResponseEntity.status(OK).body(facade.findCompaniesPendingApproval());
    }

    @Override
    @GetMapping("/head/external-id/{externalId}")
    public ResponseEntity<CompanyResponse> getCompanyByHeadExternalId(@PathVariable UUID externalId) {
        return ResponseEntity.status(OK).body(facade.getCompanyByHeadExternalId(externalId));
    }

    @Override
    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<CompanyResponse> getCompanyDetailsByCnpj(@PathVariable final String cnpj) {
        return ResponseEntity.status(OK).body(facade.getCompanyDetailsByCnpj(cnpj));
    }

    @Override
    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody final CompanyUpdateRequest body) {
        facade.update(body);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
