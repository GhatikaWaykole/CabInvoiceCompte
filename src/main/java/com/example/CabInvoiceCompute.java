package com.example;

import java.util.HashMap;
import java.util.Map;

/* purpose check the cab invoice fare program
 * use the TDD approach and check the test for the data
 */
public class CabInvoiceCompute {
    public static final double Cost_Per_KILOMETER = 10;
    public static final int COST_PER_MIN = 1;
    public static final double MIN_FARE = 5;
    public static final double MIN_COST_PER_KILOMETER_NORMAL = 10;
    public static final int COST_PER_TIME_NORMAL = 1;
    public static final double MIN_FARE_NORMAL = 5;
    public static final double MIN_COST_PER_KILOMETER_PREMIUM = 15;
    public static final int COST_PER_TIME_PREMIUM = 2;
    public static final double MIN_FARE_PREMIUM = 20;

    /* method to check the fare and distance < 1 then use the minfare data
     * @param disatnce and time return fare compute
     */
    public double calculateCabFare(double distance, int time) {
        if (distance < 1) {
            return MIN_FARE;
        }
        double totalFare = distance * Cost_Per_KILOMETER + time * COST_PER_MIN;
        return totalFare;
    }

    /* method to check the multiple ride data
     * @param ride data array return fare data
     */
    public double calculateCabFare(CabRideData[] rideData) {
        double fare = 0.0;
        for (CabRideData cabRideData : rideData) {
            fare += calculateCabFare(cabRideData.getDistance(), cabRideData.getTime());
        }
        return fare;
    }

    /* method to check cab ride data
     @param CabRidedata array return detail cab data
     */
    public CabInvoiceData CalculateCabFare(CabRideData[] cabRideData) {
        double fare = 0.0;
        for (CabRideData cabRideData1 : cabRideData) {
            fare += calculateCabFare(cabRideData1.getDistance(), cabRideData1.getTime());
        }
        return new CabInvoiceData(cabRideData.length, fare);
    }

    /* method to check the data of the cab compute
     * @param Id return cab data
     */
    public CabInvoiceData CabSummaryCalculate(int userId) {
        Map<Integer, CabRideData[]> map = new HashMap<>();
        CabRideData[] cabRideData = {
                new CabRideData(2.0, 5),
                new CabRideData(0.1, 1)
        };
        CabRideData[] cabRideData1 = {
                new CabRideData(2.0, 5),
                new CabRideData(0.1, 1)
        };
        map.put(3, cabRideData);
        map.put(1, cabRideData1);
        for (Map.Entry<Integer, CabRideData[]> entry : map.entrySet()) {
            if (userId == entry.getKey()) {
                CabRideData[] data = entry.getValue();
                return CalculateCabFare(data);
            }
        }
        return null;
    }

    /* method to check the normal and premium ride fare compute
     * @param distance, time and type return fare data
     */
    public double calculateFareCompute(double distance, int time, String type) {
        if (type.equalsIgnoreCase("Normal")) {
            double fare = distance * MIN_COST_PER_KILOMETER_NORMAL + time * COST_PER_TIME_NORMAL;
            return Math.max(fare, MIN_FARE_NORMAL);
        } else if (type.equalsIgnoreCase("Premium")) {
            double fare = distance * MIN_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
            return Math.max(fare, MIN_FARE_PREMIUM);
        } else
            return 0;
    }

    public double calculateFareCompute(CabRideData[] cabRideData, String type) {
        double fare = 0.0;
        if(type.equalsIgnoreCase("Normal")){
            for(CabRideData cabRideData1 : cabRideData){
                fare += calculateFareCompute(cabRideData1.getDistance(),cabRideData1.getTime(),type);
            }
            return fare;
        }
        else if(type.equalsIgnoreCase("Premium")){
            for(CabRideData cabRideData1 : cabRideData){
                fare += calculateFareCompute(cabRideData1.getDistance(),cabRideData1.getTime(),type);
            }
            return fare;
        }
        else {
            return 0;
        }
}
   public CabInvoiceData calculateFareCabDataCompute(CabRideData[] cabRideData, String type){
        double fare =0.0;
        if(type.equalsIgnoreCase("Normal")){
            for(CabRideData cabRideData1 : cabRideData){
                fare += calculateFareCompute(cabRideData1.getDistance(),cabRideData1.getTime(),type);
            }
        }
        else if(type.equalsIgnoreCase("Premium")){
            for(CabRideData cabRideData1 : cabRideData){
                fare += calculateFareCompute(cabRideData1.getDistance(),cabRideData1.getTime(),type);
            }
        }
        return  new CabInvoiceData(cabRideData.length,fare);
   }

}