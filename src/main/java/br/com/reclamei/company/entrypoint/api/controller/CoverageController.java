package br.com.reclamei.company.entrypoint.api.controller;

import br.com.reclamei.company.entrypoint.api.dto.CoverageCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.CoverageUpdateRequest;
import br.com.reclamei.company.entrypoint.api.facade.CoverageFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

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
    public ResponseEntity<Void> delete(final Long serviceTypeId, final Long companyId) {
        facade.deleteById(serviceTypeId, companyId);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody final CoverageUpdateRequest body) {
        facade.update(body);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
