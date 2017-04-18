package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs extends Driver {
	DesiredCapabilities caps;

	public void setSauceLabs() {
		String URL = "https://" + getSaucelabsProperties("userName") + ":" + getSaucelabsProperties("accessKey")
		+ "@ondemand.saucelabs.com:443/wd/hub";
		
		setCapabilities();

		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void setCapabilities() {

		if (getSaucelabsProperties("browser").equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		} else if (getSaucelabsProperties("browser").equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		} else if (getSaucelabsProperties("browser").equalsIgnoreCase("safari")) {
			caps = DesiredCapabilities.safari();
		} else if (getSaucelabsProperties("browser").equalsIgnoreCase("internetExplorer")) {
			caps = DesiredCapabilities.internetExplorer();
		} else {
			caps = DesiredCapabilities.firefox();
		}

		caps.setCapability("platform", getSaucelabsProperties("operatingSystem"));
		caps.setCapability("version", getSaucelabsProperties("browserVersion"));

	}

}
