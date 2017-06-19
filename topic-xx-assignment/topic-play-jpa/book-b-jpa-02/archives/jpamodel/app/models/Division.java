package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Division extends Model
{
  public String name;
  
  @OneToMany(cascade=CascadeType.ALL)
  public List<Club> members;
  
  public Division(String name)
  {
    this.name = name;
    members = new ArrayList<Club>();
  } 
  
  public void addClub(Club club)
  {
    members.add(club);
  }
  
  public String toString()
  {
    return name;
  }
  
  public static Division findByName(String name)
  {
    return find("name", name).first();
  }
}
