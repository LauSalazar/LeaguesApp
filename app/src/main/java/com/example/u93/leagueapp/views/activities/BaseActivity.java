package com.example.u93.leagueapp.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.u93.leagueapp.helper.ValidateInternet;
import com.example.u93.leagueapp.presenters.BasePresenter;
import com.example.u93.leagueapp.views.interfaces.IBaseView;

public class BaseActivity <T extends BasePresenter> extends AppCompatActivity implements IBaseView {
        private T presenter;
        private ValidateInternet validateInternet;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            validateInternet = new ValidateInternet(this);
        }

        public ValidateInternet getValidateInternet() {
            return validateInternet;
        }

        public T getPresenter() {
            return presenter;
        }

        public void setPresenter(T presenter) {
            this.presenter = presenter;
        }

        @Override
        public void showResultBase(int i) {
            Toast.makeText(this,"Resultado "+i, Toast.LENGTH_SHORT).show();
        }
}
