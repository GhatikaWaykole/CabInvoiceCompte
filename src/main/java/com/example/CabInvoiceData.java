package com.example;

import java.util.Objects;

public class CabInvoiceData {
    private final int NUMBER_OF_Ride;
    private final double TOTAL_FARE;
    private final double AVG_FARE;

    public CabInvoiceData(int NO_OF_Ride, double TOTAL_FARE) {
        this.NUMBER_OF_Ride = NO_OF_Ride;
        this.TOTAL_FARE = TOTAL_FARE;
        this.AVG_FARE = this.TOTAL_FARE/this.NUMBER_OF_Ride;
    }
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CabInvoiceData that = (CabInvoiceData) o;
        return NUMBER_OF_Ride == that.NUMBER_OF_Ride && Double.compare(that.TOTAL_FARE,TOTAL_FARE) == 0 && Double.compare(that.AVG_FARE,AVG_FARE) == 0;
    }
    @Override
    public int hashCode(){
        return Objects.hash(NUMBER_OF_Ride,TOTAL_FARE,AVG_FARE);
    }
}
