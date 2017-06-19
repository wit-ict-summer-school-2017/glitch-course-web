package controllers;

import java.util.List;

import models.Player;
import play.mvc.Controller;

public class Players extends Controller
{      
  public static void index()
  {
    List<Player> players = Player.findAll();
    render (players);
  }
  
  public static void delete(Long id)
  {
    Player player = Player.findById(id);
    if (player != null)
    {
      if (player.club != null)
      {
        player.club.removePlayer(player);
        player.club.save();
      }
      player.delete();
    }
    index();
  }
  
  public static void addPlayer()
  {
    render();
  }

  public static void newPlayer(String name)
  {
    Player player = new Player (name);
    player.save();
    index();
  }
}
