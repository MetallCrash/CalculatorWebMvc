package by.tms.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Operation {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private double num1;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[\\+,\\-,\\*,\\/]", message = "Next action only can be +,-,*,/.")
    private String action;
    private double num2;
    private double result;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
