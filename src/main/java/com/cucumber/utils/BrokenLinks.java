package com.cucumber.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinks {

	public static List<WebElement> findAllLinks(WebDriver driver)

	{

		List<WebElement> elementList = new ArrayList<WebElement>();

		elementList = driver.findElements(By.tagName("a"));

		elementList.addAll(driver.findElements(By.tagName("img")));

		List<WebElement> finalList = new ArrayList<WebElement>();
		

		for (WebElement element : elementList)

		{

			if (element.getAttribute("href") != null)

			{

				finalList.add(element);

			}

		}

		return finalList;

	}
	
	
	public static String isLinkBroken(URL url) throws Exception

	{

		//url = new URL("https://yahoo.com");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		try

		{

		    connection.connect();

		    String response = connection.getResponseMessage();	        

		    connection.disconnect();

		    return response;

		}

		catch(Exception exp)

		{

			return exp.getMessage();

		}				

	}
}
