package edu.hillel.hw6.testjs;
import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HHCalcTes 
{
	@Test
	public void testPlusMozilla() 
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnplus")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn6")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("108", res);
		driver.quit();
	}
	@Test
	public void testMinusMozilla() 
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnminus")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn6")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("-84", res);
		driver.quit();
	}
	@Test
	public void testUmnogMozilla() 
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnumnog")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("60", res);
		driver.quit();
	}
	@Test
	public void testDevideMozilla() 
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btndevide")).click();
		driver.findElement(By.id("btn3")).click();
		driver.findElement(By.id("btn3")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("3", res);
		driver.quit();
	}
	
	@Test
	public void testPlusChrome() 
	{
		System.setProperty("webdriver.chrome.driver", "d:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnplus")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn6")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("108", res);
		driver.quit();
	}
	@Test
	public void testMinusChrome() 
	{
		System.setProperty("webdriver.chrome.driver", "d:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnminus")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn6")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("-84", res);
		driver.quit();
	}
	@Test
	public void testUmnogChrome() 
	{
		System.setProperty("webdriver.chrome.driver", "d:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnumnog")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("60", res);
		driver.quit();
	}
	@Test
	public void testDevideChrome() 
	{
		System.setProperty("webdriver.chrome.driver", "d:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btndevide")).click();
		driver.findElement(By.id("btn3")).click();
		driver.findElement(By.id("btn3")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("3", res);
		driver.quit();
	}

	@Test
	public void testPlusOpera() 
	{
		System.setProperty("webdriver.opera.driver", "d:/operadriver.exe");
		WebDriver driver = new OperaDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnplus")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn6")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("108", res);
		driver.quit();

	}
	@Test
	public void testMinusOpera() 
	{
		System.setProperty("webdriver.opera.driver", "d:/operadriver.exe");
		WebDriver driver = new OperaDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnminus")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn6")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("-84", res);
		driver.quit();
	}
	@Test
	public void testUmnogOpera() 
	{
		System.setProperty("webdriver.opera.driver", "d:/operadriver.exe");
		WebDriver driver = new OperaDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btnumnog")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("60", res);
		driver.quit();
	}
	@Test
	public void testDevideOpera() 
	{
		System.setProperty("webdriver.opera.driver", "d:/operadriver.exe");
		WebDriver driver = new OperaDriver();
		driver.get("file:///d:/Java/ex_calk.html");	
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btn9")).click();
		driver.findElement(By.id("btndevide")).click();
		driver.findElement(By.id("btn3")).click();
		driver.findElement(By.id("btn3")).click();
		driver.findElement(By.id("btncount")).click();
		String res = driver.findElement(By.id("txt1")).getAttribute("value");
		assertEquals("3", res);
		driver.quit();
	}
}
