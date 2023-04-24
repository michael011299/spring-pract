package com.example.demo.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumDemo {
	
	private WebDriver driver;
	
	@BeforeEach
	void init() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(options);
		this.driver.manage().window().maximize();
	}
	
	@Test
	void turtleTest() {
		this.driver.get("https://www.bbc.co.uk/search");
	  WebElement search = this.driver.findElement(By.cssSelector("#search-input"));
	  search.sendKeys("turtle");
	  search.sendKeys(Keys.ENTER);
	  
	  WebElement result = this.driver.findElement(By.cssSelector("#main-content > div.ssrcss-1v7bxtk-StyledContainer.enjd40x0 > div > div > ul > li:nth-child(1) > div > div > div.ssrcss-tq7xfh-PromoContent.e1f5wbog8 > div.ssrcss-1f3bvyz-Stack.e1y4nx260 > a > span > p"));
	  Assertions.assertEquals("The Turtle Dove Pilgrimage", result.getText());
	}
	
	@Test
	void penguinTest() throws InterruptedException {
	this.driver.get("https://www.bing.com/search");
	
	Thread.sleep(3000);
	WebElement search = this.driver.findElement(By.cssSelector("#sb_form_q"));
	search.sendKeys("penguin");
	search.sendKeys(Keys.ENTER);
	
	WebElement result = this.driver.findElement(By.cssSelector("#b_results > li.b_algo.b_vtl_deeplinks > div.b_title > h2 > a"));
	Assertions.assertEquals("Penguin Books UK | Official Website", result.getText());
	
	}
	
	
	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}
