package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {

    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public static void main(String[] args) {
    //long loanAmount = Long.parseLong(args[0]);
    long loanAmount = Utilities.getLongValue(args[0]);
    //int termInYears = Integer.parseInt(args[1]);
    int termInYears = Utilities.getIntValue(args[1]);
    //float annualRate = Float.parseFloat(args[2]);
    float annualRate = Utilities.getFloatValue(args[2]);

    MortgageCalculator calculator = new MortgageCalculator(loanAmount,termInYears,annualRate);
    calculator.calculateMonthlyPayment();
    System.out.println(calculator.toString());
    }

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    private int getNumberOfPayments(){
       return this.termInYears*12;
    }

    private float getMonthlyInterestRate(){
       float interestRate = annualRate/100;
       return interestRate/12;

    }

    public void calculateMonthlyPayment(){
        double M = loanAmount*(((getMonthlyInterestRate()*Math.pow(1+getMonthlyInterestRate(), getNumberOfPayments()))))/((Math.pow(1+getMonthlyInterestRate(), getNumberOfPayments())-1));
        this.monthlyPayment = M;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: "+ df.format(monthlyPayment);

    }


}
