package com.mphasis.rproject.model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mphasis.rproject.entity.AccountDetails;



@Component("as")
public class AccountDetailsService {
	@Autowired
	private AccountDetailsRepo accountDetailsRepo;
	
	public AccountDetails create( AccountDetails ad) 
	{
		return accountDetailsRepo.save(ad);
	}
	public List<AccountDetails> read() 
	{
		return accountDetailsRepo.findAll();
	}
	public AccountDetails read(String acc_number) 
	{
		return accountDetailsRepo.findById(acc_number).get();
	}
	public AccountDetails update(AccountDetails ad) 
	{
		return accountDetailsRepo.save(ad);
	}
	public void delete(String acc_number) 
	{
		accountDetailsRepo.delete(read(acc_number));
	}
}
