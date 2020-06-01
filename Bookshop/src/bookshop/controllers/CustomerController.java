package bookshop.controllers;


import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Optional;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import bookshop.repositories.facade.RepositoriesFacade;
import bookshop.viewmodels.CustomerView;
import bookshop.viewmodels.ViewModelFacade;
import bookshop.entities.Customer;
import bookshop.entities.Password;


public class CustomerController {
	private static CustomerController instance = null;
	private RepositoriesFacade repositoriesFacade = RepositoriesFacade.getInstance();
	private ViewModelFacade viewModelFacade = ViewModelFacade.getInstance();

	public static CustomerController getInstance() {
		return (instance==null) ? new CustomerController() : instance;
	}


	private CustomerController() {
		super();
	}


	private static byte[] generateSalt() {
		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			byte[] salt = new byte[8];
			random.nextBytes(salt);
			return salt;
		} catch (NoSuchAlgorithmException exce) {
			exce.printStackTrace();
			return "42".getBytes();
		}
	}

	private static byte[] generatePassword(String password, byte[] salt) {
		try {
			SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			KeySpec ks = new PBEKeySpec(password.toCharArray(), salt, 10000, 160);
			SecretKey s = f.generateSecret(ks);
			Key k = new SecretKeySpec(s.getEncoded(), "AES");
			return k.getEncoded();
		} catch (InvalidKeySpecException | NoSuchAlgorithmException exce) {
			exce.printStackTrace();
			return password.getBytes();
		}
	}

	public boolean checkPassword(Customer customer, String passwd) {
		byte[] pwd = customer.getPassword().getPwdHash();
		byte[] salt = customer.getPassword().getSalt();
		byte[] pwdToTest = generatePassword(passwd, salt);
		boolean compare = true;
		if (pwd.length != pwdToTest.length)
			return false;
		for (int i = 0; i < pwd.length; i++) {
			compare &= (pwd[i] == pwdToTest[i]);
		}
		return compare;
	}
	
	public boolean checkPassword(CustomerView customer, String passwd) {
		byte[] pwd = customer.getPassword().getPwdHash();
		byte[] salt = customer.getPassword().getSalt();
		byte[] pwdToTest = generatePassword(passwd, salt);
		boolean compare = true;
		if (pwd.length != pwdToTest.length)
			return false;
		for (int i = 0; i < pwd.length; i++) {
			compare &= (pwd[i] == pwdToTest[i]);
		}
		return compare;
	}

	public Optional<CustomerView> lookupUser(String username) {
		return viewModelFacade.getAllCustomers().stream().filter(c->c.getName().equals(username)).findFirst();
	}

	public boolean register(Customer customer, String password) {
		if (this.lookupUser(customer.getName()).isPresent()) {
			RuntimeException exce = new RuntimeException("User " + customer.getName() + " exists");
			throw exce;
		} else {
			byte[] salt = generateSalt();
			byte[] pwdHash = generatePassword(password, salt);
			Password pwd = new Password(customer,pwdHash,salt);
			customer.setPassword(pwd);
			
			return repositoriesFacade.createCustomer(customer);
		}
	}
	
}

