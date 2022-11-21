package steps;

import base.BaseClass;
import common.CommonActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reporting.Logs;

public class AutoSteps extends BaseClass {

	@Given("user navigate to homepage")
	public void user_navigate_to_homepage() {
		Logs.log("Before hook");
	}

	@When("user select auto")
	public void user_select_auto() {
		homePage.clickAuto();
	}

	@When("user input zipcode")
	public void user_input_zipcode() {
		homePage.inputZip("11368");
	}

	@When("click start quote")
	public void click_start_quote() {
		homePage.clickGetQuote();
	}

	@Then("user will be in about you page")
	public void user_will_be_in_about_you_page() {
		CommonActions.sleep(2);
		Logs.log(getDriver().getCurrentUrl());
	}

	@When("user input firstName")
	public void user_input_first_name() {
		aboutYou.inputFirstName("Walter");
	}

	@When("user input middle initial")
	public void user_input_middle_initial() {
		aboutYou.inputMiddleName("J");
	}

	@When("user input lastName")
	public void user_input_last_name() {
		aboutYou.inputLastName("White");
	}

	@When("user input dob")
	public void user_input_dob() {
		aboutYou.inputDob("06/24/1950");
	}

	@When("user input mailing address")
	public void user_input_mailing_address() {
		aboutYou.inputMailingAddress("9610 57th Ave");
	}

	@When("user input apartment number")
	public void user_input_apartment_number() {
		aboutYou.inputAptNumber("17G");
	}

	@When("user input city name")
	public void user_input_city_name() {
		aboutYou.inputCity("Corona");
	}

	@Then("user should be able to click okay button")
	public void user_should_be_able_to_click_okay_button() {
		aboutYou.clickOkay();
		Logs.log("User successfully click the Okay button");
	}

	@When("homepage steps done with {string}")
	public void homepage_steps_done_with(String string) {
		homePage.autoSteps(string);
	}

	@Then("about you page steps done")
	public void about_you_page_steps_done() {
		aboutYou.aboutYouSteps("Jessy", "N", "Pinkman", "09/11/1988", "9620 57th Ave", "16G", "Corona");
	}

}
