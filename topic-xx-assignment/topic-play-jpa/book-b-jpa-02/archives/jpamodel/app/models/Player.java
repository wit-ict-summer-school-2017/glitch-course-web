package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Player extends Model
{
  public String name;
  
  @ManyToOne
  public Club club;

  public Player(String name)
  {
    this.name = name;
  }
  
  public String toString()
  {
    return name;
  }
  
  public static Player findByName(String name)
  {
    return find("name", name).first();
  } 
}