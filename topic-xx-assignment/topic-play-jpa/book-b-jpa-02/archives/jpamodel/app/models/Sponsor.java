package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Sponsor extends Model
{
  public String name;
  
  @ManyToMany (mappedBy="sponsors")
  public List<Club> support;
  
  public Sponsor(String name)
  {
    this.name = name;
    support = new ArrayList<Club>();
  }
  
  public void addSuport(Club club)
  {
    support.add(club);
  }
  
  public String toString()
  {
    return name;
  }
}
