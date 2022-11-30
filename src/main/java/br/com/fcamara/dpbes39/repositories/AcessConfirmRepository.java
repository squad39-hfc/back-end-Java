package br.com.fcamara.dpbes39.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.fcamara.dpbes39.entities.NewUsers;

public interface AcessConfirmRepository extends CrudRepository<NewUsers, Integer>{

}
