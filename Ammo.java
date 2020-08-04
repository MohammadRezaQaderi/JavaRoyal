/**
 * This Class Have The all information of the Enemy
 *
 * @author mohammad reza Qaderi
 * @version 1.0
 */
public class Ammo {
    // The Ammo Code
    private String code;
    // The Ammo Name
    private String name;
    // The Ammo Name
    private int HP;
    // The Ammo Name
    private int Damage;
    // The Ammo Price
    private int Price;
    // The Ammo NowHp
    private int NowHP;
    // The Ammo Home
    private int Home;
    // The Ammo Much(many of Ammo)
    private int Much;

    public Ammo() {

    }

    /**
     * Get the Many Of Ammo
     *
     * @return the many of ammo
     */
    public int getMuch() {
        return Much;
    }

    /**
     * Set the many of ammo
     *
     * @param much the number of ammo
     */
    public void setMuch(int much) {
        Much = much;
    }

    /**
     * Get the home of Ammo
     *
     * @return the Home Number
     */
    public int getHome() {
        return Home;
    }

    /**
     * Set the number of home ammo
     *
     * @param home Number of Ammo
     */
    public void setHome(int home) {
        Home = home;
    }

    /**
     * Get the NowHP Of Ammo
     *
     * @return the NowHP of ammo
     */
    public int getNowHP() {
        return NowHP;
    }

    /**
     * Set the NowHP of ammo
     *
     * @param NowHP Of ammo
     */
    public void setNowHP(int NowHP) {
        this.NowHP = NowHP;
    }

    /**
     * Get the Name Of Ammo
     *
     * @return the name of ammo
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of ammo
     *
     * @param name of ammo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the Code Of Ammo
     *
     * @return the code of ammo
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the Code of ammo
     *
     * @param code of ammo
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get the HP Of Ammo
     *
     * @return the HP of ammo
     */
    public int getHP() {
        return HP;
    }

    /**
     * Set the HP of ammo
     *
     * @param HP of ammo
     */
    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     * Get the Damage Of Ammo
     *
     * @return the Damage of ammo
     */
    public int getDamage() {
        return Damage;
    }

    /**
     * Set the Damage of ammo
     *
     * @param damage of ammo
     */
    public void setDamage(int damage) {
        Damage = damage;
    }

    /**
     * Get the Price Of Ammo
     *
     * @return the Price of ammo
     */
    public int getPrice() {
        return Price;
    }

    /**
     * Set the price of ammo
     *
     * @param price of ammo
     */
    public void setPrice(int price) {
        Price = price;
    }


}
