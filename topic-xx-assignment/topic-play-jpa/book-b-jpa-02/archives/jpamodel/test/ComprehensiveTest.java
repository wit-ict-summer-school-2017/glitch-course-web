import org.junit.*;

import java.util.*;

import play.Logger;
import play.test.*;
import models.*;
 
public class ComprehensiveTest extends UnitTest
{
  public static void loadSponsorships()
  {
    Club    tramore   = Club.find("byName", "tramore").first();
    Club    dunmore   = Club.find("byName", "dunmore").first();
    Sponsor newsagent = Sponsor.find("byName", "newsagent").first();

    tramore.addSponsor(newsagent);
    dunmore.addSponsor(newsagent);

    newsagent.addSuport(tramore);
    newsagent.addSuport(dunmore);

    tramore.save();
    dunmore.save();
    newsagent.save();
  }

  @Before
  public void setup()
  {
    Fixtures.loadModels("data.yml");
    loadSponsorships();
  }

  @After
  public void teardown()
  {
    Fixtures.deleteAllModels();
  }

  @Test
  public void testPlayerClubLong()
  {
    Player jim;
    Club   dunmore;

    jim = Player.find("byName", "jim").first();
    assertNotNull(jim);
    assertEquals(jim.name, "jim");

    dunmore = jim.club;
    assertEquals("dunmore", dunmore.name);

    dunmore = Club.find("byName", "dunmore").first();
    assertNotNull(dunmore);
    assertEquals("dunmore", dunmore.name);    
    assertEquals(2, dunmore.players.size());

    Player p1 = dunmore.players.get(0);
    assertTrue (p1.name.equals("jim") || p1.name.equals("mary"));
    Player p2 = dunmore.players.get(1);
    assertTrue (p2.name.equals("jim") || p2.name.equals("mary"));  
  }

  @Test
  public void testDivisionClubLong()
  {
    Division senior = Division.find("byName", "senior").first();
    assertNotNull(senior);
    assertEquals(2, senior.members.size());

    Club c1 = senior.members.get(0);
    Club c2  = senior.members.get(1);

    assertTrue (c1.name.equals("tramore") || c1.name.equals("dunmore"));      
    assertTrue (c2.name.equals("tramore") || c2.name.equals("dunmore"));          
  }


  //----------------------------------------------------------------------
  @Test
  public void testPlayerClub()
  {
    Club   dunmore = Club.find("byName", "dunmore").first();
    Player jim     = Player.find("byName", "jim").first(); 
    Player mary    = Player.find("byName", "mary").first(); 
    assertNotNull(mary);

    assertTrue (dunmore.players.contains(jim));
    assertTrue (dunmore.players.contains(mary)); 
  }

  @Test
  public void testDivisionClub()
  {
    Division senior  = Division.find("byName", "senior").first();
    Club     dunmore = Club.find("byName", "dunmore").first();
    Club     tramore = Club.find("byName", "tramore").first();

    assertTrue (senior.members.contains(dunmore));
    assertTrue (senior.members.contains(tramore));
  }

  @Test
  public void testClubSponsorShort()
  {
    Sponsor  newsagent = Sponsor.find("byName", "newsagent").first();
    Club     dunmore   = Club.find("byName", "dunmore").first();
    Club     tramore   = Club.find("byName", "tramore").first();

    assertTrue(newsagent.support.contains(dunmore));
    assertTrue(newsagent.support.contains(tramore));

    assertTrue(dunmore.sponsors.contains(newsagent));
    assertTrue(tramore.sponsors.contains(newsagent));
  }

  @Test
  public void testEditPlayerClub()
  {
    Club   dunmore = Club.find("byName", "dunmore").first();
    Player jim     = Player.find("byName", "jim").first(); 
    Player mary    = Player.find("byName", "mary").first();

    dunmore.players.remove(mary);
    mary.delete();
    dunmore.save();

    assertEquals (dunmore.players.size(), 1);
    assertTrue (dunmore.players.contains(jim));

    assertEquals(0, Player.find("byName", "mary").fetch().size());

    Player sara     = new Player("sara");
    dunmore.addPlayer(sara);
    dunmore.save();
    assertEquals (dunmore.players.size(), 2);    
  }

  @Test
  public void testEditClubSponsor()
  {
    Sponsor  newsagent = Sponsor.find("byName", "newsagent").first();
    Club     dunmore   = Club.find("byName", "dunmore").first();

    assertEquals(2, newsagent.support.size());  

    newsagent.support.remove(dunmore);
    dunmore.sponsors.remove(newsagent);

    newsagent.save();
    dunmore.save();

    assertEquals(1, newsagent.support.size());  
  }
}