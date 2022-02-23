package com.globalLogic.jbehave;

import com.globalLogic.utils.Utils;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.ThucydidesSystemProperty;

public class JBehaveTestCase extends SerenityStories{
	
	public JBehaveTestCase() {
		System.setProperty(ThucydidesSystemProperty.PROPERTIES.getPropertyName(),"project.properties");
        System.setProperty("webdriver.chrome.driver", Utils.getProperty("webdriver.chrome.driver"));
	}

}
