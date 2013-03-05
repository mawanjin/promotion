package test;


import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.persist.dao.Mhpromotion;
import org.persist.dao.MhpromotionHome;
import org.persist.dao.MhpromotionOnline;
import org.persist.dao.MhpromotionOnlineHome;

/**
 * Unit test for simple App.
 */
public class MhpromotionOnlineHomeTest 
    extends TestCase
{
	Logger log = LogManager.getLogger(MhpromotionOnlineHomeTest.class.getName());
	MhpromotionOnlineHome home = new MhpromotionOnlineHome();
	MhpromotionHome m = new MhpromotionHome(Mhpromotion.class);
	
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MhpromotionOnlineHomeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MhpromotionOnlineHomeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
//    public void testFindByExample()
//    {
//    	log.info("testFindByExample() called.");
//    	MhpromotionOnline instance = new MhpromotionOnline();
//    	
//    	List<MhpromotionOnline> ps = home.findByExample(instance);
//    	if(ps.size()>0){
//    		System.out.println(ps.get(0).getPorder()+";"+ps.size());
//    	}
//    	assertNotNull(ps);
//    }
//    
//    public void testPersist()
//    {
//    	log.info("testPersist() called.");
//    	MhpromotionOnline instance = new MhpromotionOnline();
//    	instance.setMhpromotion((Mhpromotion)m.findById("402881843d1a83d9013d1a83dba20002"));
//    	instance.setPorder(1);
//    	
//    	assertTrue(home.persist(instance));
//    }
//    
//    public void testFindById(){
//    	log.info("testFindById() called.");
//    	MhpromotionOnline h = home.findById("402881843d1a83d9013d1a83dba20002");
//    	assertNotNull(h);
//    }
//    
//    public void testDelete(){
//    	log.info("testFindById() called.");
//    	MhpromotionOnline h = home.findById("402881843d1a83d9013d1a83dba20002");
//    	assertTrue(home.delete(h));
//    }
    
//    public void testFindByCategoryId(){
//    	log.info("testFindByCategoryId() called.");
//    	List<MhpromotionOnline> h = home.findByCategoryId("40284bd33d249e82013d249e84730002", 0, 10);
//    	System.out.println(h.size()+"hello");
//    	assertNotNull(h);
//    }
    
    
    public void testGetCountOffindByCategoryId(){
    	log.info("testFindByCategoryId() called.");
    	assertTrue( home.getCountOffindByCategoryId("40284bd33d249e82013d249e84730002")==2);
    }
    
    
    
}
