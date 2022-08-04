
import com.aoe.gebspockreports.GebReportingListener
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.LoggingPreferences

import java.util.logging.Level

reportingListener = new GebReportingListener()
def properties = new SpecHelper().getApplicationProperties()
reportsDir = properties."config.reports.dir"
baseUrl = properties."config.application.url"


atCheckWaiting = true

//Default driver, you can use it in local environment
WebDriverManager.chromedriver().setup()
driver = { new ChromeDriver() }


// setup system property geb.env=<select an environment such as dev, test or localChrome>
environments {
    dev {
        driver = {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions()
            edgeOptions.setHeadless(true)
            edgeOptions.setPlatformName("LINUX")

            WebDriver driver = new EdgeDriver(edgeOptions)
            driver.manage().window().size = new Dimension(1350, 850)
            return driver
        }
    }
    test {
        driver = {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions()
            edgeOptions.setHeadless(true)
            edgeOptions.setPlatformName("LINUX")


            WebDriver driver = new EdgeDriver(edgeOptions)
            driver.manage().window().size = new Dimension(1350, 850)
            return driver
        }
    }
    localChrome {
        driver = {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions()
            chromeOptions.addArguments("--no-sandbox")
            chromeOptions.addArguments("--dns-prefetch-disable")
            chromeOptions.addArguments("--disable-gpu")


            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
            chromeOptions.setCapability( "goog:loggingPrefs", logPrefs );

            WebDriver driver = new ChromeDriver(chromeOptions)
            driver.manage().window().size = new Dimension(1350, 850)
            return driver
        }
    }
    localEdge {
        driver = {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions()

            WebDriver driver = new EdgeDriver(edgeOptions)
            driver.manage().window().size = new Dimension(1350, 850)
            return driver
        }
    }
}
waiting {
    timeout = 25
    retryInterval = 0.5
    includeCauseInMessage = true
    presets {
        slow {
            timeout = 50
            retryInterval = 1
        }
        quick {
            timeout = 10
            timeout = 10
        }
    }
}


