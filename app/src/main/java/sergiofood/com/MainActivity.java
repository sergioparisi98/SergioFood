package sergiofood.com;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginBtn, registerBtn;
    EditText emailEt, passwordEt;
    Boolean validEmail = false, validPsw = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);
        emailEt = findViewById(R.id.email_et);
        passwordEt = findViewById(R.id.password_et);

/*        if(hasInvitationCode())
            registerBtn.setVisibility(View.GONE);*/

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        passwordEt.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length()>4){
                    validPsw = true;
                    if(validEmail)
                        loginBtn.setEnabled(true);
                }else{
                    validPsw = false;
                    loginBtn.setEnabled(false);
                }
            }
        });

        emailEt.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(controlEmail(emailEt)){
                    validEmail = true;
                    if(validPsw)
                        loginBtn.setEnabled(true);
                } else{
                    validEmail = false;
                    loginBtn.setEnabled(false);
                }



            }
        });

    }


    @Override
    public void onClick(View v) {
        //TODO do something
        if(v.getId() == R.id.login_btn){
            //TODO do login
            startActivity(new Intent(this, RegisterActivity.class));
        }else if(v.getId() == R.id.register_btn){

            startActivity(new Intent(this, RegisterActivity.class));
        }
    }

    private void showToast(){
        Toast.makeText(this, "Testo", Toast.LENGTH_LONG).show();
    }

    private boolean hasInvitationCode(){
        return true;
    }

    private boolean controlEmail(EditText eT){
        String emailPatern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
        String email = eT.getText().toString().trim();
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }
}

