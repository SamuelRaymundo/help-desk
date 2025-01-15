package org.samuelraymundo.helpdesk.controller;

import org.samuelraymundo.helpdesk.domain.dto.TechnitianDTO;
import org.samuelraymundo.helpdesk.domain.entities.Technitian;
import org.samuelraymundo.helpdesk.services.TechnitianService;
import org.samuelraymundo.helpdesk.services.mapper.TechnitianMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
