/* YOU WILL NEED TO MODIFY THIS FILE */
import java.util.*;
import org.junit.Assert;
import java.io.*;


public class Main {
  
  public static void main(String[] args) {
    //Calls testConstructor, testSetter, testStringConstructor, testFilerReader, testBools to ensure that the construct, setter, string constructor, file reader and the conditions in ProPublica are implemented correctly.
     testConstructor();
     testSetters();
     testStringConstructor();
     testFileReader();
     testBools();

     //calls the defendent group with the compas-scores and implements the conditions in proPublica and prints the result of the data analysis
     DefendantGroup defendantGroup = new DefendantGroup("compas-scores.csv");
     defendantGroup.proPublica();
  }
  
  /**
  *Tests the field seperated constructor of the class Defendant using a test defendant d. 
  *@param none
  *@return void
  */

  public static void testConstructor() {

    /* constructs an object for testing purposes*/
    Defendant d = new Defendant("Male","African-American",'F',"Felony Battery w/Prior Convict",3,"Low",1,"Felony Battery (Dom Strang)","(F3)");

    /*checks the constructor using tester defendant d to ensure that all values are correctly set using assert.assertEquals */
    Assert.assertEquals("Male",d.getSex());
    Assert.assertEquals("African-American",d.getRace());
    Assert.assertEquals('F',d.getC_charge_degree());
    Assert.assertEquals("Felony Battery w/Prior Convict",d.getC_charge_desc());
    Assert.assertEquals(3,d.getDecile_score());
    Assert.assertEquals("Low",d.getScore_text());
    Assert.assertEquals(true,d.getTwo_year_recid());
    Assert.assertEquals("Felony Battery (Dom Strang)",d.getR_charge_desc());
    Assert.assertEquals("(F3)",d.getR_charge_degree());

    /*checks the constructor using tester defendant d to ensure that all values are correctly set using Test Code derived tests and prints Passed: Constructor if the all of the tests pass */
    TestCode.beginTest("Contructor");
    TestCode.subTest("Constructor sex",d.getSex().equals("Male"));
    TestCode.subTest("Constructor race",d.getRace().equals("African-American"));
    TestCode.subTest("Constructor criminal charge degree",d.getC_charge_degree()==('F'));
    TestCode.subTest("Constructor criminal charge description",d.getC_charge_desc().equals("Felony Battery w/Prior Convict"));
    TestCode.subTest("Constructor decile score",d.getDecile_score()==3);
    TestCode.subTest("Constructor score level",d.getScore_text().equals("Low"));
    TestCode.subTest("Constructor Crimes done within two years",d.getTwo_year_recid()==true);
    TestCode.subTest("Constructor Crime description",d.getR_charge_desc().equals("Felony Battery (Dom Strang)"));
    TestCode.subTest("Constructor criminal charge degree",d.getR_charge_degree().equals("(F3)"));
    TestCode.concludeTest();

  }

  /**
  *Tests to ensure that the conditions of proPublica are being correctly evaluated
  *@param none
  *@return void
  */

  public static void testBools() {
    
    /*creates a tester defendant called d*/
    Defendant d = new Defendant("Male","African-American",'F',"Felony Battery w/Prior Convict",3,"Low",1,"Felony Battery (Dom Strang)","(F3)");

    /* Tests the isWhite(), isBlack(), hasReoffended(), isLowRisk(), and isHighRisk() methods using Assert.assertEquals*/
    Assert.assertEquals(false,d.isWhite());
    Assert.assertEquals(true,d.isBlack());
    Assert.assertEquals(true,d.hasReoffended());
    Assert.assertEquals(true,d.isLowRisk());

    /*tests the isWhite(), isBlack(), hasReoffended(), isLowRisk(), and isHighRisk() methods using the methods in Test code*/
    TestCode.beginTest("ProPublica Interface");
    TestCode.subTest("Is white",d.isWhite()==false);
    TestCode.subTest("Is black",d.isBlack()==true);
    TestCode.subTest("Has reoffended",d.hasReoffended()==true);
    TestCode.subTest("Is low risk",d.isLowRisk()==true);
    TestCode.concludeTest();

  }


  /**
  *Tests the getters and setter of class defendants
  *@param none
  *@return void
  */

