package com.mphasis.rproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.rproject.entity.AccountDetails;
import com.mphasis.rproject.model.AccountDetailsService;

@RestController
@RequestMapping("/accountdetails")
public class AccountDetailsController {
	@Autowired
	AccountDetailsService as;
	
	@GetMapping("/")
	public List<AccountDetails> getAllBranches()
	{
		//display all acc_details
		List<AccountDetails> acds = as.read();
		return acds;
	}
	
	@GetMapping("/{acc_number}")			
	public AccountDetails findAccountByAcN(@PathVariable("acc_number") String acc_number)
	{
		return as.read(acc_number);
	}
	
	@PostMapping("/")
	public AccountDetails  addBranch(@RequestBody AccountDetails  ad)
	{
		return as.create(ad);
	}
	
	@PutMapping("/")
	public AccountDetails  modifyBranch(@RequestBody AccountDetails  ad)
	{
		return as.update(ad);
	}
	
	@DeleteMapping("/{acc_number}")
	public void deleteBranch(@PathVariable("acc_number") String acc_number)
	{
		as.delete(acc_number);
	}


}
