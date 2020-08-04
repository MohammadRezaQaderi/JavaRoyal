import java.util.Iterator;
import java.util.Scanner;

/**
 * This Class have the structure of the game to handel the game
 *
 * @author mohammad reza Qaderi
 * @version 1.0
 */
public class Play {
    Map map = new Map();
    Menu menu = new Menu();
    int count;
    //The Win Factor
    public int WinFactor;
    //The Lose Factor
    public int LoseFactor;
    Scanner scanner = new Scanner(System.in);

    public Play(int winFactor, int loseFactor) {
        WinFactor = winFactor;
        LoseFactor = loseFactor;
    }

    /**
     * At the beginning of the game show menu and set enemy
     *
     * @param CPlayer player want to start game
     */
    public void PlayStart(Player CPlayer) {
        while (true) {
            menu.Menu(CPlayer);
            count = scanner.nextInt();
            if ((count) == 1) {
                map.Map(CPlayer);
                CPlayer.PresentMap(CPlayer);

            } else if ((count) == 2) {
                CPlayer.TroopsArmy(CPlayer);
            } else if ((count) == 3) {
                CPlayer.ShowMapAndArmy(CPlayer);
            } else if ((count) == 4) {
                break;
            } else {
                System.out.println("Please inter Correct Number !!");
                continue;
            }
        }
    }

