package testRunner;


import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;

import io.cucumber.junit.platform.engine.Constants;

@Suite //To make the class a test Suit
@IncludeEngines("cucumber") //Convert the Suit from Junit to Cucumber
@SelectClasspathResource("Features")//Give the folder name where the .feature files are located
@ConfigurationParameter( // property mentions where te step definitions are located
  key = Constants.GLUE_PROPERTY_NAME,
  value = "stepDefinitions")
@ConfigurationParameter(
  key = Constants.FILTER_TAGS_PROPERTY_NAME,
  value = "@activity3")
@ConfigurationParameter( //property to control /choose the scenarios /Feature to run
        key = Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty, html:Reports/HTML_Report.html, junit:Reports/XML_Report.xml, json:Reports/JSON_Report.json"
)
@ConfigurationParameter(
        key = Constants.PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME,
        value = "true"
)

public class TestRunner {

	
}
