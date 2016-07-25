package createLead;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import homework2.OpenTaps;

public class CreateLead extends OpenTaps{

	
	
	// Used to provide multiple data. initially we assigned some name
	@DataProvider(name="listOfValues")
	public Object[][] getData(){
//		//create an object called data and assign the values
		Object[][] data = new Object[2][7];
//		// Provide the values manually
		data[0][0]="Charan1";
		data[0][1]="Charan";
		data[0][2]="Teja";
		data[0][3]="LEAD_COLDCALL";
		data[0][4]="CATRQ_AUTOMOBILE";
		data[0][5]="Straw1@gmail.com";
		data[0][6]="9874563210";
		
		data[1][0]="Charan2";
		data[1][1]="Cherry";
		data[1][2]="Lucky";
		data[1][3]="LEAD_CONFERENCE";
		data[1][4]="CATRQ_CARNDRIVER";
		data[1][5]="Straw2@gmail.com";
		data[1][6]="9874563211";
		
		return data;
	}
	
	@Test(dataProvider="listOfValues")
	@Parameters("Browser2")
	public void createLead(String companyname, String firstname, String lastname, String source, String markatingcampain, String email, String mobilenumber) throws InterruptedException {
		clickByLinkText("Leads");
		clickByLinkText("Create Lead");
		enterTextById("createLeadForm_companyName", companyname);
		enterTextById("createLeadForm_firstName", firstname);
		enterTextById("createLeadForm_lastName",lastname);
		selectByValue("createLeadForm_dataSourceId", source);
		selectByValue("createLeadForm_marketingCampaignId", markatingcampain);
		enterTextById("createLeadForm_primaryEmail", email);
		enterTextById("createLeadForm_primaryPhoneNumber", mobilenumber);
		clickByClassName("smallSubmit");
		// to get the number from the string we use substring
		String name = getTextById("viewLead_companyName_sp");
		name = name.substring(name.indexOf("(") + 1, name.indexOf(")"));
		System.out.println(name);

		System.out.println("Im in CreateLead");
		
	}
	
	
	


}
