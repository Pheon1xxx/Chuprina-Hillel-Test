package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Class cover {@link WebDriverFactory}
 * WD factory
 * Created by Vladislav
 * 08-07-2023
 */
public class WebDriverFactory {
    /**
     * Web Driver Factory
     */
    public enum browsers {
        CHROME {
            public WebDriver create() {
                return new ChromeDriver();
            }
        },
        IE {
            public WebDriver create() {
                return new InternetExplorerDriver();
            }
        },
        FIREFOX {
            public WebDriver create() {
                return new FirefoxDriver();
            }
        };

        /**
         * Create WD
         */
        public WebDriver create() {
            return null;
        }
    }


}

