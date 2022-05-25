import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup {
    @Test
    public void userReg(){
        driver.get("http://automationpractice.com/");
        LoginPage loginPage=new LoginPage(driver);
        int id= (int)(Math.random()*(1000-1)+1);
        String email="user"+id+"@test.com";
        String password="P@ssword123";
        loginPage.doReg(email,password);
        Assert.assertTrue(loginPage.btnLogout.isDisplayed(), String.valueOf(true));
    }
    public void userLogin() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        driver.get("http://automationpractice.com/");
        String name= loginPage.doLogin();
        System.out.println(name);
        Assert.assertEquals(name,"Sazzad Hossain");
        Assert.assertTrue(name.contains("Sazzad Hossain"), String.valueOf(true));
        Assert.assertTrue(loginPage.btnLogout.isDisplayed(), String.valueOf(true));

        Thread.sleep(5000);
        loginPage.btnLogout.click();
    }

}
