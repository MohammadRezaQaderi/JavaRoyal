/**
 * This Class Want To Show The Menu Of the Game To player
 *
 * @version 1.0
 * @author mohammad reza Gaderi
 *
 */
public class Menu {
    /**
     * Show the Menu For Player
     * @param player player that want to have menu
     */
    public void Menu(Player player) {
        System.out.println(player.getNickName() + " menu :");
        System.out.println("1.Building construction ");
        System.out.println("2.Units Training ");
        System.out.println("3.Show my Map and Army ");
        System.out.println("4.Done ");
        System.out.println("Choose your option:...");
    }
}