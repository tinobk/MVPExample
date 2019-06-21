package com.sun.tino.mvpdemo.sign_in;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sun.tino.mvpdemo.R;
import com.sun.tino.mvpdemo.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements SignInContract.View {

    private EditText mTextUsername, mTextPassword;
    private SignInPresenter mSignInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mTextUsername = findViewById(R.id.text_enter_username);
        mTextPassword = findViewById(R.id.text_enter_password);
        mSignInPresenter = new SignInPresenter(this);

    }

    @Override
    public void signInSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, getResources().getString(R.string.signInSuccess), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signInInputError() {
        Toast.makeText(this, getResources().getString(R.string.signInInputError), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signInFailure() {
        Toast.makeText(this, getResources().getString(R.string.signInFailure), Toast.LENGTH_SHORT).show();
    }

    public void signIn(View view) {
        String username = mTextUsername.getText().toString();
        String password = mTextPassword.getText().toString();
        mSignInPresenter.handleSignIn(username, password);
    }
}
