package com.knoldus

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{FluentWait, Wait}
import org.openqa.selenium.{Keys, WebDriver}
import org.scalatestplus.testng.TestNGSuite
import org.testng.annotations.Test

class PredictiveDropdown extends TestNGSuite {

  System.setProperty("webdriver.chrome.driver", "/home/knoldus/Downloads/chromedriver_linux64(2)/chromedriver")
  val driver = new ChromeDriver()

  val fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)

  @Test(enabled = true)
  def flipkart_search(): Unit = {

    driver.manage().window().maximize()
    driver.get("https://www.flipkart.com/")
    Thread.sleep(2000)

    // login part
    driver.findElementByCssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div:nth-child(1) > input").sendKeys("sparshbhardwaj10@gmail.com")
    driver.findElementByCssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div:nth-child(2) > input").sendKeys("sparsh10")
    driver.findElementByCssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div._1avdGP > button").click()
    Thread.sleep(2000)


    // search part
    driver.findElementByCssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > div > div > input").clear()
    driver.findElementByCssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > div > div > input").sendKeys("one")
    Thread.sleep(5000)


    //fluentWait.until(ExpectedConditions.visibilityOf(driver.findElementByCssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > ul > li:nth-child(2)")))
    val a = driver.findElementsByTagName("li")

    for (i <- 0 until a.size()) {
      println(a.get(i).getText)

      if (a.get(i).getText.contains("one plus mobile")) {
        a.get(i).click()
      }
      else {
        println(a.get(i).getText)
      }

    }
  }

  @Test
  def on_amazon(): Unit = {

    driver.manage().window().maximize()
    driver.get("https://www.amazon.in/")
    driver.findElementByCssSelector("#twotabsearchtextbox").sendKeys("one")
    Thread.sleep(2000)

    /*val builder = new Actions(driver)
    builder
      .moveToElement(driver.findElementByCssSelector("#twotabsearchtextbox"))
      .click()
      .keyDown(Keys.ARROW_DOWN)
      .keyDown(Keys.ARROW_DOWN)
      .keyDown(Keys.ARROW_DOWN)
      .keyDown(Keys.ARROW_DOWN)
      .click()
      .build()
      .perform()
     */


    val a = driver.findElementByCssSelector("#twotabsearchtextbox")
    a.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)


    Thread.sleep(2000)
    driver.close()


  }
}
