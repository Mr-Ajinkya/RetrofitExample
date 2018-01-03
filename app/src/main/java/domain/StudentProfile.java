package domain;

/**
 * Created by lenovo on 1/3/2018.
 */

public class StudentProfile {

    private  String userId;
    private String studentName;
    private String adharNumber;
    private String mobileNumber;
    private String birthDate;
    private String standard;
    private String division;
    private String school;
    private String gender;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAdharNumber() {
        return adharNumber;
    }

    public void setAdharNumber(String adharNumber) {
        this.adharNumber = adharNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentProfile{" +
                "userId='" + userId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", adharNumber='" + adharNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", standard='" + standard + '\'' +
                ", division='" + division + '\'' +
                ", school='" + school + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
