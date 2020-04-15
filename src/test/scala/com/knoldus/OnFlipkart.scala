package com.knoldus

import org.openqa.selenium.chrome.ChromeDriver
import org.scalatestplus.testng.TestNGSuite
import org.testng.annotations.Test

class OnFlipkart extends TestNGSuite {


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

  @Test
  def flipkart(): Unit = {


    driver.manage().window().maximize()
    driver.get("https://www.flipkart.com/")
    val mainWindow = driver.getWindowHandle

    Thread.sleep(2000)
    driver.findElementByCssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div:nth-child(1) > input").sendKeys("sparshbhardwaj10@gmail.com")
    driver.findElementByCssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div:nth-child(2) > input").sendKeys("sparsh10")
    driver.findElementByCssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div._1avdGP > button").click()
    Thread.sleep(5000)
    driver.findElementByCssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > div > div > input").sendKeys("masks")
    driver.findElementByCssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > div > button").click()

    Thread.sleep(10000)
    driver.findElementByCssSelector("#container > div > div.t-0M7P._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1) > div > a._2cLu-l").click()
    windowSwitch()

    driver.findElementByCssSelector("#pincodeInputId").sendKeys("249201")
    Thread.sleep(1000)
    driver.findElementByCssSelector("#container > div > div.t-0M7P._3GgMx1._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div._1HmYoV._35HD7C.col-5-12._3KsTU0 > div:nth-child(2) > div > ul > li:nth-child(1) > button").click()
    Thread.sleep(1000)
    driver.close()
    driver.switchTo().window(mainWindow)

    driver.findElementByCssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div:nth-child(5) > div > div > a").click()

    Thread.sleep(2000)

    val b = driver.findElementsByXPath("//span[@class='pMSy0p XU9vZa']")
    for (i <- 0 until b.size()) {
      println(b.get(i).getText())
    }
    val a = driver.findElementByCssSelector("#container > div > div._5wt5ag > div > div > div.ooJZfD._2oZ8XT.col-4-12._2GJ0F- > div._3gijNv.col-12-12 > div > div > div > div._3xFQAD > div > span > div > div > span").getText
    println(a)
  }


}

