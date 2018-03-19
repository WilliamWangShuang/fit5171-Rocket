package rockets.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LaunchServiceProviderUnitTest {
    LaunchServiceProvider lsProvider;

    @Before
    public void setUp() throws Exception {

        lsProvider = new LaunchServiceProvider("CCP", 1990, "China");
    }

    @Test(expected = NullPointerException.class)
    public void testNameNull(){
        lsProvider = new LaunchServiceProvider(null, 1990, "China");
    }

}