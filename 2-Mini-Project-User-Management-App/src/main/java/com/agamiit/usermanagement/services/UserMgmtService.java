package com.agamiit.usermanagement.services;

import java.util.Map;

import com.agamiit.usermanagement.binding.LoginForm;
import com.agamiit.usermanagement.binding.UnlockAccForm;
import com.agamiit.usermanagement.binding.UserRegForm;

public interface UserMgmtService {
	   // login screen related methods
		public String loginCheck(LoginForm loginForm);

		// Registration screen related methods
		public String emailCheck(String emailId);

		public Map<Integer, String> loadCountries();

		public Map<Integer, String> loadStates(Integer countryId);

		public Map<Integer, String> loadCities(Integer stateId);
		
		public String saveUser(UserRegForm userForm);

		// unlock account screen related methods
		public String unlockAcc(UnlockAccForm unlockAccForm);

		// forgot pwd screen related methods
		public String forgotPwd(String emailId);


}
