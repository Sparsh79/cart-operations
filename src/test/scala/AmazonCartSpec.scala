import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatestplus.testng.TestNGSuite
import org.testng.annotations.Test

class AmazonCartSpec extends TestNGSuite {

  val email = "sparshbhardwaj10@gmail.com"
  val password = "sparsh10"
  val url = "https://www.amazon.in/"

  System.setProperty("webdriver.chrome.driver", "/home/knoldus/Downloads/chromedriver_linux64(2)/chromedriver")
  val driver = new ChromeDriver()

  def windowSwitch(): Unit = {
    val mainWindow = driver.getWindowHandle
    val allWindows = driver.getWindowHandles
    val i = allWindows.iterator()
    while (i.hasNext) {

      val childWindow: String = i.next()
      if (!mainWindow.equalsIgnoreCase(childWindow)) {
        driver.switchTo().window(childWindow)
      }
    }
  }

  @Test(enabled = false)
  def login(): Unit = {

    driver.manage().window().maximize()
    driver.get(url)
    driver.findElementByCssSelector("#nav-link-accountList").click()
    driver.findElementByCssSelector("#ap_email").sendKeys(email)
    driver.findElementByCssSelector("#continue").click()
    driver.findElementByCssSelector("#ap_password").sendKeys(password)
    driver.findElementByCssSelector("#signInSubmit").click()
  }

  @Test(enabled = false)
  def searchElement(): Unit = {

    val mainWindow = driver.getWindowHandle()

    driver.manage().window().maximize()
    driver.get(url)
    driver.findElementByCssSelector("#twotabsearchtextbox").sendKeys("bean bag")

    driver.findElementByCssSelector("#nav-search > form > div.nav-right > div > input").click()
    driver.findElementByCssSelector("#search > div.s-desktop-width-max.s-desktop-content.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div > span > div > div > div:nth-child(3) > h2 > a > span").click()
    val text = driver.findElementByClassName("a-price-whole").getText()

    windowSwitch()
    driver.findElementByCssSelector("#add-to-cart-button").click()

    Thread.sleep(3000)
    driver.close()
    driver.switchTo().window(mainWindow)
    Thread.sleep(2000)

/*
    driver.findElementByCssSelector("#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.sg-col-20-of-24.s-matching-dir.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div > span > div > div > div:nth-child(3) > h2 > a").click()
    val price = driver.findElementByCssSelector("#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.sg-col-20-of-24.s-matching-dir.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div > span > div > div > div:nth-child(5) > div > div > a > span:nth-child(1) > span:nth-child(2) > span.a-price-whole").getText()

    windowSwitch()
    driver.findElementByCssSelector("#add-to-cart-button").click()
    Thread.sleep(3000)
    driver.close()
    driver.switchTo().window(mainWindow)
    Thread.sleep(2000)


 */
    /*
        driver.findElementByCssSelector("#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.sg-col-20-of-24.s-matching-dir.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > span > div > div > div:nth-child(3) > h2 > a").click()
        windowSwitch()
        driver.findElementByCssSelector("#add-to-cart-button").click()
        Thread.sleep(1000)
        driver.close()
        driver.switchTo().window(mainWindow)
     */
    driver.findElementByCssSelector("#nav-cart").click()

    val a = driver.findElementsByXPath("//span['@class='']")
    for(i <- 0 until a.size()){
    println(a.get(i).getAttribute(""))
    }
    /*
        a.forEach(i => a.size())
        print()
          val size = a.size()
          println(size)
     */


   // println(text + " :price of first bag")
//    println(price + ":price of second bag")
   // println(driver.findElementByCssSelector("#sc-subtotal-amount-activecart > span").getText() + " :total price")
  }
}