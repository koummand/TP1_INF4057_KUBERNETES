package com.m1.fonda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.m1.fonda.model.Compte;
import com.m1.fonda.model.Notification;

import jakarta.persistence.LockModeType;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, String> {

//	@Query("UPDATE Compte a SET a.solde= a.solde + ?1 WHERE a.account_id= ?2")
//	@Modifying
//	public void updateBalance(float montant, String account_id);
//@Lock me permet d'effect un verouillage permissif pour eviter qu'en cas d'accès concurrent, deux retraits simultanés conduisent à un dépassement du solde.
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("SELECT c FROM Compte c WHERE c.telephone = ?1")
	public Compte findByPhoneNumber(String telephone);
	
	Compte findBytelephone(String telephone);
}
