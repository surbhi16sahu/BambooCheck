Feature: Report has to be generate

@ReportGeneration
Scenario Outline: Validating User login
    Given user browse Url
	Given user will enter username "<Username>"
	When user will enter password "<Password>"
	Then user validates login 

  Examples: 
  
  |Username|Password| 
  |admin   |admin123|
  |admin   |admin111|	
