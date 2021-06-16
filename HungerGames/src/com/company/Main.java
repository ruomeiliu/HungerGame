package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//Assign random values
        Random r1 = new Random();

        ArrayList<Contestants> contestantsList = new ArrayList<>(24);
        for (int x = 0; x < 24; x++) {
            if (x < 12) {
                contestantsList.add(new Contestants("p" + x, 'm', 10 * r1.nextDouble(), 10 * r1.nextDouble(), 10 * r1.nextDouble(), 10 * r1.nextDouble(), 10 * r1.nextDouble())); //male
            } else {
                contestantsList.add(new Contestants("fp" + x, 'f', 10 * r1.nextDouble(), 10 * r1.nextDouble(), 10 * r1.nextDouble(), 10 * r1.nextDouble(), 10 * r1.nextDouble())); //female
            }
        }
        for (int i = 0; i < 24; i++) {
            System.out.println("The list of contestants is: " + contestantsList.get(i).getName() + ". The attack level is: " + contestantsList.get(i).getAttack_level() + ". The health level is: "
            + contestantsList.get(i).getHealth_level());
        }


//Assign contestants type
        ArrayList<Integer> careersIndices = new ArrayList<>();
        while (careersIndices.size() <= 6) {
            int currentIdx = r1.nextInt(23);
            while (careersIndices.contains(currentIdx)) {
                currentIdx = r1.nextInt(23);
            }
            careersIndices.add(currentIdx);
            contestantsList.get(currentIdx).setType("Careers");
        }

        for (int x = 0; x < 24; x++) {
            if (!careersIndices.contains(x)) {
                contestantsList.get(x).setType("District");
            }
        }
//Simulate the game
        boolean flag = true;
        int day = 0;
        Games games = new Games();
//        System.out.println(games.healthLevelCheck(contestantsList.get(1), contestantsList.get(2)));
//        Contestants c1 = contestantsList.get(1);
//        Contestants c2 = contestantsList.get(2);
//        double attack = c1.getAttack_level() - c2.getAttack_level();
//        if(games.healthLevelCheck(contestantsList.get(1), contestantsList.get(2))){
//            if (attack >0) {
//                c1.setHealth_level(c1.getHealth_level()-c2.getAttack_level());
//                c2.setHealth_level(c2.getHealth_level()-c1.getAttack_level());
//                System.out.println("The winner is: " + c1.toString());}
//            else {
//                c1.setHealth_level(c1.getHealth_level()-c2.getAttack_level());
//                c2.setHealth_level(c2.getHealth_level()-c1.getAttack_level());
//                System.out.println("The winner is: " + c2.toString());}
//        } else System.out.println("The competition is tight.");
        ///////////////////////////////////////////////////////
//        games.getWinner(contestantsList.get(1), contestantsList.get(2));
//        if(contestantsList.get(1).getHealth_level()<0) {
//            games.kills(contestantsList.get(1));
//        }
//        if (contestantsList.get(2).getHealth_level()<0){
//            games.kills(contestantsList.get(2));
//        }
//        System.out.println("The number of left contestants is: " + games.no_contestants);
//        System.out.println(contestantsList.get(1).getHealth_level() + " " + contestantsList.get(2).getHealth_level());

//
        while(games.lastFighter()) {
            int contestant1Idx = r1.nextInt(23);
            int contestant2Idx = r1.nextInt(23);
            while(contestant1Idx == contestant2Idx) {
                contestant2Idx = r1.nextInt(23);
            }
            Contestants c1 = contestantsList.get(contestant1Idx);
            Contestants c2 = contestantsList.get(contestant2Idx);
            games.getWinner(c1,c2);                                    //Start the fight
            if(c1.getHealth_level() <= 0) {
                games.kills(c1);
            }
            if (c2.getHealth_level() <= 0){
                games.kills(c2);
            }
            System.out.println("The number of left contestants is: " + games.no_contestants + " in day " + day);
            if (!games.lastFighter()) System.out.println("The last contestant is: " + contestantsList.toString());
            for(Contestants contestants:contestantsList){
               games.getBonus(contestants);                               //Get potential bonus
            }
            day += 1;
        }
        System.out.println("Only one fighter left and killed by President Snow.");
        System.out.println("Battle ended in day " + day);
    }
}

