/**
 *. Class that groups the defendant according to the data 
 *  @author Ramsha Rauf
 *. @version Spring 2022
 */
import java.util.*;
import org.junit.Assert;
import java.io.*;

public class DefendantGroup{
  /** A group of defendant stored as an ArrayList*/
  private ArrayList<Defendant> group;

  /**
  *Constructs a group of defendant with all of the defendants 
  *@param name of the file from which defendants are going to be created 
  *@return void
  */
  public DefendantGroup(String filename){
    
    //initializes an empty array list as group
    this.group = new ArrayList<Defendant>();
    Scanner file = null;
    try {
      file = new Scanner(new File("compas-scores.csv"));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    }
    while (file.hasNextLine()) {
      
      String line = file.nextLine();
      

      //formats each line as a defendent
      Defendant defendant = new Defendant(line);
      //adds the created defendant to the group
      group.add(defendant);
    }
    file.close();
    }

  /**
  *adds a defendant to the group 
  *@param Defendant 
  *@return void
  */  
  public void addDefendant(Defendant d){
    group.add(d);
  }

  /**
  *gets a defendant from the group 
  *@param index of the defendant
  *@return Defendant
  */  
  public Defendant getDefendant(int i){
    return group.get(i);
  }

  /**
  *removes a defendant from the group 
  *@param index of the defendant
  *@return void
  */  
  public void removeDefendant(int i){
    group.remove(i);
  }

  /**
  *gets the size of the group
  *@param void
  *@return the size of the group
  */  
  public int size(){
    return group.size();
  }

  public void proPublica(){
    // variables to count particular categories
    // note that medium and high risk are counted here as high
    int wly = 0; // White, low risk, has reoffended
    int wln = 0; // White, low risk, has not reoffended
    int bly = 0; // Black, low risk, has reoffended
    int bln = 0; // Black, low risk, has not reoffended
    int why = 0; // White, high risk, has reoffended
    int whn = 0; // White, high risk, has not reoffended
    int bhy = 0; // Black, high risk, has reoffended
    int bhn = 0; // Black, high risk, has not reoffended

    // loop to count sums
    for (int i = 0; i < size(); i++) {
      Defendant d = getDefendant(i);
      if (d.isWhite()&&d.isLowRisk()&&d.hasReoffended()) {
        wly++;
      } else if (d.isWhite()&&d.isLowRisk()&&!d.hasReoffended()) {
        wln++;
      } else if (d.isBlack()&&d.isLowRisk()&&d.hasReoffended()) {
        bly++;
      } else if (d.isBlack()&&d.isLowRisk()&&!d.hasReoffended()) {
        bln++;
      } else if (d.isWhite()&&!d.isLowRisk()&&d.hasReoffended()) {
        why++;
      } else if (d.isWhite()&&!d.isLowRisk()&&!d.hasReoffended()) {
        whn++;
      } else if (d.isBlack()&&!d.isLowRisk()&&d.hasReoffended()) {
        bhy++;
      } else if (d.isBlack()&&!d.isLowRisk()&&!d.hasReoffended()) {
        bhn++;
      }
    }

    // print the results
    System.out.println("White, high risk, didn't reoffend: "+whn*100.0/(whn+wln)+" %");
    System.out.println("Black, high risk, didn't reoffend: "+bhn*100.0/(bhn+bln)+" %");
    System.out.println("White, low risk, did reoffend: "+wly*100.0/(wly+why)+" %");
    System.out.println("Black, low risk, did reoffend: "+bly*100.0/(bly+bhy)+" %");
      }

  }

  
