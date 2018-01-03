package domain;

/**
 * Created by lenovo on 1/2/2018.
 */

public class Credential {

    private String adharNumber;
    private String mobileNumber;

    @Override
    public String toString() {
        return "Credential{" +
                "adharNumber='" + adharNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
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
}