  public static void testSetters() {

    /*creates a tester defendant called d*/
    Defendant d = new Defendant("Male","African-American",'F',"Felony Battery w/Prior Convict",3,"Low",1,"Felony Battery (Dom Strang)","(F3)");

    /*sets different fields for tester defedant d*/
    d.setSex("Female");
    d.setRace("Caucasian");
    d.setC_charge_degree('F');
    d.setC_charge_desc("arrest case no charge");
    d.setDecile_score(1);
    d.setScore_text("Low");
    d.setTwo_year_recid(1);
    d.setR_charge_desc("Grand Theft (Motor Vehicle)");
    d.setR_charge_degree("(F3)");

    /*checks if the new values set for tester defendant d have been updated using assert.assertEquals*/
    Assert.assertEquals("Female",d.getSex());
    Assert.assertEquals("Caucasian",d.getRace());
    Assert.assertEquals('F',d.getC_charge_degree());
    Assert.assertEquals("arrest case no charge",d.getC_charge_desc());
    Assert.assertEquals(1,d.getDecile_score());
    Assert.assertEquals("Low",d.getScore_text());
    Assert.assertEquals(true,d.getTwo_year_recid());
    Assert.assertEquals("Grand Theft (Motor Vehicle)",d.getR_charge_desc());
    Assert.assertEquals("(F3)",d.getR_charge_degree());

    /*checks if the new values set for tester defendant d have been updated using methods from Test Code and prints Passed: Setters if the values are correctly set*/
    TestCode.beginTest("Setters");
    TestCode.subTest("Constructor sex",d.getSex().equals("Female"));
    TestCode.subTest("Constructor race",d.getRace().equals("Caucasian"));
    TestCode.subTest("Constructor criminal charge degree",d.getC_charge_degree()==('F'));
    TestCode.subTest("Constructor criminal charge description",d.getC_charge_desc().equals("arrest case no charge"));
    TestCode.subTest("Constructor decile score",d.getDecile_score()==1);
    TestCode.subTest("Constructor score level",d.getScore_text().equals("Low"));
    TestCode.subTest("Constructor Crimes done within two years",d.getTwo_year_recid()==true);
    TestCode.subTest("Constructor Crime description",d.getR_charge_desc().equals("Grand Theft (Motor Vehicle)"));
    TestCode.subTest("Constructor criminal charge degree",d.getR_charge_degree().equals("(F3)"));
    TestCode.concludeTest();
  }

  /**
  *Tests to ensure that the string constructor is working
  *@param none
  *@return void
  */
  public static void testStringConstructor(){

    // constructs a tester defendant called d that has 7 feilds in a string
    Defendant d = new Defendant("Male,Other,M,Battery,1,Low,0,,");

    //ensures that the values of tester defendant d are set correctly using assert.assertEquals
    Assert.assertEquals("Male",d.getSex());
    Assert.assertEquals("Other",d.getRace());
    Assert.assertEquals('M',d.getC_charge_degree());
    Assert.assertEquals("Battery",d.getC_charge_desc());
    Assert.assertEquals(1,d.getDecile_score());
    Assert.assertEquals("Low",d.getScore_text());
    Assert.assertEquals(false,d.getTwo_year_recid());



    //ensures that the values of tester defendant d are set correctly using the methods in test code 
    TestCode.beginTest("String Contructor ");
    TestCode.subTest("Constructor sex",d.getSex().equals("Male"));
    TestCode.subTest("Constructor race",d.getRace().equals("Other"));
    TestCode.subTest("Constructor criminal charge degree",d.getC_charge_degree()==('M'));
    TestCode.subTest("Constructor criminal charge description",d.getC_charge_desc().equals("Battery"));
    TestCode.subTest("Constructor decile score",d.getDecile_score()==1);
    TestCode.subTest("Constructor score level",d.getScore_text().equals("Low"));
    TestCode.subTest("Constructor Crimes done within two years",d.getTwo_year_recid()==false);
    TestCode.concludeTest();
  }

  /**
  *Ensures that defendants are being constructed from the compas-scores.csv file
  *@param none
  *@return void
  */
  public static void testFileReader(){
    Scanner file = null;
    try {
      file = new Scanner(new File("compas-scores.csv"));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    }
    while (file.hasNextLine()) {
      
      String line = file.nextLine();
      Defendant d = new Defendant(line);
      //System.out.println(d);
    }
    file.close();
    }

  


}