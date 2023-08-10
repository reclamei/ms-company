package br.com.reclamei.company.entrypoint.api.controller;

import br.com.reclamei.company.entrypoint.api.dto.ServiceTypeCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.ServiceTypeResponse;
import br.com.reclamei.company.entrypoint.api.dto.ServiceTypeUpdateRequest;
import br.com.reclamei.company.entrypoint.api.facade.ServiceTypeFacade;
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

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service-types")
public class ServiceTypeController implements ServiceTypesApi {

    private final ServiceTypeFacade facade;

    @Override
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody final ServiceTypeCreateRequest request) {
        facade.create(request);
        return ResponseEntity.status(CREATED).build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        facade.deleteById(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ServiceTypeResponse> findById(@PathVariable final Long id) {
        return ResponseEntity.status(OK).body(facade.findById(id));
    }

    @Override
    @PutMapping
    public ResponseEntity<Void> update(final ServiceTypeUpdateRequest request) {
        facade.update(request);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
