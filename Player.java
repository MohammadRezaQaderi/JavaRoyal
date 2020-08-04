import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Class Have information and how to play for player
 *
 * @author mohammad reza Qaderi
 * @version 1.0
 */
public class Player {
    // The player Name
    private String nickName;
    // The player Money
    public int Money;
    // The player Win Strick ( the Wins much )
    public int WinStrick;
    // The Total Win is the Win of game ( destroy the Central State )
    public int TotalWin;
    private int T = 0;
    private int N = 0;
    // The player State At Start of the Game ( first player 0 and second player 1 )
    private int Num;
    // The State of map
    String[] strings = new String[9];
    // The player All Defencive Enemy
    ArrayList<Ammo> wall = new ArrayList<>();
    // The player All Irruptive Enemy
    ArrayList<Ammo> list = new ArrayList<>();
    Map map = new Map();

    /**
     * Set the Map for Game At the first of  the game
     *
     * @param Num the player State of Game
     */
    public Player(int Num, int MoneyFactor) {
        for (int i = 0; i < 9; i++) {
            strings[i] = String.valueOf(i) + "  ";
        }
        DAammo dAammo = new DAammo();
        for (Ammo ammo1 : dAammo.Dammo) {
            if (ammo1.getCode().equals("C")) {
                ammo1.setHome(4);
                this.wall.add(ammo1);
            }
        }
        strings[4] = "4-C";
        Money = 500 * MoneyFactor;
        this.Num = Num;
    }


    /**
     * Get the Total win of player
     *
     * @return the total win of player
     */
    public int getTotalWin() {
        return TotalWin;
    }

    /**
     * Set the Total Win (when central State destroy)
     *
     * @param totalWin (when central State destroy)
     */
    public void setTotalWin(int totalWin) {
        TotalWin = totalWin;
    }

    /**
     * Get the win strick of Player
     *
     * @return winstrick
     */
    public int getWinStrick() {
        return WinStrick;
    }

    /**
     * set the Win Player
     *
     * @param winStrick of Player
     */
    public void setWinStrick(int winStrick) {
        WinStrick = winStrick;
    }

    /**
     * Get number of Player
     *
     * @return number of Player
     */
    public int getNum() {
        return Num;
    }

    /**
     * Get name for Player
     *
     * @return name of Player
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Set the Name of Player
     *
     * @param nickName name of Player
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Get the money
     *
     * @return of Player
     */
    public int getMoney() {
        return Money;
    }

    /**
     * Set the money for Player
     *
     * @param money of the Player
     */
    public void setMoney(int money) {
        Money = money;
    }

