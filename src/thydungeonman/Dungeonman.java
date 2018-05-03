/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thydungeonman;

/**
 *
 * @author Britt2ney
 */
public class Dungeonman {

    private int score;
    private int flask = 0;
    private String location;
    private boolean alive, trinket;
    private boolean scroll = true;
    private char play;
    private boolean lost;

    public Dungeonman() {
        score = 0;
        location = "main";
        trinket = false;
        lost = false;
        play = 'Y';
    }

    public void openingScreen() {
        clearScreen();
        System.out.println("THY DUNGEONMAN\n"
                + "\n\nYOU ARE THY DUNGEONMAN!\n");
    }

    public char keepPlaying() {
        return play;
    }

    public void wantToKeepPlaying(char play) {
        this.play = play;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean hasTrinket() {
        return trinket;
    }

    public void setTrinket(boolean trinket) {
        this.trinket = trinket;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLocation() {
        return location;
    }

    public void atMain(String input) {
        switch (input.toLowerCase()) {
            case "get scroll":
                if (!scroll) {
                    System.out.println("\"Ye doth suffer from memory loss. YE SCROLL is no more. Honestly.\"");
                    score -= 1;
                } else {
                    System.out.println("\"Ye takes the scroll and reads of it. It doth say: BEWARE, READER OF THE SCROLL, DANGER AWAITS TO THE- The SCROLL disappears in thy hands with ye olde ZAP!\"");
                    score += 2;
                    scroll = false;
                }

                break;
            case "get flask":
                if (flask < 2) {
                    System.out.println("\"Ye cannot get the FLASK. It is firmly bolted to a wall which is bolted to the rest of the dungeon which is probably bolted to a castle. Never you mind.\"");
                    score += 1;
                    flask += 1;
                } else {
                    System.out.println("\"Okay, okay. You unbolt yon FLASK and hold it aloft. A great shaking begins. The dungeon ceiling collapses down on you, crushing you in twain. Apparently, this was a load-bearing FLASK. Your score was: ___ Play again? [Y/N]\"");
                    score -= 1000;
                    alive = false;
                }
                break;

            case "go north":
                goNorth();
                break;
                
            case "go south":
                goSouth();
                break;
                
            case "go dennis":
                goDennis();
                break;
                
            default:
                System.out.println(badInput());
                break;
        }
    }

    public void atNorth(String input) {

    }

    public void atSouth(String input) {
        //Check input and respond accordingly
    }

    public void atDennis(String input) {

    }

    public void goMain() {
        System.out.print("\nYe find yeself in yon dungeon. Ye see a SCROLL. "
                + "Behind ye scroll is a FLASK. Obvious exits are NORTH, "
                + "SOUTH and DENNIS.");
        this.location = "main";
    }

    public void goNorth() {
        System.out.print("\nYou go NORTH through yon corridor. You arrive at "
                + "parapets. Ye see a ROPE. Obvious exits are SOUTH.");
        this.location = "north";
    }

    public void goSouth() {
        System.out.print("\nYou head south to an enbankment. Or maybe a chasm. "
                + "You can't decide which. Anyway, ye spies a TRINKET. "
                + "Obvious exits are NORTH.");
        this.location = "south";
    }

    public void goDennis() {
        System.out.print("\nYe arrive at Dennis. He wears a sporty frock coat "
                + "and a long jimberjam. He paces about nervously. "
                + "Obvious exits are NOT DENNIS.");
        this.location = "dennis";
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void prompt() {
        if (isAlive()) {
            System.out.print("\n\nWhat wouldst thou deau?\n>");
        }
    }

    public String badLocation() {
        return "\nThou cannotst go there. Who do you think thou art? A magistrate?!";
    }

    public String badInput() {
        return "\nThat does not computeth. Type HELP is thou needs of it.";
    }

    public String goDie() {
        return "That wasn't very smart.";
    }

    public void gameOver() {
        lost = true;
        alive = false;
        System.out.print(" Your score was: " + score + ".\nPlay again? [Y/N] ");
    }
}
