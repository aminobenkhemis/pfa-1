package com.example.demo.controller;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.materiel;
import com.example.demo.model.user;
import com.example.demo.service.DemoService;
import com.example.demo.service.MaterielService;

import org.springframework.beans.factory.annotation.Autowired;
@RestController
public class DemoController {
	@Autowired
	private DemoService service;
	@Autowired
    private MaterielService mservice; 
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public user registeruser(@RequestBody user user) throws Exception{
		String tempUsername=user.getUsername();
		user userobj=null;
		if(tempUsername != null && !"".equals(tempUsername)) {
			userobj=service.fetchuserByUsername(tempUsername);
		}
			if(userobj != null) {
				throw new Exception("Cette username "+tempUsername+"est déja exist");
			}
				userobj=service.saveuser(user);
				return userobj;
			}
	@PostMapping("/updateuser/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
	public user updateuser(@PathVariable Integer id,@RequestBody user user)throws Exception {	
		user u =service.userid(id);
		user userobj=null;
		String usernameup =user.getUsername();
		String passwordup=user.getPassword();
	    String roleup=user.getRole();
	    userobj=service.fetchuserByUsername(usernameup);
	    if((userobj != null) && (userobj.getUsername() != u.getUsername())) {
			throw new Exception("Cette username "+usernameup+"est déja exist");
		}
	    else {
	    u.setUsername(usernameup);
	    u.setPassword(passwordup);
	    u.setRole(roleup);
	    service.saveuser(u);
	    return u;
	    }
	}
	@GetMapping("/getuser/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
	public user getuserid(@PathVariable Integer id) {	
		return service.userid(id);
	}
	@GetMapping("/getusers")
    @CrossOrigin(origins = "http://localhost:4200")
	public List<user> fetchallusers() {
		return service.fetchall();
	}
	@GetMapping("/getantibiotiqueList")
    @CrossOrigin(origins = "http://localhost:4200")
	public List<materiel> fetchantibiotiquelList() {
		List<materiel> materiels=new ArrayList<materiel>();
		materiels = mservice.fetchmaterielList("medicaments","antibiotique" );
		return materiels;
	}
	@PostMapping("/deluser")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deluser(@RequestBody Integer id ) {
		service.deleteUser(id);
	}
	@PostMapping("/sortirmedicaments")
	@CrossOrigin(origins = "http://localhost:4200")
	public materiel sortirm(@RequestBody materiel materiel) throws Exception {
		String tempType=materiel.getType();
		String tempNcategory=materiel.getNcategorie();
		String tempNom=materiel.getNom();
		String tempRefernce=materiel.getReference();
		int tempQuantite=materiel.getQuantite();
		materiel m=null;
		if(tempType !=null && tempNcategory !=null && tempNom !=null && tempRefernce !=null) {
		m=mservice.sortirstock(tempType, tempNcategory, tempNom, tempRefernce );
		if(m==null) {
			throw new Exception("Erreur");	
		}
		else if(tempQuantite == m.getQuantite() ) {
		mservice.deletem(m);
		}
		else if(tempQuantite < m.getQuantite()) {
		 int q=m.getQuantite()- tempQuantite;
		 m.setQuantite(q);
		 mservice.updateMateriel(m);
		 
		}
		else {
			throw new Exception("Pas de Quantité necessaire");
		}
		}
		return m;
		
	}
	@PostMapping("/addantibiotique")
    @CrossOrigin(origins = "http://localhost:4200")
	public materiel saveantibiotique(@RequestBody materiel materiel) {
		return mservice.saveMaerielToDb(materiel);
		
		}
    @GetMapping("/getantibiotiquebyid/{id}")
    public materiel fetchMaterielById(@PathVariable int id) {
    	return mservice.fetchMaterielById(id).get();
    }
    @DeleteMapping("/deleteantibiotiquebyid/{id}")
	public String DeleteMaterielByid(@PathVariable int id) {
		return mservice.deleteMaterielById(id);
	}
	@GetMapping("/getelectrolyteList")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<materiel> fetchelectrolyteList(){
		List<materiel> materiels=new ArrayList<materiel>();
		materiels = mservice.fetchmaterielList("medicaments","electrolyte" );
		return materiels;
	}
	@PostMapping("/addelectrolyte")
	public materiel saveelectrolyte(@RequestBody materiel materiel) {
		return  mservice.saveMaerielToDb(materiel);
	}
	@GetMapping("/getdrogueList")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<materiel> fetchdrogueList(){
		List<materiel> materiels=new ArrayList<materiel>();
		materiels = mservice.fetchmaterielList("medicaments","drogue sedation" );
		return materiels;
	}
	@PostMapping("/adddrogue")
	public materiel savedrogue(@RequestBody materiel materiel) {
		 return mservice.saveMaerielToDb(materiel);
	}
	@GetMapping("/getautresList")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<materiel> fetchautresList(){
		List<materiel> materiels=new ArrayList<materiel>();
		materiels = mservice.fetchmaterielList("medicaments","autres" );
		return materiels;
	}
	@PostMapping("/addautres")
	public materiel saveautres(@RequestBody materiel materiel) {
		return mservice.saveMaerielToDb(materiel);
	}
	@GetMapping("/getrepiratoireList")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<materiel>fetchrepiratoirelList(){
		List<materiel> materiels=new ArrayList<materiel>();
		materiels = mservice.fetchmaterielList("accessoires","repiratoire" );
		return materiels;
	}
	@PostMapping("/addrepiratoire")
	public materiel saverepiratoire(@RequestBody materiel materiel) {
		 return mservice.saveMaerielToDb(materiel);
	}
	@GetMapping("/getrenalList")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<materiel> fetchrenalList(){
		List<materiel> materiels=new ArrayList<materiel>();
		materiels = mservice.fetchmaterielList("accessoires","renal" );
		return materiels;
	}
	@PostMapping("/addrenal")
	public materiel saverenal(@RequestBody materiel materiel) {
		 return mservice.saveMaerielToDb(materiel);
	}
	@GetMapping("/getdegestifList")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<materiel>fetchdegestifList(){
		List<materiel> materiels=new ArrayList<materiel>();
		materiels = mservice.fetchmaterielList("accessoires","degestif" );
		return materiels;
	}
	@PostMapping("/adddegestif")
	public materiel savedegestif(@RequestBody materiel materiel) {
		return mservice.saveMaerielToDb(materiel);
	}
	@GetMapping("/gethemodynamiqueList")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<materiel>fetchhemodynamiqueList(){
		List<materiel> materiels=new ArrayList<materiel>();
		materiels = mservice.fetchmaterielList("accessoires","hemodynamique" );
		return materiels;
	}
	@PostMapping("/addhemodynamique")
	public materiel savehemodynamique(@RequestBody materiel materiel) {
		 return mservice.saveMaerielToDb(materiel);
	}
	@GetMapping("/getautreList")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<materiel> fetchautreList(){
		List<materiel> materiels=new ArrayList<materiel>();
		materiels = mservice.fetchmaterielList("accessoires","autre" );
		return materiels;
	}
	@PostMapping("/addautre")
	public materiel saveautre(@RequestBody materiel materiel) {
		 return mservice.saveMaerielToDb(materiel);
	}
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
	public user loginUser(@RequestBody user user) throws Exception {
		String tempUsername=user.getUsername();
		String tempPassword=user.getPassword();
		user userObj=null;
		if(tempUsername !=null && tempPassword !=null) {
			userObj=service.fetchuserByUsernameAndPassword(tempUsername,tempPassword);
		}
		if(userObj == null) {
			throw new Exception("Error");
		}
		return userObj;
	}
    @GetMapping("/role")
    @CrossOrigin(origins= "http://localhost:4200")
    public String role(user user) {
    	return user.getRole();
    }
    
}
