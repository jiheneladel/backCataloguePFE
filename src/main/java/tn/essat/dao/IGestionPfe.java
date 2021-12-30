package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.essat.model.Pfe;
@Repository
public interface IGestionPfe extends JpaRepository<Pfe, Integer>{

	@Query("select p from Pfe p where p.type.id=:x")
	public List<Pfe> getAllPfeByTypePfe(@Param("x") int id);
	@Query("select p from Pfe p where p.titre like %:x%")
	public List<Pfe> getAllPfeByTitre(@Param("x") String titre);

}
