package UserLoginRegistration;

public class Registration implements RegistrationIN {
    String name;
    String email;
    String password;
    Registration(String name,String email,String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
    @Override
    public String getEmail() {
       return this.email;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
