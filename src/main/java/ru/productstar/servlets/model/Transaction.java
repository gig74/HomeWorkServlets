package ru.productstar.servlets.model;

public class Transaction {
    private final String name;
    private final int sum;
    private final FinancialEventType financialEventType;

    public Transaction(String name, int sum, FinancialEventType financialEventType) {
        this.name = name;
        this.sum = sum;
        this.financialEventType = financialEventType;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public FinancialEventType getFinancialEventType() {
        return financialEventType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "name='" + name + '\'' +
                ", sum=" + sum + '\'' +
                ", financialEventType=" + financialEventType +
                '}';
    }
}
