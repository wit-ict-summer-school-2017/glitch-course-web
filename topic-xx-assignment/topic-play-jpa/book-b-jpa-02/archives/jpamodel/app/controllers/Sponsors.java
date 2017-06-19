package controllers;

import java.util.List;

import models.Club;
import models.Division;
import models.Sponsor;
import play.mvc.Controller;

public class Sponsors extends Controller
{      
  public static void index()
  {
    List<Sponsor> sponsors = Sponsor.findAll();
    render (sponsors);
  }
  
  public static void delete(Long id)
  {
    Sponsor sponsor = Sponsor.findById(id);
    
    for (Club club  : sponsor.support)
    {
      club.sponsors.remove(sponsor);
      club.save();
    }
    
    sponsor.delete();
    index();
  }  
  
}