    /**
     * Check the win and lose of the each round of game
     *
     * @param player the player that play
     * @return (true if Central State of enemy and else return false)
     */
    public boolean WinOrLose(Player player) {
        int Count = 0;
        for (Ammo ammo : player.list) {
            if (ammo.getNowHP() != 0)
                Count++;
        }
        if (Count > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calculate the damage of all Irruptive of player
     *
     * @param Fplayer Attacked player
     * @return the all Irruptive Ammo
     */
    public int FullDamage(Player Fplayer) {
        int FAllDamage = 0;

        for (int i = 0; i < Fplayer.list.size(); i++) {
            if (Fplayer.list.get(i).getNowHP() != 0) {
                FAllDamage += (Fplayer.list.get(i).getDamage() * Fplayer.list.get(i).getMuch());
            }
        }
        return FAllDamage;
    }

    /**
     * When the fight was start with the format that said check against player and damage to them
     *
     * @param Fplayer Attacked player
     * @param Dplayer Defencive player
     */
    public void FightAndDefence(Player Fplayer, Player Dplayer) {
        if (Fplayer.list.size() == 0)
            System.out.println("Finish");
        if (!Dplayer.strings[0].equals("0  ")) {
            if (FullDamage(Fplayer) != 0)
                CheckDAndH(0, Dplayer, Fplayer, FullDamage(Fplayer));
            else {
                WarReport(Fplayer, Dplayer);
                return;
            }
        }
        if (!Dplayer.strings[1].equals("1  ")) {
            if (FullDamage(Fplayer) != 0)
                CheckDAndH(1, Dplayer, Fplayer, FullDamage(Fplayer));
            else {
                WarReport(Fplayer, Dplayer);
                return;
            }
        }
        if (!Dplayer.strings[2].equals("2  ")) {
            if (FullDamage(Fplayer) != 0)
                CheckDAndH(2, Dplayer, Fplayer, FullDamage(Fplayer));
            else {
                WarReport(Fplayer, Dplayer);
                return;
            }
        }
        if (!Dplayer.strings[5].equals("5  ")) {
            if (FullDamage(Fplayer) != 0)
                CheckDAndH(5, Dplayer, Fplayer, FullDamage(Fplayer));
            else {
                WarReport(Fplayer, Dplayer);
                return;
            }
        }
        if (!Dplayer.strings[8].equals("8  ")) {
            if (FullDamage(Fplayer) != 0)
                CheckDAndH(8, Dplayer, Fplayer, FullDamage(Fplayer));
            else {
                WarReport(Fplayer, Dplayer);
                return;
            }
        }
        if (!Dplayer.strings[7].equals("7  ")) {
            if (FullDamage(Fplayer) != 0)
                CheckDAndH(7, Dplayer, Fplayer, FullDamage(Fplayer));
            else {
                WarReport(Fplayer, Dplayer);
                return;
            }
        }
        if (!Dplayer.strings[6].equals("6  ")) {
            if (FullDamage(Fplayer) != 0)
                CheckDAndH(6, Dplayer, Fplayer, FullDamage(Fplayer));
            else {
                WarReport(Fplayer, Dplayer);
                return;
            }
        }
        if (!Dplayer.strings[3].equals("3  ")) {
            if (FullDamage(Fplayer) != 0)
                CheckDAndH(5, Dplayer, Fplayer, FullDamage(Fplayer));
            else {
                WarReport(Fplayer, Dplayer);
                return;
            }
        }
        if (Dplayer.strings[4].equals("4-C")) {
            if (FullDamage(Fplayer) != 0) {
                Fplayer.setTotalWin(1);
            } else {
                WarReport(Fplayer, Dplayer);
                return;
            }
        }
        WarReport(Fplayer, Dplayer);
    }

    /**
     * If defencive player have defencive ammo damage to them
     * Calculate the damage to each other
     *
     * @param num        the home of Defencive player ammo
     * @param Fplayer    Attacked player
     * @param Dplayer    Defencive player
     * @param FAllDamage full all Attacked ammo player
     */
    public void CheckDAndH(int num, Player Dplayer, Player Fplayer, int FAllDamage) {
        for (int i = 0; i < Dplayer.wall.size(); i++) {
            if ((Dplayer.wall.get(i).getHome() == num) && (Dplayer.wall.get(i).getNowHP() != 0)) {
                int Damage = Dplayer.wall.get(i).getDamage();
                /*System.out.println("Damage 1 is  "+Damage);*/
                /*while ((Dplayer.wall.get(i).getNowHP() != 0) && (Damage !=0) ){*/
                for (int j = 0; j < Fplayer.list.size(); j++) {
                    if (Dplayer.wall.get(i).getNowHP() <= Fplayer.list.get(j).getDamage()) {
                        Dplayer.wall.get(i).setNowHP(0);
                        if (Fplayer.list.get(j).getNowHP() > Damage) {
                            Fplayer.list.get(j).setNowHP(Fplayer.list.get(j).getNowHP() - Damage);
                            Damage = 0;
                        } else {
                            Damage = (Damage - Fplayer.list.get(j).getNowHP());
                            /*System.out.println("Damage 2 is  "+Damage);*/
                            Fplayer.list.get(j).setNowHP(0);
                        }
                    } else if (Dplayer.wall.get(i).getNowHP() > Fplayer.list.get(j).getDamage()) {
                        Dplayer.wall.get(i).setNowHP(Dplayer.wall.get(i).getNowHP() - Fplayer.list.get(j).getDamage());
                        if (Fplayer.list.get(j).getNowHP() > Damage) {
                            Fplayer.list.get(j).setNowHP(Fplayer.list.get(j).getNowHP() - Damage);
                            Damage = 0;
                        } else {
                            Damage = (Damage - Fplayer.list.get(j).getNowHP());
                            /*     System.out.println("Damage 3 is  "+Damage);*/
                            Fplayer.list.get(j).setNowHP(0);
                        }
                    }
        /*                System.out.println("Damage 4 is  "+Damage);
                        for (int k = 0; k <Fplayer.list.size() ; k++) {
                            System.out.println("Index " + k +" "+ Fplayer.list.get(k).getName() + "  " +Fplayer.list.get(k).getNowHP());
                        }*/
                }

                /*}*/
            }
        }
        /*System.out.println("NUM    " + num);*/

    }

    /**
     * Report of the game for player
     *
     * @param player the player that attacked
     */
    public void WarReport(Player player, Player D) {
        System.out.println(player.getNickName() + " War Report : ");
        System.out.println("Units Involved : ");
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

        DeleteDeathEnemy(player);
        System.out.println("Units KIA : ");
        for (int i = 0; i < player.list.size(); i++) {
            if (player.list.get(i).getNowHP() != 0) {
                System.out.println(player.list.get(i).getName() + " : " + player.list.get(i).getMuch() /*+ "  " + player.list.get(i).getNowHP()*/);
            }
        }

        System.out.println("Opponent’s Buildings :");
        for (Ammo dammo : D.wall) {
            System.out.println(dammo.getName() + " : " + dammo.getNowHP() + " / " + dammo.getHP());
        }

        if (WinOrLose(player)) {
            System.out.println("Outcome : Win");
            player.setMoney(player.getMoney() + 500 * WinFactor);
            player.setWinStrick(player.getWinStrick() + 1);
        } else {
            System.out.println("Outcome : Lose");
            player.setMoney(player.getMoney() + 500 * LoseFactor);
        }
        if (player.getTotalWin() == 1)
            System.out.println("Congratulation " + player.getNickName() + " You Win The Game");

        System.out.println();
        System.out.println();
    }

    /**
     * If the ammo of Attacked player if Zero delete it
     *
     * @param player Attacked player
     */
    public void DeleteDeathEnemy(Player player) {
        Iterator<Ammo> iterator = player.list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getNowHP() == 0) {
                iterator.remove();
            }
        }
    }

}
