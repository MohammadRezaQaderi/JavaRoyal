import java.util.ArrayList;

/**
 * This class want to separate the enemy to the tow array list Defencive and Irruptive
 * Set all name, code, HP,Damage and ...
 *
 * @author mohammad reza Qaderi
 * @version 1.0
 */
public class DAammo extends Ammo {
    // The Array List of Defencive Ammo
    ArrayList<Ammo> Dammo = new ArrayList<>();
    // The Array List of Attacked Ammo
    ArrayList<Ammo> Aammo = new ArrayList<>();
    Ammo Cammo = new Ammo();
    Ammo Tammo = new Ammo();
    Ammo Sammo = new Ammo();
    Ammo Bammo = new Ammo();
    Ammo ASammo = new Ammo();
    Ammo ATammo = new Ammo();
    Ammo AFammo = new Ammo();

    /**
     * Set all Army of the game And separate them to the tow array list Defencive and Irruptive
     */
    public DAammo() {
        Cammo.setCode("C");
        Cammo.setName("Central Command");
        Cammo.setDamage(0);
        Cammo.setHP(3000);
        Cammo.setPrice(3000);
        Cammo.setNowHP(3000);
        Dammo.add(Cammo);
        Tammo.setCode("T");
        Tammo.setName("106 mm Gun");
        Tammo.setHP(500);
        Tammo.setDamage(300);
        Tammo.setPrice(200);
        Tammo.setNowHP(500);
        Dammo.add(Tammo);
        Sammo.setCode("S");
        Sammo.setName("S 300");
        Sammo.setHP(500);
        Sammo.setDamage(500);
        Sammo.setPrice(300);
        Sammo.setNowHP(500);
        Dammo.add(Sammo);
        Bammo.setCode("B");
        Bammo.setName("Bomb Side Road");
        Bammo.setHP(1000);
        Bammo.setDamage(750);
        Bammo.setPrice(100);
        Bammo.setNowHP(1000);
        Dammo.add(Bammo);
        ASammo.setCode("S");
        ASammo.setName("Afoot Soldier");
        ASammo.setHP(10);
        ASammo.setDamage(10);
        ASammo.setPrice(100);
        ASammo.setNowHP(10);
        Aammo.add(ASammo);
        ATammo.setCode("T");
        ATammo.setName("Abrams Tanks");
        ATammo.setHP(100);
        ATammo.setDamage(100);
        ATammo.setPrice(400);
        ATammo.setNowHP(100);
        Aammo.add(ATammo);
        AFammo.setCode("F");
        AFammo.setName("F 22 Raptor");
        AFammo.setHP(50);
        AFammo.setDamage(250);
        AFammo.setPrice(800);
        AFammo.setNowHP(50);
        Aammo.add(AFammo);
    }

}
