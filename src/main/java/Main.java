/**
 * @author Esther Romero Aguilar
 * */

import db.GameDB;
import db.RoundDB;
import db.UserDB;

public class Main {
    public static void main(String[] args) {
        try {
            UserDB userDB = new UserDB();
            GameDB gameDB = new GameDB();
            RoundDB roundDB = new RoundDB();

            gameDB.selectGamesAndRoundsForUser("gabther");

        }catch (Exception e){
            System.out.println(e);
        }
    }
}