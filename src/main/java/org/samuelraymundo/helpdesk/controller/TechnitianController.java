package org.samuelraymundo.helpdesk.controller;

import org.samuelraymundo.helpdesk.domain.entities.Technitian;
import org.samuelraymundo.helpdesk.services.TechnitianService;
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

    @GetMapping("/{id}")
    public ResponseEntity<Technitian> findById(@PathVariable Integer id) {
        Technitian obj = technitianService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
