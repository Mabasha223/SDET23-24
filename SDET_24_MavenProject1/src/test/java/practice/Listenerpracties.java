package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass;

@Listeners(com.crm.comcast.genericUtility.Listnersimplementaion.class)
public class Listenerpracties extends Baseclass {
	@Test
	public void sceenshottest() {
		System.out.println("Sceenshot test....");
		Assert.fail();
		
	}

}
