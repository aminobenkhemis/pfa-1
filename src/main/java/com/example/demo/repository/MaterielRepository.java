package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.materiel;
import java.util.List;

public interface MaterielRepository extends JpaRepository<materiel,Integer>{
	public List<materiel> findByTypeAndNcategorie(String type,String ncategorie);
	public materiel findByTypeAndNcategorieAndNomAndReference(String type,String ncategorie,String nom,String Reference);
}
