package by.tms.entity;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class User {

    @NotEmpty
    @NotBlank
    private String login;

    @NotEmpty
    @NotBlank
    private String password;

    private List<Operation> operationList = new ArrayList<>();

    public User() {
    }

    public User(String login, String password, List<Operation> operationList) {
        this.login = login;
        this.password = password;
        this.operationList = operationList;
    }

    public void saveOperation(Operation operation) {
        operationList.add(operation);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }
}
