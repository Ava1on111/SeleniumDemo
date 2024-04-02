/**
 *
 * Name: John Smith (( Update with your name here ))
 * Student ID: s45045012  (( Update with your ID))
 *
 * [OPTIONAL: add any notes or comments here about the code]
 */
package au.edu.rmit.ct;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Update this class name by replacing S3214321 with your student ID
class TryBookingTest_S3762370 {
    WebDriver myDriver;


    @Test
    // @Disabled
    @Order(0)
    @DisplayName("Sanity test only")
     void sanityTest(){
        // When this passes I know I have the webdriver and Junit set up correctly
        String url = "https://www.trybooking.com";
        myDriver.get(url);
//        fail("Put my own sanity checks here.");
        assertEquals("Event Ticketing & Booking Platform | TryBooking Australia", myDriver.getTitle());
    }

    @BeforeEach
    void setUp() {
        SeleniumDriverFactory sdf =new SeleniumDriverFactory ();
        this.myDriver = sdf.getDriver();
    }

    @AfterEach
    void tearDown() {
        //myDriver.close();
        myDriver.quit();
    }

    @Test
    @Order(1)
    @DisplayName("Events near Me")
    void EventsNearMe(){
        String nearURL = "https://www.trybooking.com/book/search?keyword=&location=CARLTON,%203053,%20VIC&date=";
        myDriver.get(nearURL);

        List<WebElement> lweA = myDriver.findElements(By.tagName("a"));
        int count = 0;
        for (WebElement wea : lweA){
//            System.out.println(wea.getAttribute("href") + ",");
            if(wea.getAttribute("href").toString().contains("https://www.trybooking.com/events/landing/")){
                count++;
            }
        }

        assertTrue(count > 11);
    }

    @Test
    @Order(1)
    @DisplayName("Booking")
    void Booking(){
        //book the event "RMIT Golden Doughnut Award Ceremony"
        String bookURL = "https://www.trybooking.com/events/973619/sessions/3483250/sections/1778244/tickets";
        myDriver.get(bookURL);

        WebElement we = myDriver.findElement(By.xpath("//input[@type='number']"));
        we.sendKeys(Keys.BACK_SPACE);
        we.sendKeys("1");
        we = myDriver.findElement(By.xpath("//a[text()='Next']"));
        we.click();

        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        //input personal information
        we = myDriver.findElement(By.xpath("//input[@title='Student ID is required.']"));
        we.sendKeys("s3762370");
        we = myDriver.findElement(By.xpath("//div[@class='date format-au']/div[1]"));
        we.click();
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        we = myDriver.findElement(By.xpath("//div[@class='date format-au']/div[1]/div[2]/div[2]/div[26]"));
        we.click();
        we = myDriver.findElement(By.xpath("//div[@class='date format-au']/div[2]"));
        we.click();
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        we = myDriver.findElement(By.xpath("//div[@class='date format-au']/div[2]/div[2]/div[2]/div[12]"));
        we.click();
        we = myDriver.findElement(By.xpath("//div[@class='date format-au']/div[3]"));
        we.click();
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        we = myDriver.findElement(By.xpath("//div[@class='date format-au']/div[3]/div[2]/div[2]/div[13]"));
        we.click();
        we = myDriver.findElement(By.xpath("//*[@id='bookingDataForm']/div/div/div[3]"));
        we.click();
        we = myDriver.findElement(By.xpath("//*[@id='bookingDataForm']/div/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[3]"));
        we.click();
        we = myDriver.findElement(By.xpath("//a[@id='data-entry-next-button']"));
        we.click();

        try{
            Thread.sleep(5000);
            }catch (Exception e){
             e.printStackTrace();
            }

        // Get to the checkout page and fill the booking details form then click PURCHASE
        we = myDriver.findElement(By.xpath("//input[@id='txtFirstName']"));
        we.sendKeys("Chong");
        we = myDriver.findElement(By.xpath("//input[@id='txtLastName']"));
        we.sendKeys("Gao");
        we = myDriver.findElement(By.xpath("//select[@id='drpCountry']"));
        we = myDriver.findElement(By.xpath("//input[@id='txtEmailAddress']"));
        we.sendKeys("s3762370@student.rmit.edu.au");
        we = myDriver.findElement(By.xpath("//input[@id='txtConfirmEmailAddress']"));
        we.sendKeys("s3762370@student.rmit.edu.au");
        try{
            Thread.sleep(8000);
        }catch (Exception e){
            e.printStackTrace();
        }
        we = myDriver.findElement(By.xpath("//button[text()='Purchase']"));
        we.click();
        try{
            Thread.sleep(9000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}