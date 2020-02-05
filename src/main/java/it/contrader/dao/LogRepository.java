package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.contrader.model.Log;


@Repository
@Transactional
public interface LogRepository extends CrudRepository<Log, Long>{

	
	Log findByid(Long id);
	
}

	
