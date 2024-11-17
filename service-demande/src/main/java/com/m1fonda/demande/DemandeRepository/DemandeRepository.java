package com.m1fonda.demande.DemandeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.m1fonda.demande.model.Demande;

@RepositoryRestResource
public interface DemandeRepository  extends JpaRepository<Demande, Integer>{

}
