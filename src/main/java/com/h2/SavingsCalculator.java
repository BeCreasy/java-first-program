package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {

    public static void main(String[] args) {
    String[] creditsAsString=args[0].split(",");
    String[] debitsAsString=args[1].split(",");

    float[] credits = new float[creditsAsString.length];
    float[] debits = new float[debitsAsString.length];

        for (int i = 0; i <creditsAsString.length ; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }
        for (int j = 0; j <debitsAsString.length ; j++) {
            debits[j] = Float.parseFloat(debitsAsString[j]);
        }

    SavingsCalculator calculator = new SavingsCalculator(credits,debits);
    float netSaving = calculator.calculate();

    System.out.println("Net Savings = "+ netSaving + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }

    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] creadits, float[] debits) {
        this.credits = creadits;
        this.debits = debits;
    }

    private float sumOfCredits(){
        float sum = 0.0f;
        for (float i: this.credits
             ) { sum += i;
        }
        return sum;
    }

    private float sumOfDebits(){
        float sum = 0.0f;
        for (float i: this.debits
             ) { sum += i;

        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(),date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();

        return remainingDays;
    }

    public float calculate() {
        return (sumOfCredits()-sumOfDebits());
    }
}