    /**
     * Set the Defencive Player For The Map of the Player
     * The Player Could`t Set Defencive Enemy in 4 place of map
     * The Player Can Repair the Enemy With " R "
     * For See Enemy Access Enemy See DAammo Class
     *
     * @param player The Player That Want to Set him map
     */
    public void PresentMap(Player player) {
        int m = 0;
        while (m == 0) {
            if (player.T == 0) {
                System.out.println("Buildings Present :None.");
                System.out.println("Enter your building expression:");
                Scanner scanner = new Scanner(System.in);
                String[] s = scanner.nextLine().split(" ", 2);
                if (Integer.parseInt(s[1]) == 4) {
                    System.out.println("You Can`t Edit it");
                }
                if (Integer.parseInt(s[1]) > 9)
                    System.out.println("Wrong Home !!");
                else {
                    if (player.CheckDMoney(player, s[0])) {
                        DAammo dAammo = new DAammo();
                        for (Ammo ammo : dAammo.Dammo) {
                            if (s[0].equals(ammo.getCode())) {
                                strings[Integer.parseInt(s[1])] = s[1] + "-" + s[0];
                                player.T++;
                                ammo.setHome(Integer.parseInt(s[1]));
                                wall.add(ammo);
                            }
                        }

                    }
                }
            } else {
                int a = 0;
                while (a == 0) {
                    System.out.println("Buildings Present :");
                    for (Ammo ammo : player.wall) {
                        if (ammo.getNowHP() != 0)
                            System.out.println("[" + ammo.getHome() + "]" + " : " + ammo.getName() + " : " + ammo.getNowHP() + " / " + ammo.getHP());
                    }
                    System.out.println("Enter your building expression:");
                    Scanner scanner = new Scanner(System.in);
                    String Count = scanner.nextLine();
                    if (Count.equals("back")) {
                        a++;
                        m++;
                    } else if (Count.equals("R")) {
                        System.out.println(player.getMoney());
                        Scanner scanner1 = new Scanner(System.in);
                        String Count1 = scanner1.nextLine();
                        String[] s1 = Count1.split(" ", 2);
                        for (int i = 0; i < player.wall.size(); i++) {
                            String[] strings1 = strings[Integer.parseInt(s1[1])].split("-");
                            if (player.wall.get(i).getCode().equals(strings1[1])) {
                                if (player.wall.get(i).getNowHP() < player.wall.get(i).getHP()) {
                                    if (player.CheckDMoney(player, s1[0])) {
                                        player.wall.get(i).setNowHP(player.wall.get(i).getHP());
                                        break;
                                    } else {
                                        System.out.println(player.wall.get(i).getName() + "  " + player.wall.get(i).getHP() + "   " + player.getMoney());
                                        System.out.println("You Don`t have Enough Money");
                                        break;
                                    }
                                } else {
                                    System.out.println("It Dose not to be Repair");
                                    break;
                                }
                            } /*else {
                                System.out.println("You Don`t have This Enemy Here");
                                break;
                            }*/
                        }
                    } else {
                        String[] s = Count.split(" ", 2);
                        if (Integer.parseInt(s[1]) == 4) {
                            System.out.println("You Can`t Edit it");
                        }
                        if (Integer.parseInt(s[1]) > 9)
                            System.out.println("Wrong Home !!");
                        else {
                            if (player.CheckDMoney(player, s[0])) {
                                DAammo dAammo = new DAammo();
                                for (Ammo ammo : dAammo.Dammo) {
                                    if (s[0].equals(ammo.getCode())) {
                                        strings[Integer.parseInt(s[1])] = s[1] + "-" + s[0];
                                        ammo.setHome(Integer.parseInt(s[1]));
                                        wall.add(ammo);
                                    }
                                }
                            } else {
                                System.out.println("You Don`t have Enough Money");
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Check The Money Of Player To Buy Some thing
     *
     * @param player   Player How want to Buy Some Thing
     * @param AmmoCode The Code of Enemy That Want To buy
     * @return (True if Player Can buy and False if he Can ` t)
     */
    public boolean CheckDMoney(Player player, String AmmoCode) {
        DAammo dAammo = new DAammo();
        for (Ammo dammo : dAammo.Dammo)
            if (dammo.getCode().equals(AmmoCode)) {
                System.out.println(player.getMoney());
                if (player.getMoney() >= dammo.getPrice()) {
                    int C = player.getMoney() - dammo.getPrice();
                    player.setMoney(C);
                    return true;
                }
                break;
            }
        return false;
    }

    /**
     * Check The Money Of Player To Buy Some thing
     *
     * @param player   Player How want to Buy Some Thing
     * @param AmmoCode The Code of Enemy That Want To buy
     * @param Num      the Number of Enemy want to Buy
     * @return (True if Player Can buy and False if he Can ` t)
     */
    public boolean CheckAMoney(Player player, String AmmoCode, int Num) {
        DAammo dAammo = new DAammo();
        for (Ammo dammo : dAammo.Aammo)
            if (dammo.getCode().equals(AmmoCode)) {
                if (player.getMoney() >= (dammo.getPrice() * Num)) {
                    int C = player.getMoney() - (dammo.getPrice() * Num);
                    player.setMoney(C);
                    return true;
                }
                break;
            }
        return false;
    }

    /**
     * Set the Irruptive Player For The Map of the Player
     * For See Enemy Access Enemy See AAammo Class
     *
     * @param player The Player That Want to Set him map
     */
    public void TroopsArmy(Player player) {
        int m = 0;
        while (m == 0) {
            if (player.N == 0) {
                System.out.println("Troops available in your army: None.");
                System.out.println("Enter your troops expression:");
                Scanner scanner = new Scanner(System.in);
                String Count = scanner.nextLine();
                String[] S = Count.split(" ", 2);
                if (player.CheckAMoney(player, S[0], Integer.parseInt(S[1]))) {
                    for (int i = 0; i < Integer.parseInt(S[1]); i++) {
                        DAammo dAammo = new DAammo();
                        for (Ammo ammo : dAammo.Aammo) {
                            if (S[0].equals(ammo.getCode())) {
                                ammo.setMuch(1);
                                list.add(ammo);
                            }
                            N++;
                        }
                    }
                } else {
                    System.out.println("You Don`t have Enough Money");
                }


            } else {
                int a = 0;
                while (a == 0) {
                    System.out.println("Troops available in your army :");
                    int s = 0, T = 0, F = 0;
                    for (int i = 0; i < player.list.size(); i++) {
                        if (player.list.get(i).getCode().equals("S"))
                            s++;
                        if (player.list.get(i).getCode().equals("T"))
                            T++;
                        if (player.list.get(i).getCode().equals("F"))
                            F++;
                    }
                    if (s != 0)
                        System.out.println("Afoot Soldier" + " : " + s);
                    if (T != 0)
                        System.out.println("Abrams Tanks" + " : " + T);
                    if (F != 0)
                        System.out.println("F 22 Raptor" + " : " + F);
                    System.out.println("Enter your troops expression:");
                    Scanner scanner = new Scanner(System.in);
                    String Count = scanner.nextLine();
                    String[] S = Count.split(" ", 2);
                    if (Count.equals("back")) {
                        a++;
                        m++;
                    } else {
                        if (player.CheckAMoney(player, S[0], Integer.parseInt(S[1]))) {
                            for (int i = 0; i < Integer.parseInt(S[1]); i++) {
                                DAammo dAammo = new DAammo();
                                for (Ammo ammo : dAammo.Aammo) {
                                    if (S[0].equals(ammo.getCode())) {
                                        ammo.setMuch(1);
                                        list.add(ammo);
                                    }
                                    N++;
                                }
                            }
                        } else {
                            System.out.println("You Don`t have Enough Money");
                        }
                    }

                }
            }
        }
    }

    /**
     * Show The Map Of player And Defencive And Irruptive Enemy that Have
     *
     * @param player player that want to show Map and Army
     */

    public void ShowMapAndArmy(Player player) {
        map.Map(player);
        System.out.println("Buildings Present :");
        for (Ammo ammo : player.wall) {
            if (ammo.getNowHP() != 0)
                System.out.println("[" + ammo.getHome() + "]" + " : " + ammo.getName() + " : " + ammo.getNowHP() + " / " + ammo.getHP());
        }
        System.out.println("Troops available in your army :");
        int S = 0, T = 0, F = 0;
        for (int i = 0; i < player.list.size(); i++) {
            if (player.list.get(i).getCode().equals("S"))
                S++;
            if (player.list.get(i).getCode().equals("T"))
                T++;
            if (player.list.get(i).getCode().equals("F"))
                F++;
        }
        if (S != 0)
            System.out.println("Afoot Soldier" + " : " + S);
        if (T != 0)
            System.out.println("Abrams Tanks" + " : " + T);
        if (F != 0)
            System.out.println("F 22 Raptor" + " : " + F);
    }

}
