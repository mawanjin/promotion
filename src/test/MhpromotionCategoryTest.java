package test;


import java.util.HashSet;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.persist.dao.Mhpromotion;
import org.persist.dao.MhpromotionCategory;
import org.persist.dao.MhpromotionCategoryHome;
import org.persist.dao.MhpromotionHome;
import org.persist.dao.MhpromotionOnline;
import org.persist.dao.MhpromotionOnlineHome;

/**
 * Unit test for simple App.
 */
public class MhpromotionCategoryTest 
    extends TestCase
{
	Logger log = LogManager.getLogger(MhpromotionCategory.class.getName());
	MhpromotionCategoryHome home = new MhpromotionCategoryHome();
	MhpromotionHome<Mhpromotion> mHome = new MhpromotionHome<Mhpromotion>(Mhpromotion.class);
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MhpromotionCategoryTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MhpromotionCategoryTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void testPersist()
    {
//    	log.info("testPersist() called.");
//    	MhpromotionCategory mc = new MhpromotionCategory();
//    	mc.setName("test3");
//    	mc.setOnline(0);
//    	assertTrue(home.persist(mc));
    }
//    public void testFindById(){
//    	log.info("testFindById() called.");
//    	assertNotNull(home.findById("40284bd33d2004d6013d2004d8800004"));
//    }
    
//    public void testDelete(){
//    	log.info("testFindById() called.");
//    	
//    	assertTrue(home.delete(home.findById("40284bd33d2004d6013d2004d8800004")));
//    }
    
//    public void testMerge(){
//    	log.info("testMerge() called.");
//    	MhpromotionCategory mc = home.findById("40284bd33d200fc6013d200fc8100002");
//    	
//    	HashSet<Mhpromotion> ms = new HashSet<Mhpromotion>();
////    	ms.add(mHome.findById("402881843d1a83d9013d1a83dba20002"));
//    	mc.setMhpromotions(ms);
//    	home.merge(mc);
//    }
    
//    public void testFindByExample(){
//    	log.info("testFindByExample() called.");
//    	MhpromotionCategory instance = new MhpromotionCategory();
//    	List<MhpromotionCategory> mc = home.findByExample(instance);
//    	assertNotNull(mc);
//    	System.out.println("size="+mc.size()+";"+mc.get(0).getName());
//    }
    
//    public void testFindByExampleOrder(){
//    	log.info("testFindByExample() called.");
//    	MhpromotionCategory instance = new MhpromotionCategory();
//    	List<MhpromotionCategory> mc = home.findByExample(instance,"porder");
//    	assertNotNull(mc);
//    	System.out.println("size="+mc.size()+";"+mc.get(0).getName());
//    }
    
    public void getCountOfFindByExample(){
    	log.info("getCountOfFindByExample() called.");
    	MhpromotionCategory instance = new MhpromotionCategory();
    	long rs = home.getCountOfFindByExample(instance);
    	assertTrue(rs>0);
    	assertTrue(rs==5);
    }
    
    
}
