import com.example.CabInvoiceCompute;
import com.example.CabRideData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {
    CabInvoiceCompute cabInvoiceCompute;
    @Before
    public void cabInvoiceCompute(){
        cabInvoiceCompute = new CabInvoiceCompute();
    }
    /* test method to check the fare return through the method data
     * assertEquals check the actual and expected data
     */
    @Test
    public void GivenDistanceAndTime_ShouldReturnFare(){
        double distance = 2.0;
        int time = 5;
        double result = cabInvoiceCompute.calculateCabFare(distance,time);
        Assert.assertEquals(25,result,0.0);
    }
    /* test method check the minfare data
     assetEqual method compute the actual and the method data
     */
    @Test
    public void GivenDistanceAndTime_ShouldReturnMinFare(){
        double distance = 0.1;
        int time = 1;
        double result = cabInvoiceCompute.calculateCabFare(distance,time);
        Assert.assertEquals(5.0,result,0.0);
    }
    /* test method to check multi cab ride data
     * data of total ride compute
     */
    @Test
    public void GivenMultiCabRideData_ShouldReturnFare(){
        CabRideData[] cab ={
                new CabRideData(2.0,5),
                new CabRideData(0.1,1)
        };
        double result = cabInvoiceCompute.calculateCabFare(cab);

        Assert.assertEquals(30.0, result,0.0);
    }
}