package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers{

	RemoteWebDriver driver;
	
	int i=1;
	
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
	try {
		if (browser.equalsIgnoreCase("chrome")) {
		    System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		    driver=new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		    driver=new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver","./drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		    driver.manage().window().maximize();
		                                                                                             
		    driver.get(url);	
		    System.out.println("The browser "+browser+" is launched with the given URL "+url+" successfully");
	   } catch (SessionNotCreatedException e) {
		// TODO Auto-generated catch block
		System.err.println("The browser "+browser+" is not launched due to session not created error");
	   } catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println("The browser "+browser+" is not launched due to unknown error");
	   }finally {
		   takeSnap();
	   }
	}

	
	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
	try {
		driver.findElementById(idValue).sendKeys(data);
		System.out.println("The Element with Id "+idValue+" is entered with data "+data);
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("The Element with Id "+idValue+" is not found in DOM");
	} catch (ElementNotVisibleException e) {
		// TODO: handle exception
		System.err.println("The Element with Id "+idValue+" is not visible in the application");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println("The Element with Id "+idValue+" is not Interactable in the application");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println("The Element with Id "+idValue+" is not Stable in the application");
	} catch (WebDriverException  e) {
		// TODO: handle exception
		System.err.println("The Element with Id "+idValue+" is not entered with data "+data+"due to Unknown error");
	}finally {
		takeSnap();
	  }
	}

	
	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("The Element with Name "+nameValue+" is entered with data "+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with Name "+nameValue+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with Name "+nameValue+" is not visible in the application");	
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with Name "+nameValue+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with Name "+nameValue+" is not Stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The Element with Name "+nameValue+" is not entered with data "+data+"due to Unknown error");
		}finally {
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The Element with Xpath "+xpathValue+" is entered with data "+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with Xpath "+xpathValue+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathValue+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathValue+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathValue+" is not Stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathValue+" is not entered with data "+data+"due to Unknown error");
		}finally {
			takeSnap();
		}
	}
 
	
	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		try {
			String actualtext=driver.getTitle();
			if (actualtext.equals(title)) {
				System.out.println("The Title of the page "+actualtext+" is matched with expected title "+title);
			} else {
			    System.err.println("The Title of the page "+actualtext+" is not matched with expected title "+title);
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("The Title of the page cannot be verified due to unknown error");
		} finally {
			takeSnap();
		}
	}

	
	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext=driver.findElementById(id).getText();
			if (actualtext.equals(text)) {
				System.out.println("The Element with Id "+id+" is having the text "+actualtext+" matched with expected text "+text);		
			} else {
				System.err.println("The Element with Id "+id+" is having the text "+actualtext+" not matched with expected text "+text);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with Id "+id+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+id+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+id+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+id+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The text in the Element with Id "+id+" cannot be verified due to Unknown error");
		}finally {
			takeSnap();
		  }
	}

	
	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext=driver.findElementByXPath(xpath).getText();
			if (actualtext.equals(text)) {
				System.out.println("The Element with Xpath "+xpath+" is having the text "+actualtext+" matched with expected text "+text);
			} else {
				System.err.println("The Element with Xpath "+xpath+" is having the text "+actualtext+" not matched with expected text "+text);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with Xpath "+xpath+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpath+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpath+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpath+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The text in the Element with Xpath "+xpath+" cannot be verified due to Unknown error");
		}finally {
			takeSnap();
		  }
		}
		

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext=driver.findElementByXPath(xpath).getText();
			if (actualtext.contains(text)) {
				System.out.println("The Element with Xpath "+xpath+" is having the text "+actualtext+" matched with expected text "+text);
			} else {
				System.err.println("The Element with Xpath "+xpath+" is having the text "+actualtext+" not matched with expected text "+text);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with Xpath "+xpath+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpath+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpath+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpath+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The text in the Element with Xpath "+xpath+" cannot be verified due to Unknown error");
		}finally {
			takeSnap();
		  }
	    }

	
	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
			System.out.println("The Element with Id "+id+" is clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with Id "+id+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+id+" is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+id+" is not Intercepted in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+id+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+id+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+id+" is not clicked due to Unknown error");
		}finally {
			takeSnap();
		  }
		}

	
	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("The Element with ClassName "+classVal+" is clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with ClassName "+classVal+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with ClassName "+classVal+" is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println("The Element with ClassName "+classVal+" is not Intercepted in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with ClassName "+classVal+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with ClassName "+classVal+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Element with ClassName "+classVal+" is not clicked due to Unknown error");
		}finally {
			takeSnap();
		}
	}

	
	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			System.out.println("The Element with Name "+name+" is clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with Name "+name+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with Name "+name+" is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println("The Element with Name "+name+" is not Intercepted in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with Name "+name+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with Name "+name+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Element with Name "+name+" is not clicked due to Unknown error");
		}finally {
			takeSnap();
		}
	}

	
	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The Element with LinkText "+name+" is clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with LinkText "+name+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with LinkText "+name+" is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println("The Element with LinkText "+name+" is not Intercepted in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with LinkText "+name+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with LinkText "+name+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Element with LinkText "+name+" is not clicked due to Unknown error");
		}finally {
			takeSnap();
		}
	}

	
	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The Element with LinkText "+name+" is clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with LinkText "+name+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with LinkText "+name+" is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println("The Element with LinkText "+name+" is not Intercepted in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with LinkText "+name+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with LinkText "+name+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Element with LinkText "+name+" is not clicked due to Unknown error");
		}
	}

	
	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The Element with Xpath "+xpathVal+" is clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with Xpath "+xpathVal+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not Intercepted in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not clicked due to Unknown error");
		}finally {
			takeSnap();
		}
	}

	
	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The Element with Xpath "+xpathVal+" is clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with Xpath "+xpathVal+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not Intercepted in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not clicked due to Unknown error");
		}
	}

	
	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String actualtext=null;
		try {
			actualtext=driver.findElementById(idVal).getText();
			System.out.println("The Element with Id "+idVal+" having the text "+actualtext);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with Id "+idVal+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+idVal+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+idVal+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+idVal+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Element with Id "+idVal+" Text is not getting due to Unknown error");
		}finally {
			takeSnap();
		  }
		
		return actualtext;
	}

	
	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		String actualtext=null;
		try {
		    actualtext=driver.findElementByXPath(xpathVal).getText();
			System.out.println("The Element with Xpath "+xpathVal+" having the text "+actualtext);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with Xpath "+xpathVal+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" is not Stable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Element with Xpath "+xpathVal+" Text is not getting due to Unknown error");
		}finally {
			takeSnap();
		  }
		return actualtext;
	}

	
	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement element=driver.findElementById(id);
			Select sel=new Select(element);
			sel.selectByVisibleText(value);
			System.out.println("The Dropdown Element with Id "+id+" is selected with VisibleText value "+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
		    System.err.println("The Dropdown Element with Id "+id+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Id "+id+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Id "+id+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Id "+id+" is not Stable in the application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Id "+id+" is not selectable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Id "+id+" is not functioning due to Unknown error");
		}finally {
			takeSnap();
		  }
		}
	

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement element=driver.findElementById(id);
			Select sel=new Select(element);
			sel.selectByIndex(value);
			System.out.println("The Dropdown Element with Id "+id+" is selected with Index value "+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
		    System.err.println("The Dropdown Element with Id "+id+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Id "+id+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Id "+id+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Id "+id+" is not Stable in the application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Id "+id+" is not selectable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Id "+id+" is not functioning due to Unknown error");
		}finally {
			takeSnap();
		  }
	}

	
	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> allWinIDAfterClick=driver.getWindowHandles();
			for (String eachID : allWinIDAfterClick) {
				driver.switchTo().window(eachID);
				break;
			}
	        System.out.println("The Window is a Parent Window which is switched from latest window");
		} catch (NoSuchWindowException e) {
			// TODO: handle exception
			System.err.println("The Window is not switched to Parent Window due to No Such Window in that browser");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The Window is not switched to Parent Window due to Unknown error");
		}finally {
			takeSnap();
		}
	}

	
	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> allWinIDAfterClick=driver.getWindowHandles();
			for (String eachID : allWinIDAfterClick) {
				driver.switchTo().window(eachID);
			}
	        System.out.println("The Window is a Latest(Last) Window which is switched from parent window");
		} catch (NoSuchWindowException e) {
			// TODO: handle exception
			System.err.println("The Window is not switched to Latest(Last) Window due to No Such Window in that browser");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The Window is not switched to Latest(Last) Window due to Unknown error");
		}finally {
			takeSnap();
		}
	}

	
	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			System.out.println("The Alert is Accepted");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not Accepted due to No Alert is Present");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Alert is not Accepted due to Unknown error");
		}finally {
			takeSnap();
		}	
	}

	
	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("The Alert is Dismiss");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not Dismiss due to No Alert is Present");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Alert is not Dismiss due to Unknown error");
		}finally {
			takeSnap();
		}	
	}

	
	public String getAlertText() {
		// TODO Auto-generated method stub
		String alertText=null;
		try {
			alertText=driver.switchTo().alert().getText();
			System.out.println("The Text from Alert "+alertText);
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert Text is not get due to No Alert is Present");
		} catch (UnhandledAlertException e) {
			// TODO: handle exception
			System.err.println("Alert Text is not get due to Unhandled Alert is Present");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Alert Text is not get due to Unknown error");
		}
		return alertText;
	}

	
	public void takeSnap() {
		// TODO Auto-generated method stub	
		try {
			File temp = driver.getScreenshotAs(OutputType.FILE);
			
			File dest = new File("./screenshots/snap"+i+".png");
			
			FileUtils.copyFile(temp, dest);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		i++;
		
	}

	
	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			System.out.println("The Browser is closed");
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			System.err.println("The Browser is not closed due to Session Not Created");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The Browser is not closed due to Unknown error");
		}finally {
			takeSnap();
		}	
	}

	
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			System.out.println("The All Browsers are closed");
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			System.err.println("The All Browsers are not closed due to Session Not Created");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The All Browsers are not closed due to Unknown error");
		}finally {
			takeSnap();
	    }
     }


	public void waitProperty(long time)  {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time);
			System.out.println("The Sleep is activated for time "+time+" milliseconds");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println("The Sleep is not working due to Interrupted error");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The Sleep is not working due to Unknown error");
		} finally {
			takeSnap();
		}		
	 }


	public void pagedown() {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath("//html/body").sendKeys(Keys.PAGE_DOWN);
			System.out.println("The Pagedown method is accessed");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("The Pagedown is not working due to Unknown error");
		} finally {
			takeSnap();
		}
	}


	public void selectVisibileTextByXpath(String xpath, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement element=driver.findElementByXPath(xpath);
			Select sel=new Select(element);
			sel.selectByVisibleText(value);
			System.out.println("The Dropdown Element with Xpath "+xpath+" is selected with VisibleText value "+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
		    System.err.println("The Dropdown Element with Xpath "+xpath+" is not found in DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Xpath "+xpath+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Xpath "+xpath+" is not Interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Xpath "+xpath+" is not Stable in the application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Xpath "+xpath+" is not selectable in the application");
		} catch (WebDriverException  e) {
			// TODO: handle exception
			System.err.println("The Dropdown Element with Xpath "+xpath+" is not functioning due to Unknown error");
		}finally {
			takeSnap();
		}
	 }


	public void TABkey() {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath("//html/body").sendKeys(Keys.TAB);
			System.out.println("The TAB Key is accessed");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("The TAB Key is not working due to Unknown error");
		}finally {
			takeSnap();
		}
	  }
	
	
	
}