package br.com.reclamei.company.entrypoint.api.controller;

import br.com.reclamei.company.entrypoint.api.dto.LocationCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.LocationResponse;
import br.com.reclamei.company.entrypoint.api.dto.LocationUpdateRequest;
import br.com.reclamei.company.entrypoint.api.facade.LocationFacade;
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
@RequestMapping("/locations")
public class LocationController implements LocationsApi {

    private final LocationFacade facade;

    @Override
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody final LocationCreateRequest body) {
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
    @GetMapping("/{latitude}/{longitude}")
    public ResponseEntity<LocationResponse> findByLocalization(final String latitude, final String longitude) {
        return ResponseEntity.status(OK).body(facade.findByLocalization(latitude, longitude));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<LocationResponse>> findAll() {
        return ResponseEntity.status(OK).body(facade.findAll());
    }

    @Override
    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody final LocationUpdateRequest body) {
        facade.update(body);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
