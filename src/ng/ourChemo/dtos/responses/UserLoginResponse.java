package ng.ourChemo.dtos.responses;

public class UserLoginResponse {

    private String message;
    private boolean isLogin;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isLogin() {
        return isLogin;
    }
    public void setIsLogin(boolean isLogin){
        this.isLogin = isLogin;
    }
}
