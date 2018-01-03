package activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ajinkya.techno.retrofitlogin.R;

import Prefs.Prefs;
import domain.StudentProfile;
import network.ApiService;
import network.RetrofitInstance;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        getRegistration().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postRegistration();
            }
        });
    }

    private StudentProfile studentProfile(){
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setStudentName(getStudName().getText().toString());
        studentProfile.setAdharNumber(getAadharnumber().getText().toString());
        studentProfile.setMobileNumber(getMobilenumber().getText().toString());
        studentProfile.setBirthDate(getBirthdate().getText().toString());
        studentProfile.setStandard(getStandard().getText().toString());
        studentProfile.setDivision(getDivision().getText().toString());
        studentProfile.setSchool(getSchoolName().getText().toString());
        studentProfile.setGender(getStudGender().getText().toString());
        return studentProfile;
    }

    private void postRegistration() {

        ApiService apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);

        retrofit2.Call<StudentProfile>call = apiService.registerStudent(studentProfile());
        call.enqueue(new Callback<StudentProfile>() {
            @Override
            public void onResponse(retrofit2.Call<StudentProfile> call, Response<StudentProfile> response) {

                StudentProfile studentProfile = response.body();
                String userId = studentProfile.getUserId();
                Log.i("@ajinkya","User id=>" +  userId);
                Prefs.saveUserId(getApplicationContext(),userId);
                Log.i("@ajinkya","Save user id=> " + Prefs.getUserId(getApplicationContext()));
            }

            @Override
            public void onFailure(retrofit2.Call<StudentProfile> call, Throwable t) {

            }
        });



    }

    private Button getRegistration(){
        return findViewById(R.id.btnRegister);
    }

    private EditText getStudName(){
        return findViewById(R.id.edtStudentName);
    }
    private EditText getAadharnumber(){
        return findViewById(R.id.edtAadharNumber);
    }
    private EditText getMobilenumber(){
        return findViewById(R.id.edtMobileNumber);
    }
    private EditText getBirthdate(){
        return findViewById(R.id.edtDob);
    }
    private EditText getStandard(){
        return findViewById(R.id.edtStandard);
    }
    private EditText getDivision(){
        return findViewById(R.id.edtDivision);
    }
    private EditText getSchoolName(){
        return findViewById(R.id.edtSchool);
    }
    private EditText getStudGender(){
        return findViewById(R.id.edtGender);
    }


}
