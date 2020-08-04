
/**
 * This class have Draw of Map
 *
 * @author mohammad reza Qaderi
 * @version 1.0
 */
public class Map {
    public Map() {
    }

    /**
     * Map of Player
     *
     * @param player player map
     */
    public void Map(Player player) {
        for (int i = 0; i < player.wall.size(); i++) {
            if (player.wall.get(i).getNowHP() == 0) {
                player.strings[(player.wall.get(i).getHome())] = (player.wall.get(i).getHome()) + "  ";
            }
        }
        System.out.println(player.getNickName() + ":");
        System.out.println("***************************************************");
        System.out.println("*               *                *                *");
        System.out.println("*               *                *                *");
        System.out.println("*   " + player.strings[0] + "         *     " + player.strings[1] + "        *      " + player.strings[2] + "       *");
        System.out.println("*               *                *                *");
        System.out.println("*               *                *                *");
        System.out.println("***************************************************");
        System.out.println("*               *                *                *");
        System.out.println("*               *                *                *");
        System.out.println("*   " + player.strings[3] + "         *     " + player.strings[4] + "        *      " + player.strings[5] + "       *");
        System.out.println("*               *                *                *");
        System.out.println("*               *                *                *");
        System.out.println("***************************************************");
        System.out.println("*               *                *                *");
        System.out.println("*               *                *                *");
        System.out.println("*   " + player.strings[6] + "         *     " + player.strings[7] + "        *      " + player.strings[8] + "       *");
        System.out.println("*               *                *                *");
        System.out.println("*               *                *                *");
        System.out.println("***************************************************");
    }
}