package br.com.reclamei.company.entrypoint.api.controller;

import br.com.reclamei.company.entrypoint.api.dto.CoverageCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.CoverageResponse;
import br.com.reclamei.company.entrypoint.api.dto.CoverageUpdateRequest;
import br.com.reclamei.company.entrypoint.api.facade.CoverageFacade;
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

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coverages")
public class CoverageController implements CoveragesApi {

    private final CoverageFacade facade;

    @Override
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody final CoverageCreateRequest body) {
        facade.create(body);
        return ResponseEntity.status(CREATED).build();
    }

    @Override
    @DeleteMapping("/{serviceTypeId}/{companyId}")
    public ResponseEntity<Void> delete(@PathVariable final Long serviceTypeId, @PathVariable final Long companyId) {
        facade.deleteById(serviceTypeId, companyId);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CoverageResponse>> findAll() {
        return ResponseEntity.status(OK).body(facade.findAll());
    }

    @Override
    @GetMapping("/{companyId}")
    public ResponseEntity<List<CoverageResponse>> findByCompanyId(@PathVariable final Long companyId) {
        return ResponseEntity.status(OK).body(facade.findByCompanyId(companyId));
    }

    @Override
    @GetMapping("/{serviceTypeId}/{companyId}")
    public ResponseEntity<CoverageResponse> findById(@PathVariable final Long serviceTypeId, @PathVariable final Long companyId) {
        return ResponseEntity.status(OK).body(facade.findById(serviceTypeId, companyId));
    }

    @Override
    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody final CoverageUpdateRequest body) {
        facade.update(body);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
