package com.example.diamondvault.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class AdminView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    AdminView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}