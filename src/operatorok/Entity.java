package operatorok;

public class Entity {

    private Integer firstOperator;
    private String operatorSignal;
    private Integer secondOperator;

    public Entity(Integer firstOperator, String operatorSignal, Integer secondOperator) {
        this.firstOperator = firstOperator;
        this.operatorSignal = operatorSignal;
        this.secondOperator = secondOperator;
    }

    public Integer getFirstOperator() {
        return firstOperator;
    }

    public String getOperatorSignal() {
        return operatorSignal;
    }

    public Integer getSecondOperator() {
        return secondOperator;
    }
}
