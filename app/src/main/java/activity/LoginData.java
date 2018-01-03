package activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ajinkya.techno.retrofitlogin.R;

import Prefs.Prefs;
import domain.StudentProfile;
import network.ApiService;
import network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static activity.MainActivity.KEY_MSG;
import static activity.MainActivity.KEY_STATUS;

public class LoginData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_data);

       /* Intent intent = getIntent();
        String userMsg = intent.getStringExtra(KEY_MSG);
        Log.i("@ajinkya","user msg=> " + userMsg);
        String userStatus = intent.getStringExtra(KEY_STATUS);
        Log.i("@ajinkya","user status=> " + userStatus);
        TextView txtMsg = findViewById(R.id.txtStudNme);
        txtMsg.setText(userMsg);*/
        //TextView txtStatus = findViewById(R.id.txtStatus);
        //txtStatus.setText(userStatus);

        ApiService apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        String userId = Prefs.getUserId(getApplicationContext());
        Call<StudentProfile>call = apiService.getRegisterUser(userId);

        Log.i("@ajinkya","response url=> " + call.request().url());

        call.enqueue(new Callback<StudentProfile>() {
            @Override
            public void onResponse(Call<StudentProfile> call, Response<StudentProfile> response) {
                Log.i("@ajinkya","user response=> " + response.body());
                StudentProfile studentProfile = response.body();

                getUserResponse(studentProfile);
            }

            @Override
            public void onFailure(Call<StudentProfile> call, Throwable t) {

            }
        });


    }

    private void getUserResponse(StudentProfile studentProfile) {
        if (studentProfile != null){
            getStudentName().setText(studentProfile.getStudentName());
            getAdharNumber().setText(studentProfile.getAdharNumber());
            getMobileNumber().setText(studentProfile.getMobileNumber());
            getBirthDate().setText(studentProfile.getBirthDate());
            getStandard().setText(studentProfile.getStandard());
            getDivision().setText(studentProfile.getDivision());
            getSchoolName().setText(studentProfile.getSchool());
            getGender().setText(studentProfile.getGender());
        }
    }

    private TextView getStudentName(){
        return findViewById(R.id.txtStudNme);
    }
    private TextView getAdharNumber(){
        return findViewById(R.id.txtAdharNumber);
    }
    private TextView getMobileNumber(){
        return findViewById(R.id.txtMobileNumber);
    }
    private TextView getBirthDate(){
        return findViewById(R.id.txtBirthDate);
    }
    private TextView getStandard(){
        return findViewById(R.id.txtStandard);
    }
    private TextView getDivision(){
        return findViewById(R.id.txtDivision);
    }
    private TextView getSchoolName(){
        return findViewById(R.id.txtSchoolName);
    }
    private TextView getGender(){
        return findViewById(R.id.txtGender);
    }
}
