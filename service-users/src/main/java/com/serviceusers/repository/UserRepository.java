package com.serviceusers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.serviceusers.model.Userbanque;
//on change Repository par RepositoryRestResource pour ne pas configurer un controller un service
@RepositoryRestResource
public interface UserRepository extends JpaRepository<Userbanque, Integer>{

}
