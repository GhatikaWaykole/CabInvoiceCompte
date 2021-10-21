package com.example;

import java.util.HashMap;
import java.util.Map;

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
    /* method to check the multiple ride data
     * @param ride data array return fare data
     */
    public double calculateCabFare(CabRideData[] rideData){
        double fare = 0.0;
        for (CabRideData  cabRideData: rideData){
            fare += calculateCabFare(cabRideData.getDistance(), cabRideData.getTime());
        }
        return fare;
    }
    public CabInvoiceData CalculateCabFare(CabRideData[] cabRideData){
        double fare =0.0;
        for (CabRideData cabRideData1 : cabRideData){
            fare += calculateCabFare(cabRideData1.getDistance(),cabRideData1.getTime());
        }
        return new CabInvoiceData(cabRideData.length,fare);
    }
    public CabInvoiceData CabSummaryCalculate(int userId){
        Map<Integer,CabRideData[]> map = new HashMap<>();
        CabRideData[] cabRideData = {
                new CabRideData(2.0,5),
                new CabRideData(0.1,1)
        };
        CabRideData[] cabRideData1 = {
                new CabRideData(2.0,5),
                new CabRideData(0.1,1)
        };
        map.put(3,cabRideData);
        map.put(1,cabRideData1);
        for (Map.Entry<Integer,CabRideData[]> entry : map.entrySet()){
            if(userId == entry.getKey()){
                CabRideData[] data = entry.getValue();
                return CalculateCabFare(data);
            }
        }
        return null;
    }
}