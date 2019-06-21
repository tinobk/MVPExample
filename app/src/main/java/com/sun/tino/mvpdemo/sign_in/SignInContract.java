package com.sun.tino.mvpdemo.sign_in;

public interface SignInContract {
    interface View{
        void signInSuccess();
        void signInFailure();
        void signInInputError();
    }

    interface Presenter{
        void handleSignIn(String username, String password);
    }
}
