package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Club extends Model
{
  public String name;
  
  @OneToMany(mappedBy="club", cascade=CascadeType.ALL)
  public List<Player> players;

  @ManyToMany
  public List<Sponsor> sponsors;
  
  
  public Club(String name)
  {
    this.name = name;
    this.players = new ArrayList<Player>();
  }
  
  public String toString()
  {
    return name;
  }
  
  public void addPlayer(Player player)
  {
    player.club = this;
    players.add(player);
  }
  
  public void addSponsor(Sponsor company)
  {
    sponsors.add(company);  
  }
  
  public void removePlayer(Player player)
  {
    players.remove(player);
  }
  
  public static Club findByName(String name)
  {
    return find("name", name).first();
  }   
}
