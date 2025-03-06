package org.samuelraymundo.helpdesk.controller;

import jakarta.validation.Valid;
import org.samuelraymundo.helpdesk.domain.dto.TechnitianDTO;
import org.samuelraymundo.helpdesk.domain.entities.Technitian;
import org.samuelraymundo.helpdesk.services.TechnitianService;
import org.samuelraymundo.helpdesk.services.mapper.TechnitianMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.samuelraymundo.helpdesk.domain.enums.Profile;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/technitian")
public class TechnitianController {

    @Autowired
    private TechnitianService technitianService;

    @Autowired
    private TechnitianMapper technitianMapper;

    @GetMapping("/{id}")
    public ResponseEntity<TechnitianDTO> findById(@PathVariable Integer id) {
        Technitian obj = technitianService.findById(id);
        TechnitianDTO dto = technitianMapper.toDTO(obj);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<TechnitianDTO>> findAll() {
        List<Technitian> list = technitianService.findAll();
        List<TechnitianDTO> listDTO = list.stream().map(obj -> technitianMapper.toDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<TechnitianDTO> create(@Valid @RequestBody TechnitianDTO dto) {
        TechnitianDTO obj = technitianService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TechnitianDTO> update(@PathVariable Integer id,
                                                @Valid @RequestBody TechnitianDTO dto) {
        Technitian updatedTechnitian = technitianService.update(id, dto);

        TechnitianDTO updatedDto = new TechnitianDTO(
                updatedTechnitian.getId(),
                updatedTechnitian.getName(),
                updatedTechnitian.getCpf(),
                updatedTechnitian.getEmail(),
                updatedTechnitian.getPassword(),
                updatedTechnitian.getProfiles().stream().map(Profile::getCode).collect(Collectors.toSet()),
                updatedTechnitian.getCreationDate()
        );

        return ResponseEntity.ok(updatedDto);
    }


}
