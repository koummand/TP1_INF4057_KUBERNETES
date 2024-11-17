package com.m1.fonda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.m1.fonda.model.Compte;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, String> {

//	@Query("UPDATE Compte a SET a.solde= a.solde + ?1 WHERE a.account_id= ?2")
//	@Modifying
//	public void updateBalance(float montant, String account_id);

}
