package it.develhope;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Superheroes wolverine = new Superheroes();
        Superheroes ironMan = new Superheroes();
        Superheroes spiderman = new Superheroes();
        wolverine.createTable();

        System.out.println("---------");
        wolverine.insertHero("Wolverine", Teams.XMEN);
        ironMan.insertHero("Iron man", Teams.AVENGERS);
        spiderman.insertHero("Spiderman", Teams.NONAME);
        System.out.println("---------");
        wolverine.printAllHeroes();
        System.out.println("---------");
        wolverine.updateHero();
        System.out.println("---------");
        wolverine.printAllHeroes();
        wolverine.dropTable();
    }
}
