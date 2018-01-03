package network;

import domain.Credential;
import domain.LoginResponse;
import domain.StudentProfile;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by lenovo on 1/2/2018.
 */

public interface ApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

    @POST("student/loginUser/")
    Call<LoginResponse>loginUser(@Body Credential credential);

    @POST("student/saveStudent/")
    Call<StudentProfile>registerStudent(@Body StudentProfile studentProfile);

    @GET("student/getStudentData/{id}/")
    Call<StudentProfile>getRegisterUser(@Path("id") String userId);

}
