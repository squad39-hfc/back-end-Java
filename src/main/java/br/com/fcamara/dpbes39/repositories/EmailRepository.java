package br.com.fcamara.dpbes39.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.fcamara.dpbes39.entities.EmailEntity;

public interface EmailRepository extends CrudRepository<EmailEntity, Long> {

}
