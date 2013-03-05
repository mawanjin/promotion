package test;


import java.util.HashSet;
import java.util.List;

import javax.ejb.FinderException;

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
import org.persist.dao.MhpromotionPic;
import org.persist.dao.MhpromotionPicHome;
import org.persist.dao.MhpromotionPicId;

/**
 * Unit test for simple App.
 */
public class MhpromotionPicTest 
    extends TestCase
{
	Logger log = LogManager.getLogger(MhpromotionCategory.class.getName());
	MhpromotionPicHome home = new MhpromotionPicHome();
	MhpromotionHome<Mhpromotion> mHome = new MhpromotionHome<Mhpromotion>(Mhpromotion.class);
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MhpromotionPicTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MhpromotionPicTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testFindByExample()
    {
    	log.info("testFindByExample() called.");
    	MhpromotionPic m = new MhpromotionPic();
    	MhpromotionPicId mpi = new MhpromotionPicId();
    	mpi.setId("402881843d1a84a9013d1a84ab750002");
    	m.setId(mpi);
    	List<MhpromotionPic> rs =  home.findByExample(m);
    	assertNotNull(rs);
    	System.out.println(rs.size());
    	System.out.println(rs.get(0).getId().getPic()+";"+rs.get(0).getPorder()+";"+rs.get(0).getType());
    	
    }
//    
//    public void testPersist()
//    {
//    	log.info("testPersist() called.");
//    	MhpromotionPic mp = new MhpromotionPic();
//    	mp.setId(new MhpromotionPicId("402881843d1a84a9013d1a84ab750002", "p1"));
//    	home.persist(mp);
//    }
//    public void testFindById(){
//    	log.info("testFindById() called.");
//    	assertNotNull(home.findById(new MhpromotionPicId("402881843d1a84a9013d1a84ab750002", "p1")));
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
    
    
}
