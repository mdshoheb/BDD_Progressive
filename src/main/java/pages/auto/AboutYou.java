package pages.auto;

import static common.CommonActions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.data.AutoData;

public class AboutYou {

	public AboutYou(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_FirstName")
	WebElement firstNameElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_MiddleInitial")
	WebElement middleInitialElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_LastName")
	WebElement lastNamElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_Suffix")
	WebElement suffixElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_DateOfBirth")
	WebElement dobElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_MailingAddress")
	WebElement mailingAddressElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_ApartmentUnit")
	WebElement aptNumberElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_City")
	WebElement cityElement;
	@FindBy(xpath = "//button[text()='Okay, start my quote.']")
	WebElement okayBtnElement;
	
	public void inputFirstName(String firstN) {
		input(firstNameElement, firstN);
	}

	public void inputFirstName(AutoData autoData) {
		input(firstNameElement, autoData.getFirstName());
	}

	public void inputMiddleName(String middleN) {
		input(middleInitialElement, middleN);
	}

	public void inputMiddleName(AutoData autoData) {
		input(middleInitialElement, autoData.getMiddleIn());
	}

	public void inputLastName(String lastN) {
		input(lastNamElement, lastN);
	}

	public void inputLastName(AutoData autoData) {
		input(lastNamElement, autoData.getLastName());
	}

	public void inputDob(String dob) {
		input(dobElement, dob);
	}

	public void inputDob(AutoData autoData) {
		input(dobElement, autoData.getDob());
	}

	public void inputMailingAddress(String address) {
		input(mailingAddressElement, address);
	}

	public void inputMailingAddress(AutoData autoData) {
		input(mailingAddressElement, autoData.getMailingAddress());
	}

	public void inputAptNumber(String apt) {
		input(aptNumberElement, apt);
	}

	public void inputAptNumber(AutoData autoData) {
		input(aptNumberElement, autoData.getApt());
	}

	public void inputCity(String city) {
		input(cityElement, city);
	}

	public void inputCity(AutoData autoData) {
		input(cityElement, autoData.getCity());
	}

	public void clickOkay() {
		click(okayBtnElement);
	}


	public void aboutYouSteps(String firstN, String middleN, String lastName, String dob,
			String mAddress, String apt, String city) {
		input(firstNameElement, firstN);
		input(middleInitialElement, middleN);
		input(lastNamElement, lastName);
		input(dobElement, dob);
		input(mailingAddressElement, mAddress);
		input(aptNumberElement, apt);
		input(cityElement, city);
		click(okayBtnElement);
	}

	 public void aboutYouSteps(AutoData autoData) {
		input(firstNameElement, autoData.getFirstName());
		input(lastNamElement, autoData.getLastName());
		input(middleInitialElement, autoData.getMiddleIn());
		input(dobElement, autoData.getDob());
		input(mailingAddressElement, autoData.getMailingAddress());
		input(aptNumberElement, autoData.getApt());
		input(cityElement, autoData.getCity());
		click(okayBtnElement);
	}

}
