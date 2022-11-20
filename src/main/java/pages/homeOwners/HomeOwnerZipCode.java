package pages.homeOwners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static common.CommonActions.*;

public class HomeOwnerZipCode {
	
	public HomeOwnerZipCode(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='zipCode_overlay']")
	WebElement zipCodElement;
	@FindBy(xpath = "//input[@id='qsButton_overlay']")
	WebElement getQuotElement;
	
	public void zipCodeSteps(String zipCode) {
		input(zipCodElement, zipCode);
		click(getQuotElement);
	}

}
