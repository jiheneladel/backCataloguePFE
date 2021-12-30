package tn.essat.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.dao.IGestionPfe;
import tn.essat.dao.IGestionTypePfe;
import tn.essat.model.Pfe;
import tn.essat.model.TypePfes;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest")
public class Rest {
	@Autowired
	IGestionPfe daopfe;
	
	@Autowired
	IGestionTypePfe daotype;

	public void setDaopfe(IGestionPfe daopfe) {
		this.daopfe = daopfe;
	}

	public void setDaotype(IGestionTypePfe daotype) {
		this.daotype = daotype;
	}
	
	@GetMapping("/pfes")
	public List<Pfe> f1(){
		
		return daopfe.findAll();
		}
	
	@GetMapping("/listpfe/{id}")
	public List<Pfe> f2(@PathVariable("id") int id){
		return daopfe.getAllPfeByTypePfe(id);
		}
	@GetMapping("/chercher/{titre}")
	public List<Pfe> f3(@PathVariable("titre") String titre){
		return daopfe.getAllPfeByTitre(titre);
		}
	@GetMapping("/count")
	public Integer f4(){
		return daopfe.findAll().size();
		}
	@GetMapping("/count2/{id}")
	public Integer f5(@PathVariable("id") int id){
		return daopfe.getAllPfeByTypePfe(id).size();
		}
	
	
	@GetMapping("/listetype")
	public List<TypePfes> meth2(){
		return daotype.findAll();
	}
	 
	@PostMapping("/add")
	public void get1(@RequestBody Pfe pfe ){
	 daopfe.save(pfe);
		
	}
	@DeleteMapping("/delete/{id}")
	public void get2(@PathVariable("id") int id){
		daopfe.deleteById(id);
	}
	
}
