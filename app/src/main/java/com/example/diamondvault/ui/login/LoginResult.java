package com.example.diamondvault.ui.login;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private AdminView success;
    @Nullable
    private Integer error;

    LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    LoginResult(@Nullable AdminView success) {
        this.success = success;
    }

    @Nullable
    AdminView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}