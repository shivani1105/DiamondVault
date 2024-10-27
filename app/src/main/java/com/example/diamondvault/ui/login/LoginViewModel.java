package com.example.diamondvault.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.example.diamondvault.data.ILoginResponse;
import com.example.diamondvault.data.LoginRepository;
import com.example.diamondvault.data.model.Admin;
import com.example.diamondvault.R;
import com.example.diamondvault.data.model.LoginResponse;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        // can be launched in a separate asynchronous job
//        loginRepository.login(username, password, new ILoginResponse<LoginResponse>() {
//            @Override
//            public void onSuccess(Admin admin) {
//                // Authentication succeeded, update LiveData
//                loginResult.postValue(new LoginResult(new AdminView(admin.getName())));
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                // Authentication failed, update LiveData with error message
//                loginResult.postValue(new LoginResult(R.string.login_failed));
//            }
//        });
        loginRepository.login(username, password, new ILoginResponse() {
            @Override
            public void onResponse(LoginResponse loginResponse) {
                loginResult.postValue(new LoginResult(new AdminView(loginResponse.getAdmin().getName())));
            }

            @Override
            public void onFailure(Throwable t) {
                loginResult.postValue(new LoginResult(R.string.login_failed));
            }
        });
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}