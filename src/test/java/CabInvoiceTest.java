import com.example.CabInvoiceCompute;
import com.example.CabInvoiceData;
import com.example.CabRideData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {
    CabInvoiceCompute cabinvoiceCompute;
    @Before
    public void cabInvoiceCompute(){
        cabinvoiceCompute = new CabInvoiceCompute();
    }
    /* test method to check the fare return through the method data
     * assertEquals check the actual and expected data
     */
    @Test
    public void GivenDistanceAndTime_ShouldReturnFare(){
        double distance = 2.0;
        int time = 5;
        double result = cabinvoiceCompute.calculateCabFare(distance,time);
        Assert.assertEquals(25,result,0.0);
    }
    /* test method check the minfare data
     assetEqual method compute the actual and the method data
     */
    @Test
    public void GivenDistanceAndTime_ShouldReturnMinFare(){
        double distance = 0.1;
        int time = 1;
        double result = cabinvoiceCompute.calculateCabFare(distance,time);
        Assert.assertEquals(5.0,result,0.0);
    }
    /* test method to check multi cab ride data
     * data of total ride compute
     */
    @Test
    public void GivenMultiCabRideData_ShouldReturnFare(){
        CabRideData[] cab = {
                new CabRideData(2.0,5),
                new CabRideData(5.0,10),
                new CabRideData(0.1,1),
                new CabRideData(20,60)
        };
        double fare = cabinvoiceCompute.calculateCabFare(cab);
        Assert.assertEquals(350,fare,0.0);
    }
    @Test
    public void GivenMultiRideData_ShouldReturnInvoiceComputeData(){
        CabRideData[] cabRideData = {
                new CabRideData(2.0,5),
                new CabRideData(0.1,1)
        };
        CabInvoiceData cabFareData = cabinvoiceCompute.CalculateCabFare(cabRideData);
        CabInvoiceData cabInvoiceData = new CabInvoiceData(2,30.0);
        Assert.assertEquals(cabFareData,cabInvoiceData);
    }
    @Test
    public void GivenUserIdData_ShouldReturnInvoiceTotalData(){
        CabInvoiceData cabInvoiceData = cabinvoiceCompute.CabSummaryCalculate(3);
        CabInvoiceData cabInvoiceData1 = new CabInvoiceData(2,30);
        Assert.assertEquals(cabInvoiceData1.getInvoiceData(),cabInvoiceData.getInvoiceData());
    }
}