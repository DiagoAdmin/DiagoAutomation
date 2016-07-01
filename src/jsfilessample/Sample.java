package jsfilessample;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {
public static WebDriver driver;
public static void main(String[] args) {
    driver = new FirefoxDriver(); // This opens a window    
    String url = "https://10.200.0.61";


    /*driver.findElement(By.id("username")).sendKeys("yashwanth.m");
    driver.findElement(By.name("j_password")).sendKeys("yashwanth@123");*/

    JavascriptExecutor jse = (JavascriptExecutor) driver;       
    if (jse instanceof WebDriver) {
        //Launching the browser application
        jse.executeScript("window.location = \'"+url+"\'");
jse.executeScript("document.getElementById('username').value = \"yash\";");
//Tag having name then
driver.findElement(By.xpath(".//input[@name='j_password']")).sendKeys("admin");


//Opend Site and click on some links. then you can apply go(-1)--> back  forword(-1)--> front.
//Refresheing the web-site. driver.navigate().refresh();            
jse.executeScript("window.history.go(0)");
        jse.executeScript("window.history.go(-2)");
        jse.executeScript("window.history.forward(-2)");

        String title = (String)jse.executeScript("return document.title");
        System.out.println(" Title Of site : "+title);

        String domain = (String)jse.executeScript("return document.domain");
        System.out.println("Web Site Domain-Name : "+domain);

        // To get all NodeList[1052] document.querySelectorAll('*');  or document.all
        jse.executeAsyncScript("document.getElementsByTagName('*')");

        String error=(String) jse.executeScript("return window.jsErrors");
        System.out.println("Windowerrors  :   "+error);



        System.out.println("To Find the input tag position from top"); 
        ArrayList<?> al =  (ArrayList<?>) jse.executeScript(
                "var source = [];"+
                "var inputs = document.getElementsByTagName('input');"+
                "for(var i = 0; i < inputs.length; i++) { " +
                   "   source[i] = inputs[i].offsetParent.offsetTop" +      //"    inputs[i].type = 'radio';"
                "}"+
                "return source"                 
                );//inputs[i].offsetParent.offsetTop     inputs[i].type

        System.out.println("next");
        System.out.println("array : "+al);

        // (CTRL + a) to access keyboard keys. org.openqa.selenium.Keys 
        Keys k = null;
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(selectAll);

        // Search for text in Site. Gets all ViewSource content and checks their.
        if (driver.getPageSource().contains("login")) {
            System.out.println("Text present in Web Site");
        }

    Long clent_height = (Long) jse.executeScript("return document.body.clientHeight");
    System.out.println("Client Body Height : "+clent_height);

    // using selenium we con only execute script but not JS-functions.

}
driver.quit(); // to close browser
}