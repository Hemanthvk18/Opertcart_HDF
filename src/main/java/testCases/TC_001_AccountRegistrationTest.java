package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"regression" ,"master"})
	public void verify_account_registration()
	{
		logger.info("*** test start***");
		
		try {
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("myaccount ok");
		hp.clickRegister();
		logger.info("Register ok");
		
		logger.info("entering details ");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);		
		regpage.setFirstName(randomeString().toUpperCase());
		logger.info("fname ok");
		regpage.setLastName(randomeString().toUpperCase());
		logger.info("lname ok");
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		logger.info("email ok");
		regpage.setTelephone(randomeNumber());
		logger.info("phonenumber ok");
		
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		logger.info("password ok");
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
			
		String confmsg=regpage.getConfirmationMsg();
		logger.error("validating message");
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("test passed...");
			Assert.assertTrue(true);
		}
		else 
		{
			logger.info("test failed...");
			Assert.fail();
		}
		
		
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		
		logger.info("*** test end***");
		
	}
	
	
	
	
}








