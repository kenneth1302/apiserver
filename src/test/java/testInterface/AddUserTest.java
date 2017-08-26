/**
 * Copyright (c) 2017, TP-Link Co.,Ltd.
 * Author:  jiangdanyang <jiangdanyang@tp-link.com.cn>
 * Created: 2017-08-25
 */
package testInterface;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import simulator.ClientSimulator;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AddUserTest {
    //    private static final Logger logger = LoggerFactory.getLogger(TestCaseConfLoader.class);
    //    private static final ClientSimulator clientSimulator = new ClientSimulator();
    //    public static PropertiesConfiguration sysProperties;
    //    @BeforeClass
    //    public void setUp() throws Exception{
    //        String baseDirString = TestLogin.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    //        sysProperties = new PropertiesConfiguration(baseDirString + File.separator + "sys.properties");
    //        String registerPath = sysProperties.getString("config.path.simulator.register");
    //        TestCaseConfLoader confLoader = new TestCaseConfLoader();
    //        JSONObject registerTestCases = confLoader.getTestCases(registerPath);
    //    }
    //    @Test
    //    public void testEmailFormat() throws Exception {
    //        //load register.json
    //    }
    private JSONObject request;
    private JSONObject expected;


    //parameters pass via this constructor
    public AddUserTest(JSONObject request, JSONObject expected) {
        this.request = request;
        this.expected = expected;
    }

    //Declares parameters here
    @Parameters
    public static Collection<Object[]> data() {
        JSONObject testCases = new JSONObject();
        JSONObject testCase1 = new JSONObject();
        JSONObject testCase2 = new JSONObject();
        return Arrays.asList(new Object[][] { { null,null }, { null, null }, { null, null }, { 4, 16 } });
    }

    @Test
    public void test_add() throws IOException, URISyntaxException {
        assertEquals(expected, ClientSimulator.PostAndResponse(request));
    }


}

