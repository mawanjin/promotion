package test;


import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.persist.dao.Mhpromotion;
import org.persist.dao.MhpromotionHome;

/**
 * Unit test for simple App.
 */
public class MhpromotionHomeTest 
    extends TestCase
{
	Logger log = LogManager.getLogger(MhpromotionHomeTest.class.getName());
	MhpromotionHome<Mhpromotion> home = new MhpromotionHome<Mhpromotion>(Mhpromotion.class);
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MhpromotionHomeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MhpromotionHomeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
//    public void testFindByExample()
//    {
//    	log.info("testFindByExample() called.");
//    	Mhpromotion instance = new Mhpromotion();
//    	List<Mhpromotion> ps = home.findByExample(instance);
//    	if(ps.size()>0){
//    		System.out.println(ps.get(0).getTitle()+";"+ps.size());
//    	}
//    	assertNotNull(ps);
//    }
    
//    public void testPersist()
//    {
//    	log.info("testPersist() called.");
//    	Mhpromotion instance = new Mhpromotion();
//    	
//    	instance.setTitle("good123");
//    	assertTrue(home.persist(instance));
//    }
//    
//    public void testFindById(){
//    	log.info("testFindById() called.");
//    	Mhpromotion h = home.findById("402881843d1aead2013d1aead42b0002");
//    	assertNotNull(h);
//    }
    
//    public void testFindById(){
//    	log.info("testFindById() called.");
//    	Mhpromotion t = new Mhpromotion();
//    	t.setId("1");
//    	System.out.println("kkk="+home.findById("1").getMhpromotionCategoryRef().getMhpromotionCategory().getName());
//    }
    public void testFindByCategoryId(){
    	log.info("testFindByCategoryId() called.");
    	List<Mhpromotion> rs = home.findByCategoryId("40284bd33d249e82013d249e84730002",1,10);
    	assertNotNull(rs);
    	System.out.println(rs.size());
    }
    
    public void testGetCountOfByCategoryId(){
    	log.info("testGetCountOfByCategoryId() called.");
    	assertTrue(home.getCountOfByCategoryId("40284bd33d249e82013d249e84730002")>0);
    }
    
    
    
    
    
}
