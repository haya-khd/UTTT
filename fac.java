package sopra;

import sopra.game.Position;
import sopra.Creature.*;

public class EntityFactory {

  /**
   * Create an Enemy on Position location
   * @param e the new EnemyType
   * @param location  the Position of the new Enemy
   * @param level Enemy's level
   * @param name  Enemy's name
   * @param d the sides number from a Dice
   * @return Enemy
   */

  public static Enemy createEnemy(EnemyType e, Position location, int level, String name, Dice d){
    throw new UnsupportedOperationException("Not yet implemented");
  }

  /**
   * Create a Door in the given Position
   * @param target the Position of the Door
   * @param level Door's level
   * @return Door
   */
  public static Door createDoor (Position target,  int level){
    throw new UnsupportedOperationException("Not yet implemented");
  }

  /**
   * Create a Chest at the given Position
   * @param location  Chest postion
   * @param level Chest's level
   * @return Chest
   */
  public static Chest createChest (Position location, int level){
    throw new UnsupportedOperationException("Not yet implemented");
  }

  /**
   * create an Armour at the given Position
   * @param location  Armour's position
   * @param name  Armour's Name
   * @param level Armour's level
   * @return Armour
   */
  public static Armour createArmour (Position location, String name,  int level){
    throw new UnsupportedOperationException("Not yet implemented");
  }

  /**
   * Create a Weapon at the given Position
   * @param location Weapon's position
   * @param name  Weapon's name
   * @param level Weapon's level
   * @param range Weapon's range
   * @return  Weapon
   */
  public static Weapon createWeapon ( Position location,String name, int level, int range){
    throw new UnsupportedOperationException("Not yet implemented");
  }

  /**
   * Create a Potion in the given position
   * @param location  Potion's position
   * @param level Potion's level
   * @return Potion
   */
  public static Potion createPotion (Position location, int level){
    throw new UnsupportedOperationException("Not yet implemented");
  }

  /**
   * Create a Decoction in the given position
   * @param location Decoction's position
   * @param str Strength Effect
   * @param vit Vitality Effect
   * @param agi Agility Effect
   * @param luck Luck Effect
   * @return Decoction
   */
  public static Decoction createDecoction (Position location, int str, int vit, int agi, int luck){
    throw new UnsupportedOperationException("Not yet implemented");
  }

  /**
   * Create a Swordpart at the given Position
   * @param location Swordpart's position
   * @param name Swordpart's name
   * @return Swordpart
   */
  public static Swordpart createSwordpart (Position location, String name){
    throw new UnsupportedOperationException("Not yet implemented");
  }

  /**
   * Create an Effect
   * @param d
   * @param roundsleft
   * @return Effect
   */
  public static Effect createEffect (Decoction d, int roundsleft){
    throw new UnsupportedOperationException("Not yet implemented");
  }

  /**
   * Copy an Entity
   * @param e Entity that we need to copy
   * @return Entity
   */
  public static Entity copyEntity (Entity e){
    throw new UnsupportedOperationException("Not yet implemented");
  }
}
