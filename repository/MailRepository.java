package com.oasys.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oasys.mail.entity.MailEntity;

@Repository
public interface MailRepository extends JpaRepository<MailEntity, Integer>{
	
	public MailEntity findByEmail(String email);

}
