package com.example.diamondvault.data;

import com.example.diamondvault.data.model.Admin;
import com.example.diamondvault.data.model.LoginResponse;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository {

    private static volatile LoginRepository instance;

    private LoginDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private Admin user = null;

    // private constructor : singleton access
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }

    private void setAdmin(Admin user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public void login(String username, String password, final ILoginResponse callback) {
//        dataSource.login(username, password,callback) {
//            @Override
//            public void onSuccess(Admin admin) {
//                setAdmin(admin);
//                callback.onSuccess(admin);
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                callback.onError(throwable);
//            }
//        });
        dataSource.login(username, password, new ILoginResponse() {
            @Override
            public void onResponse(LoginResponse loginResponse) {
                callback.onResponse(loginResponse);
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}