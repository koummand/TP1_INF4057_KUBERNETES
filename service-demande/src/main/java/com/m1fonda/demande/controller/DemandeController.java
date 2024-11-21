package com.m1fonda.demande.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

import com.m1fonda.demande.model.Demande;
import com.m1fonda.demande.service.DemandeService;

@RequestMapping("/api/demande")
@RestController
public class DemandeController {
@Autowired
private DemandeService demandeService;

@PostMapping("/adddemande")
public void addDemandeController(@RequestBody Demande demande) {
demandeService.envoyerDemandeCreationCompte(demande);
}
}
