package controllers;

import java.util.List;

import models.Division;
import models.Player;
import play.mvc.Controller;

public class Divisions extends Controller
{      
  public static void index()
  {
    List<Division> divisions = Division.findAll();     
    render (divisions);
  }
  
  public static void delete(Long id)
  {
    Division division = Division.findById(id);
    division.delete();
    index();
  }
}
