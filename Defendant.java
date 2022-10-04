/**
 *. Class to represent the characteristics of one defendant from a dataset
 *  @author Ramsha Rauf
 *. @version Spring 2022
 */

 import java.util.*;
public class Defendant implements ProPublica {

  /** Sex of defendant stored as a string*/
  private String sex;

  /** race of defendant stored as a string */
  private String race;

  /** The degree of the criminal charge stored as a char */
  private char c_charge_degree;

  /** the description of the criminal charge stored as a String */
  private String c_charge_desc;

  /** the score given by the machine stored an int */
  private int decile_score;

  /** the type of the score stored as a String*/
  private String score_text;

  /** number of crimes committed within the next two years is stored as a integer */
  private boolean two_year_recid;

  /** the description of the crime committed within the next two years is stored as a String */
  private String r_charge_desc;

  /** the degree of charge of the crime committed within the next two years is stored as a String */
  private String r_charge_degree;


  /**
  *Constructs a new defendant using individual fields
  *@param sex of the defendant, race of the defendant, degree of the criminal charge, description of the criminal charge, COMPAS score given to the defendant, risk level, whether or not they have committed a crime again, description of the new crime, degree of the new crime
  *@return void
  */
  public Defendant(String sex, String race, char c_charge_degree, String c_charge_desc,int decile_score, String score_text, int two_year_recid_int,String r_charge_desc, String r_charge_degree ){
    this.sex = sex;
    this.race = race;
    this.c_charge_degree = c_charge_degree;
    this.c_charge_desc = c_charge_desc; 
    this.decile_score = decile_score;
    this.score_text = score_text;
    if (two_year_recid_int == 1){
      this.two_year_recid = true;
    }else{
      this.two_year_recid = false;
    }
    this.r_charge_desc = r_charge_desc;
    this.r_charge_degree = r_charge_degree;

  }

  /**
  *Constructs a new defendant using unseperated fields
  *@param a string that has the sex, race, degree of criminal charge, description of the criminal charge, COMPAS score, risk level, reoffended or not, description of the new crime, degree of the new crime in that order 
  *@return void
  */
  public Defendant(String rows){
    //converts rows into an array with all the fields
    String row [] = rows.split(",");
    this.sex = row[0];
    this.race = row[1];
    this.c_charge_degree = row[2].charAt(0);
    this.c_charge_desc = row[3]; 
    this.decile_score = Integer.valueOf(row[4]);
    this.score_text = row[5];
    int two_year_recid_int = Integer.valueOf(row[6]);

    //if the two_year_recid_int is 1 then two_year_recid will be true otherwise it will be false
    if (two_year_recid_int==1){
      this.two_year_recid = true; 
    }else{
      this.two_year_recid = false;
    }

    //The description and the degree of the new crime will only be initiated if the defendent reoffend within the next two years
    if (this.two_year_recid == true){
      this.r_charge_desc = row[7];
      this.r_charge_degree = row[8];
    }
    
   
  }

  /** getter for sex */
  public String getSex(){
    return sex;
  }

  /** getter for race */
  public String getRace(){
    return race;
  }

  /** getter for c_charge_degree */
  public char getC_charge_degree(){
    return c_charge_degree;
  }

  /** getter for c_charge_desc */
  public String getC_charge_desc(){
    return c_charge_desc;
  }

  /** getter for decile_score */
  public int getDecile_score(){
    return decile_score;
  }

  /** getter for score_text */
  public String getScore_text(){
    return score_text;
  }

  /** getter for two_year_recid */
  public boolean getTwo_year_recid(){
    return two_year_recid;
  }

  /** getter for r_charge_desc */
  public String getR_charge_desc(){
    return r_charge_desc;
  }
  
  /** getter for r_charge_degree */
  public String getR_charge_degree(){
    return r_charge_degree;
  }

  /** setter for sex */
  public void setSex(String sex){
    this.sex = sex;
  }

  /** setter for race */
  public void setRace(String race){
    this.race = race;
  }

  /** setter for c_charge_degree */
  public void setC_charge_degree(char c_charge_degree ){
    this.c_charge_degree = c_charge_degree;
  }

  /** setter for c_charge_desc */
  public void setC_charge_desc(String c_charge_desc){
    this.c_charge_desc = c_charge_desc;
  }

  /** setter for decile_score */
  public void setDecile_score(int decile_score){
    this.decile_score = decile_score;
  }

  /** setter for score_text */
  public void setScore_text(String score_text){
    this.score_text = score_text;
  }

  /** setter for two_year_recid */
  public void setTwo_year_recid(int two_year_recid_int){
    if (two_year_recid_int==1){
      this.two_year_recid = true;
    }else{
      this.two_year_recid = false;
    }
    
  }

  /** setter for r_charge_desc */
  public void setR_charge_desc(String r_charge_desc){
    this.r_charge_desc = r_charge_desc;
  }
  
  /** setter for r_charge_degree */
  public void setR_charge_degree(String r_charge_degree){
    this.r_charge_degree = r_charge_degree;
  }

 /**
  *checks whether or not the defendant is white
  *@param void
  *@return T/F: returns true if the defendant is white otherwise false
  */
  public boolean isWhite(){
    return this.race.equals("Caucasian");
  
  }

   /**
  *checks whether or not the defendant is black
  *@param void
  *@return T/F: returns true if the defendant is black otherwise false
  */
  public boolean isBlack(){
    return this.race.equals("African-American");
  }

  /**
  *checks whether or not the defendant has reoffended
  *@param void
  *@return T/F: returns true if the defendant has reoffended otherwise false
  */
  public boolean hasReoffended(){
    return this.two_year_recid;
  }

  /**
  *checks whether or not the defendant has been marked as low risk
  *@param void
  *@return T/F: returns true if the defendant has been marked as low risk
  */
  public boolean isLowRisk(){
    return this.score_text.equals("Low");
  }
  

  /**
  *Prints all of the fields of the defendant in a readable way
  *@param void
  *@return a string with the entire data printed 
  */
  public String toString() {
    return "Sex of defendant: " + sex + 
    "\nRace of the defendant: " + race + 
     "\nDegree of the criminal charge: " + c_charge_degree + 
     "\nDescription of the criminal charge: " + c_charge_desc + 
     "\nCOMPAS score: " + decile_score + 
     "\nRisk level: " + score_text +
     "\nCommitted crimes within the next two years: " + two_year_recid + 
     "\nDescription of the crime committed within two years: " + r_charge_desc + 
     "\nDegree of the crime committed within two years: " + r_charge_degree + "\n\n" ;
  }
  
}