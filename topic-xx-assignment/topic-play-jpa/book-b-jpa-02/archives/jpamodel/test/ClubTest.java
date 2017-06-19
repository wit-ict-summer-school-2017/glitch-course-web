import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;

public class ClubTest extends UnitTest 
{
  private Club c1, c2, c3;
  private Player p1, p2, p3;
  
  @Before
  public void setup()
  {
    p1 = new Player("mike");
    p2 = new Player("jim");
    p3 = new Player("frank");
    c1 = new Club("tramore");
    c2 = new Club("dunmore");
    c3 = new Club("fenor");
    
    c1.addPlayer(p1);
    c1.addPlayer(p2);
    
    c1.save();
    c2.save();
    c3.save();
  }
  
  @After
  public void teardown()
  {
    c1.delete();
    c2.delete();
    c3.delete();
  }

  @Test
  public void testCreate()
  {
    Club a = Club.findByName("tramore");
    assertNotNull(a);
    assertEquals("tramore", a.name);
    Club b = Club.findByName("dunmore");
    assertNotNull(b);
    assertEquals("dunmore", b.name);
    Club c = Club.findByName("fenor");
    assertNotNull(c);
    assertEquals("fenor", c.name);
  }
  
  @Test
  public void testNotThere()
  {
    Club a = Club.findByName("george");
    assertNull(a);
  }
    
  @Test
  public void testPlayers()
  {
    Club tramore = Club.findByName("tramore");
    
    assertEquals (2, tramore.players.size());
    
    Player mike  = Player.findByName("mike");
    Player jim   = Player.findByName("jim");
    Player frank = Player.findByName("framk");
    
    assertTrue  (tramore.players.contains(mike));
    assertTrue  (tramore.players.contains(jim));
    assertFalse (tramore.players.contains(frank));
  }  
  
  @Test
  public void testRemovePlayer()
  {
    Club tramore = Club.findByName("tramore");
    assertEquals(2, tramore.players.size());
    
    Player mike  = Player.findByName("mike");
    assertTrue(tramore.players.contains(mike));
    tramore.players.remove(mike);
    tramore.save();
    
    Club c = Club.findByName("tramore");
    assertEquals(1, c.players.size());
    
    mike.delete();
  } 
  
  @Test
  public void testPlayerClub()
  {
    Player mike  = Player.findByName("mike");
    assertNotNull (mike.club);
    assertEquals ("tramore", mike.club.name);
  }
  
}