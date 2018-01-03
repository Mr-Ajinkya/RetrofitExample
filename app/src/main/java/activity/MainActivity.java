package activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ajinkya.techno.retrofitlogin.R;

import domain.Credential;
import domain.LoginResponse;
import network.ApiService;
import network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_MSG = "msg";
    public static final String KEY_STATUS = "status";
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLogin().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                postLogin();
            }
        });

        getRegisterButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),StudentRegistration.class);
                startActivity(intent);
            }
        });

    }

    private Credential getData(){
        Credential credential = new Credential();
        credential.setAdharNumber(getUsername().getText().toString());
        credential.setMobileNumber(getPassword().getText().toString());
        return credential;
    }

    private void postLogin() {
        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);


        Call<LoginResponse>call = apiService.loginUser(getData());
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.i("@ajinkya","response=>> " + response.body().getMsg());

                LoginResponse loginResponse = response.body();
                String msg = loginResponse.getMsg();
                String status = loginResponse.getStatus();

                Log.i("@ajinkya "," msg  " + msg+  "  new  " +status);
                Intent intent = new Intent(getApplicationContext(),LoginData.class);
//                intent.putExtra(KEY_MSG,msg);
//                intent.putExtra(KEY_STATUS,status);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.i("@ajinkya","response fail" +call +  " throwable " +t);
            }
        });


    }


    private EditText getUsername(){
        return findViewById(R.id.edtUsername);
    }

    private EditText getPassword(){
        return findViewById(R.id.edtPassword);
    }

    private Button getLogin(){
        return findViewById(R.id.btnLogin);
    }

    private TextView getRegisterButton(){return  findViewById(R.id.txtRegistration);}

}
