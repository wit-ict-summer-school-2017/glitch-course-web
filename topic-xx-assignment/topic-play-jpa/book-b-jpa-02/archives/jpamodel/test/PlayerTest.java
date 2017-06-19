import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;

public class PlayerTest extends UnitTest 
{
  private Player p1, p2, p3;
  
  @Before
  public void setup()
  {
    p1 = new Player("mike");
    p2 = new Player("jim");
    p3 = new Player("frank");
    p1.save();
    p2.save();
    p3.save();
  }
  
  @After
  public void teardown()
  {
    p1.delete();
    p2.delete();
    p3.delete();
  }

  @Test
  public void testCreate()
  {
    Player a = Player.findByName("mike");
    assertNotNull(a);
    assertEquals("mike", a.name);
    Player b = Player.findByName("jim");
    assertNotNull(b);
    assertEquals("jim", b.name);
    Player c = Player.findByName("frank");
    assertNotNull(c);
    assertEquals("frank", c.name);
  }
  
  @Test
  public void testNotThere()
  {
    Player a = Player.findByName("george");
    assertNull(a);
  }
  
}
