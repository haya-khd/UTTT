package sopra.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.*;
import org.skyscreamer.jsonassert.JSONParser;


import sopra.creature.*;

public class JSONHandler {
  public Map ParseMap(String map, Game game){
    throw new UnsupportedOperationException("Not yet implemented");

  }
  private Room ParseRoome(String room){
    JSONObject RoomObj= new JSONObject(room);
    String name = RoomObj.getString("name");
    int level = RoomObj.getInt("level");
     JSONArray tiles= RoomObj.getJSONArray("tiles");
     HashSet<Position> Fields= new HashSet<Position>();
     JSONObject a;
    for(int i=0; i< tiles.length(); i++){
      a= tiles.getJSONObject(i);
      Fields.add(parsePosition(a));
    }

    throw new UnsupportedOperationException("Not yet implemented");

  }
  private Position parsePosition(JSONObject position){
    //JSONObject PositonObj= new JSONObject(position);
    int x= position.getInt("x");
    int y= position.getInt("y");
    int z= position.getInt("z");
    return new Position(x,y,z);
  }
  private HashMap<Position, Entity> parseEntities(String entities){
    JSONObject EntityObj = new JSONObject(entities);
    String representation = EntityObj.getString("representation");
    Position pos= parsePosition(EntityObj.getJSONObject("position"));
    String objectType= EntityObj.getString("objectType");



    throw new UnsupportedOperationException("Not yet implemented");

  }
  private Player parsePlayer(String player, Position pos, char rep){
    JSONObject obj = new JSONObject(player);
    String name= obj.getJSONObject("player").getString("name");
    int level= obj.getJSONObject("player").getInt("level");
    int experience= obj.getJSONObject("player").getInt("experience");
    int skillPoints= obj.getJSONObject("player").getInt("skillPoints");
    int maxHealth= obj.getJSONObject("player").getInt("maxHealth");
    int currentHealth= obj.getJSONObject("player").getInt("currentHealth");
    int strength= obj.getJSONObject("player").getInt("strength");
    int vitality= obj.getJSONObject("player").getInt("vitality");
    int agility= obj.getJSONObject("player").getInt("agility");
    int luck= obj.getJSONObject("player").getInt("luck");
    Weapon weapon = parseWeapon(obj.getJSONObject("weapon"));
    Armor armor = parseArmour(obj.getJSONObject("armour"));
    Player p= new Player(pos,name, level, experience, skillPoints, maxHealth, currentHealth, strength, vitality, agility, luck, weapon, armor. rep);
    return  p;
  }
  private Enemy parseEnemy(String enemy){
    JSONObject EnemyObj= new JSONObject(enemy);
    String type= EnemyObj.getJSONObject("monster").getString("type");
    String name= EnemyObj.getJSONObject("monster").getString("name");
    int level= EnemyObj.getJSONObject("monster").getInt("level");
    int currentHealth= EnemyObj.getJSONObject("monster").getInt("currentHealth");
    int strength= EnemyObj.getJSONObject("monster").getInt("strength");
    int vitality= EnemyObj.getJSONObject("monster").getInt("vitality");
    int agility= EnemyObj.getJSONObject("monster").getInt("agility");

    throw new UnsupportedOperationException("Not yet implemented");
  }
  private Door parseDoor(String door){
    JSONObject DoorObj= new JSONObject(door);
    int level= DoorObj.getJSONObject("door").getInt("level");
    //getting Positin
    Map position = ((Map) DoorObj.get("destination"));

    int x= (int) position.get("x");
    int y= (int) position.get("y");
    int z= (int) position.get("z");
    Position target= new Position(x, y, z);
    Door newDoor= new Door(level, target);
   return newDoor;
  }
  private Weapon parseWeapon(String weapon){
    JSONObject WeaponObj= new JSONObject(weapon);
    String name= WeaponObj.getJSONObject("weapon").getString("name");
    int level= WeaponObj.getJSONObject("weapon").getInt("level");
    int range= WeaponObj.getJSONObject("weapon").getInt("range");

    throw new UnsupportedOperationException("Not yet implemented");
  }
  private Armour parseArmour(String armour){
    JSONObject ArmourObj= new JSONObject(armour);
    String name= ArmourObj.getJSONObject("armour").getString("name");
    int level= ArmourObj.getJSONObject("armour").getInt("level");

    throw new UnsupportedOperationException("Not yet implemented");
  }
  private Potion parsePotion(String potion){
    JSONObject PotionObj= new JSONObject(potion);
    int stackSize= PotionObj.getJSONObject("potion").getInt("stackSize");
    int level= PotionObj.getJSONObject("potion").getInt("level");
    throw new UnsupportedOperationException("Not yet implemented");
  }
  private Decoction parseDecoction(String decoction){
    JSONObject DecoctionObj= new JSONObject(decoction);
    int stackSize= DecoctionObj.getJSONObject("decoction").getInt("stackSize");
    int strength=DecoctionObj.getJSONObject("decoction").getInt("strength");
    int vitality= DecoctionObj.getJSONObject("decoction").getInt("vitality");
    int agility= DecoctionObj.getJSONObject("decoction").getInt("agility");
    int luck=DecoctionObj.getJSONObject("decoction").getInt("luck");

    throw new UnsupportedOperationException("Not yet implemented");
  }
  private Chest parseChest(String chest){
    JSONObject ChestObj= new JSONObject(chest);
    int level= ChestObj.getJSONObject("chest").getInt("level");
    throw new UnsupportedOperationException("Not yet implemented");
  }
  private Swordpart parseSwordpart(String swordPart){
    JSONObject SwordPartObj= new JSONObject(swordPart);
    int stackSize= SwordPartObj.getJSONObject("swordPart").getInt("stackSize");
    throw new UnsupportedOperationException("Not yet implemented");
  }
  private String  createWeaponJSon(Weapon w){
    JSONObject WeaponJSON= new JSONObject();
    WeaponJSON.put("name", w.getName());
    WeaponJSON.put("level", w.getLevel());
    WeaponJSON.put("range", w.getRange());

    return WeaponJSON.toString();

  }
  private String  createArmorJSon(Armour armor){
    JSONObject ArmorJSON= new JSONObject();
    ArmorJSON.put("name", armor.getName());
    ArmorJSON.put("level", armor.getLevel());

    return ArmorJSON.toString();

  }

  public static String createUpdatedField(Position pos, String representation){
    throw new UnsupportedOperationException("Not yet implemented");
  }
  public String createPlayerJSON (Player p){
    JSONObject PlayerJSON= new JSONObject();
    //nur als beispiel
    PlayerJSON.put("name", p.getName());
    PlayerJSON.put("level", p.getLevel());
    PlayerJSON.put("experience", p.getXP());
    PlayerJSON.put("skillPoints", p.getSkillPoints());
    PlayerJSON.put("maxHealth", p.getMaxHealth());
    PlayerJSON.put("currentHealth", p.getCurrentHealth());
    PlayerJSON.put("strength", p.getStrength());
    PlayerJSON.put("vitality", p.getVitality());
    PlayerJSON.put("agility", p.getAgility());
    PlayerJSON.put("luck", p.getLuck());
    PlayerJSON.put("weapon", createWeaponJSon(p.getWeapon()));
    PlayerJSON.put("armor", createArmorJSon(p.getArmour()));

    return PlayerJSON.toString();
  }
  /**public String createInventory(Player p){

    throw new UnsupportedOperationException("Not yet implemented");
  }
   **/
  public String createSkillsJSON(Player p){
    throw new UnsupportedOperationException("Not yet implemented");

  }


}
