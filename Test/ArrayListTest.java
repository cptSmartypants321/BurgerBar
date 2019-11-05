package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utility.collection.ArrayList;

import static junit.framework.TestCase.*;

public class ArrayListTest {
    private ArrayList<String> t;

    @Before
    public void setUp() throws Exception {
         t=new ArrayList();
    }

    @After
    public void tearDown() throws Exception {
        for(int i=0;i<t.size();i++)
        {
            t.remove(i);
        }
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void add() {
        t.add(0,"A");
        assertEquals(1,t.size());
         t.add(1,"C");
        t.add(1,"A1");
        assertTrue(t.contains("A1"));
        t.add(2,"D");
        t.add(35,"E");
        assertEquals(4,t.size());
        assertTrue(t.contains("E"));
        t.add(99,"F");
        t.add(100,"G");
        assertEquals(100,t.indexOf("G"));
        assertTrue(t.contains("F"));
        t.add(-1,"B");
    }

    @Test
    public void testAdd() {
        for(int i=0;i<102;i++)
        {
            t.add(""+i);
        }
        assertTrue(t.contains(""+0));
        assertTrue(t.contains(""+99));
        assertTrue(t.contains(""+100));
        assertTrue(t.contains(""+101));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void set() {
        t.set(-1,"A");
        assertFalse(t.contains("A"));
        for(int i=0;i<102;i++)
        {
            t.add(""+i);
        }
        assertTrue(t.contains(""+0));
        assertTrue(t.contains(""+1));
        assertTrue(t.contains(""+99));
        assertTrue(t.contains(""+100));
        assertTrue(t.contains(""+101));

    }

    @Test  (expected = IllegalStateException.class)
    public void get() {
        t.add(0,"A");
        t.add(1,"B");
        t.add(2,"C");
        t.get(-1);
        assertEquals("A",t.get(0));
        assertEquals("C",t.get(2));
        t.add(4,"D");
        assertEquals(4,t.indexOf("D"));
        assertEquals(null,t.get(3));

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void remove() {
        t.add("A");
        t.add("B");
        t.add("C");
        t.add("D");
       String test= t.remove(3);
       assertEquals("D",test);
       assertFalse(t.contains("D"));
        t.add("E");
        t.add("F");
        t.add("G");
        t.add("H");
        t.add("J");
        t.add("K");
        t.add("L");
        assertEquals(10,t.size());
        assertEquals(t.get(9),"L");
        t.remove(10);

    }

    @Test (expected = IllegalStateException.class)
    public void testRemove() {
        t.add("A");
        t.remove("A");
        assertFalse(t.contains("A"));
        t.add("B");
        t.add("C");
        t.add("D");
        t.add("E");
        t.add("F");
        t.add("G");
        t.add("H");
        assertEquals(7,t.size());
        assertEquals(0,t.indexOf("B"));
        t.remove("A");
        t.remove("W");
    }

    @Test
    public void indexOf() {
        t.add("A");
        t.add("B");
        t.add("C");
        t.add("D");
        t.add("E");
        t.add("F");
        t.add(6,"G");
        assertEquals(0,t.indexOf("A"));
        assertEquals(6,t.indexOf("G"));


    }
    @Test (expected= IndexOutOfBoundsException.class)
    public void contains() {
        for(int i=0;i<101;i++)
        {
            t.add("i"+i);
        }
        assertTrue(t.contains("i0"));
        assertTrue(t.contains("i1"));
        assertTrue(t.contains("i9"));
        assertTrue(t.contains("i10"));
        assertTrue(t.contains("i11"));
        assertTrue(t.contains("i15"));
        assertTrue(t.contains("i16"));
        assertTrue(t.contains("i17"));
        assertTrue(t.contains("i77"));
        assertTrue(t.contains("i99"));
        assertTrue(t.contains("i100"));
        t.add(-1,"i-1");
        assertFalse(t.contains("i-1"));
    }

    @Test
    public void isEmpty() {
        assertTrue(t.isEmpty());
        t.add(null);
        assertFalse(t.isEmpty());
    }

    @Test
    public void isFull() {
        assertTrue(t.isFull());
        t.add("A");
        t.add("B");
        t.add("C");
        assertTrue(t.isFull());
    }

    @Test
    public void size() {
        assertEquals(0,t.size());
        t.add("i");
        assertEquals(1,t.size());
        for(int i=0;i<100;i++)
        {
            t.add("i"+i);
        }
        assertEquals(101,t.size());
    }

    @Test
    public void testToString() {
        t.add("A");
        t.add("B");
        t.add("C");
        assertEquals("{A, B, C}",t.toString());
        t.add(null);
        assertEquals("{A, B, C, null}",t.toString());
    }
}