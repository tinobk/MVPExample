package com.sun.tino.mvpdemo.sign_in;

public class SignInPresenter implements SignInContract.Presenter {

    private SignInContract.View mView;
    SignInPresenter(SignInContract.View view) {
        mView = view;
    }

    @Override
    public void handleSignIn(String username, String password) {
        if(username.length() == 0 || password.length() == 0) mView.signInInputError();
        else {
            String usernameDefault = "tinobk";
            String passwordDefault = "123123aA";
            if(username.equals(usernameDefault) && password.equals(passwordDefault)) mView.signInSuccess();
            else mView.signInFailure();
        }
    }
}
