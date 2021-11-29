package by.tms.service;

import by.tms.dao.OperationDAO;
import by.tms.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private OperationDAO operationDAO;

    public double calculate(Operation operation) {
        final double num1 = operation.getNum1();
        final String action = operation.getAction();
        final double num2 = operation.getNum2();
        double result;
        switch (action) {
            case ("+"):
                result = num1 + num2;
                return result;
            case ("-"):
                result = num1 - num2;
                return result;
            case ("*"):
                result = num1 * num2;
                return result;
            case ("/"):
                result = num1 / num2;
                return result;
            default:
                return 0;
        }
    }

    public void saveOperation(Operation operation) {
        operationDAO.save(operation);
    }
//    public void saveOperation(User user, Operation operation) {
//        user.saveOperation(operation);
//    }

//    public List<Operation> showOperationList(User user) {
//        return user.getOperationList();
//    }
}
