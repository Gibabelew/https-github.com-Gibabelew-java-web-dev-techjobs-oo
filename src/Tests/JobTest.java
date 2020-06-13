package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;
    Job jobWithAllFields;
    Job jobWithAllFields2;
    Job jobWithSomeMissingFields;

    @Before
    public void createJobObjects(){
    job1 = new Job();
    job2 = new Job ();
    jobWithAllFields=new Job ("Product tester",new Employer ( "ACME" ),new Location ( "Desert" ), new PositionType ( "Quality control" ),new CoreCompetency ( "Persistence" ) );
    jobWithAllFields2 = new Job("Product tester",new Employer ( "ACME" ), new Location ( "Desert" ),new PositionType ( "Quality control" ),new CoreCompetency ( "Persistence" ));
    jobWithSomeMissingFields = new Job("Product tester",new Employer ( "ACME" ), new Location ( "Desert" ),new PositionType ( "Quality control" ),new CoreCompetency ( "Persistence" ));
    }
    @Test
    public void testSettingJobId(){assertFalse(job1.equals(job2));}

    @Test
    public void testJobIdOffByOne(){ assertEquals ( job2.getId (),(job1.getId ()+1) );}

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals ( jobWithAllFields.getName (),"Product tester" );
        assertEquals ( jobWithAllFields.getEmployer (),"ACME" );
        assertEquals ( jobWithAllFields.getLocation (),"Desert" );
        assertEquals ( jobWithAllFields.getPositionType (),"Quality control" );
        assertEquals ( jobWithAllFields.getCoreCompetency (),"Persistence" );

    }
    @Test
    public void testJobForEquality(){assertNotEquals (jobWithAllFields,jobWithAllFields2  );}

    @Test
    public void testToString(){
    assertEquals ( jobWithAllFields.toString (),"\nID: 8\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type:Quality control\nCore Competency: Persistence\n" );

    }
    @Test
    public void testToStringSomeMissingFields(){
    assertEquals ( jobWithSomeMissingFields.toString (),"\nID: 8\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type:Quality control\nCore Competency: Persistence\n ");
    }
}