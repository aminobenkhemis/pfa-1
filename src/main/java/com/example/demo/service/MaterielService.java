package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.materiel;
import com.example.demo.repository.MaterielRepository;
@Service
public class MaterielService {

	@Autowired
	private MaterielRepository mrepo;
	public List<materiel> fetchmaterielList(String type,String ncategorie){
	return mrepo.findByTypeAndNcategorie(type, ncategorie);
	}
	public materiel saveMaerielToDb(materiel materiel) {
		 return mrepo.save(materiel);
	}
	public 	Optional<materiel> fetchMaterielById(int id) {
	 return mrepo.findById(id);
	}
	public materiel sortirstock(String type,String ncategorie,String nom,String Reference) {
				return mrepo.findByTypeAndNcategorieAndNomAndReference(type,ncategorie,nom,Reference);
			}
	public void deletem(materiel m) {
		mrepo.delete(m);
	}
	public void updateMateriel(materiel materiel) {
		mrepo.save(materiel);
	}
	public String deleteMaterielById(int id) {
		String result;
		try {
		mrepo.deleteById(id);
		result="Materiel succesufully deleted";
		}
		catch (Exception e){
			result="Materiel with id is not deleted";
		}
      return result;
	}
}
