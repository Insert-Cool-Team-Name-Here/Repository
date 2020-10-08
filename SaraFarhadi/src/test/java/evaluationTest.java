import com.example.sara.evaluate.evaluate;
import org.junit.*;

public class evaluationTest {
    private evaluate eval;
    @Before
    public void setup(){
        System.out.println("before testing ...");
        eval = new evaluate();
    }
    @After
    public void cleanup(){
        System.out.println("Finishing and cleaning up the test ...");
    }
    @Test
    public void evaluateTest1(){
        boolean temp;
        temp = eval.evaluation(10,5);
        Assert.assertEquals(true, temp);
    }
    @Test
    public void evaluateTest2(){
        boolean temp;
        temp = eval.evaluation(50,20);
        Assert.assertEquals(true, temp);
    }
    @Test
    public void evaluateTest3(){
        boolean temp;
        temp = eval.evaluation(100,70);
        Assert.assertEquals(true, temp);
    }
}
