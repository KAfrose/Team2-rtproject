package com.mphasis.rproject.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.rproject.entity.AccountDetails;

@Repository
public interface AccountDetailsRepo extends JpaRepository<AccountDetails, String>{

}
