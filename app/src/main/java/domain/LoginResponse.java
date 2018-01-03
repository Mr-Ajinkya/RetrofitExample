package domain;

/**
 * Created by lenovo on 1/2/2018.
 */

public class LoginResponse {
   // private Student student;

    private String status;

    private String msg;

  /*  public Student getStudent ()
    {
        return student;
    }

    public void setStudent (Student student)
    {
        this.student = student;
    }*/

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
