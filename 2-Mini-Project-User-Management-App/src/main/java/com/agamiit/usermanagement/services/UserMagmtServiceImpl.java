package com.agamiit.usermanagement.services;



import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.agamiit.usermanagement.binding.LoginForm;
import com.agamiit.usermanagement.binding.UnlockAccForm;
import com.agamiit.usermanagement.binding.UserRegForm;
import com.agamiit.usermanagement.entites.CityMasterEntity;
import com.agamiit.usermanagement.entites.CountryMasterEntity;
import com.agamiit.usermanagement.entites.StateMasterEntity;
import com.agamiit.usermanagement.entites.UserAccountEntity;
import com.agamiit.usermanagement.repositories.CityMasterRepository;
import com.agamiit.usermanagement.repositories.CountryMasterRepository;
import com.agamiit.usermanagement.repositories.StateMasterRepository;
import com.agamiit.usermanagement.repositories.UserAccountRepository;
import com.google.common.io.Files;
import com.sun.el.stream.Stream;

import net.bytebuddy.utility.RandomString;

public class UserMagmtServiceImpl implements UserMgmtService {

	@Autowired
	private UserAccountRepository UserAccRepo;

	@Autowired
	private CountryMasterRepository countryRepo;

	@Autowired
	private StateMasterRepository stateRepo;

	@Autowired
	private CityMasterRepository CityRepo;

	@Override
	public String loginCheck(LoginForm loginForm) {
		UserAccountEntity userAccountEntity = UserAccRepo.findByEmailAndPassWord(loginForm.getEmail(),
				loginForm.getPassword());
		if (userAccountEntity == null) {
			return "Invalid Credentials";
		}
		if (userAccountEntity.getAccStatus().equals("Locked")) {
			return "your account locked";

		}
		return "Succuced";
	}

	@Override
	public String emailCheck(String emailId) {
		UserAccountEntity userAccountEntity = UserAccRepo.findByEmail(emailId);
		if (userAccountEntity == null) {
			return "UNIQUE";
		}
		return "DUPICATE";
	}

	@Override
	public Map<Integer, String> loadCountries() {
		List<CountryMasterEntity> findAll = countryRepo.findAll();
		Map<Integer, String> countryMap = new HashMap<>();
		findAll.forEach(country -> {
			countryMap.put(country.getCountryId(), country.getCountryName());
		});
		return countryMap;
	}

	@Override
	public Map<Integer, String> loadStates(Integer countryId) {
		List<StateMasterEntity> stateMaster = stateRepo.findByCountryId(countryId);
		Map<Integer, String> stateMap = new HashMap<>();
		stateMaster.forEach(states -> {
			stateMap.put(states.getStateId(), states.getStateName());

		});
		return stateMap;
	}

	@Override
	public Map<Integer, String> loadCities(Integer stateId) {
		List<CityMasterEntity> cities = CityRepo.findByStateId(stateId);
		Map<Integer, String> citiesMap = new HashMap<>();
		cities.forEach(city -> {
			citiesMap.put(city.getCityId(), city.getCityName());

		});
		return citiesMap;
	}

	@Override
	public String saveUser(UserRegForm userForm) {
		userForm.setUserPassword(generateRandomPwd(6));
		UserAccountEntity accountEntity = new UserAccountEntity();
		accountEntity.setAccStatus("LOCKED");
		BeanUtils.copyProperties(userForm, accountEntity);
		UserAccRepo.save(accountEntity);

		return "SUCCESS";
	}

	@Override
	public String unlockAcc(UnlockAccForm unlockAccForm) {
		UserAccountEntity accountEntity = UserAccRepo.findByEmailAndPassWord(unlockAccForm.getEmail(),
				unlockAccForm.getTempPwd());
		if (accountEntity == null) {
			return "Invalid Tempory PWD";
		}
		accountEntity.setUserPwd(unlockAccForm.getNewPwd());
		accountEntity.setAccStatus("UNLOCKED");
		UserAccRepo.save(accountEntity);
		return "Account Locked SUCCESSFull!!  ";
	}

	@Override
	public String forgotPwd(String emailId) {

		UserAccountEntity accountEntity = UserAccRepo.findByEmail(emailId);
		if (accountEntity == null) {
			return "Invalid Email";
			// SEND TO THE EMAILE
		}
		return "PASSWORD SENT TO YOUR REGISTERD EMAIL ";
	}

	private static String generateRandomPwd(int n) {
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
	
	
	private String readUnlockAccEmailBody(UserRegForm user) {
		String body="";
		StringBuffer buffer=new StringBuffer()
	   Path filePath = Paths.get("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		try {
			
		} catch (Stream<String> stream = Files.lines(filePath)) {
			stream.f
			// TODO: handle exception
		}
		return body;
		
	}
}
