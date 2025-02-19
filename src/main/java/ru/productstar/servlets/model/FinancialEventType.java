package ru.productstar.servlets.model;

public enum FinancialEventType {
    Income("Income"),
    Expense("Expense");
    private String code;

    private FinancialEventType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
