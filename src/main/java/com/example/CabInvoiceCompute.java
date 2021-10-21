package com.example;
/* purpose check the cab invoice fare program
 * use the TDD approach and check the test for the data
 */
public class CabInvoiceCompute {
    public static final double Cost_Per_KILOMETER =10;
    public static final int COST_PER_MIN = 1;
    public static final double MIN_FARE = 5;
/* method to check the fare and distance < 1 then use the minfare data
 * @param disatnce and time return fare compute
 */
    public double calculateCabFare(double distance, int time){
        if(distance < 1){
            return MIN_FARE;
        }
        double totalFare = distance * Cost_Per_KILOMETER + time * COST_PER_MIN;
        return totalFare;
    }
}
