package cts.unitTesting;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestSuiteClient extends TestCase {

	//metoda definire test suite
	public static Test suite(){
		TestSuite suite = new TestSuite();
	
		//partial
		suite.addTest(new TestClient("testRezervaCamera"));
		suite.addTest(new TestClient("testZeroDurataCazare"));
		suite.addTest(new TestClient("testNegativDurataCazare"));
		suite.addTest(new TestClient("testInvalidDurataCazare"));
		
		
		//total
		suite.addTestSuite(TestClient.class);
		
		return suite;
	}

}