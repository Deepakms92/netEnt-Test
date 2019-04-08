package com.netent.bonusgame;

import com.netent.bonusgame.BonusGameService.BonusGameConsolebased;
import com.netent.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BonusMachineMain {

    private static int initialMoney = 1000;
    private static int prizetoPrint=0;
    private static int countofNormalGames=0;
    private static int counofBonusGames=0;
    private static List<Integer> list = new ArrayList<>();
    private static Service service = new Service();

    static{

// create a list of Integer type

        // add 5 element in ArrayList
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(0);
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play a free game or normal game Press Y or N ");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("Y")){
            startGame(initialMoney);
            printStatistics();

        }   if(input.equalsIgnoreCase("N")){
            System.out.println("Thanks for visiting us here's an option");
            System.out.println("Do you want o create a statistics of 1,00,000 simulations ");
            String inputSimulation = scanner.nextLine();
            if(inputSimulation.equalsIgnoreCase("Y")){
                for(int i = 0; i <= 100000; i++){
                    startGameSimulation(initialMoney);
                }

                printStatistics();
            }
            else{
                System.out.println("You have choose to quit, Thankyou");
            }

        }

    }

    public static void startGame(int money ){
        BonusGameConsolebased bonus =  new BonusGameConsolebased();
        int finalMoney = money;
        int prize = 0;

        while (finalMoney > 0){
            Scanner scanner = new Scanner(System.in);
            System.out.println("You have $" + finalMoney +". Would you like to play normal game?Press Y or N");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("Y")){
                countofNormalGames++;
                finalMoney=finalMoney-10;
                prize =service.spin() ;
                System.out.println("---------------------------------");
                System.out.println("Your lucky symbols are :");
                System.out.println(service.toString());
                System.out.println("---------------------------------");
                System.out.println("Prize won "+prize);
                prizetoPrint += prize;
                finalMoney += prize;
                if (prize==70){
                    System.out.println("Congratulations you have won a bonus game , Press Y to continue, Your Total Money"+finalMoney);
                    if(scanner.nextLine().equalsIgnoreCase("Y")){
                        counofBonusGames++;
                        System.out.println("Select one of the lucky box");
                        boolean checkBonus = true;
                        int prizeftomBonus=0;
                        int finalfromBonus=0;
                        List<Integer> checkSelection= new ArrayList<>();
                        while (checkBonus){
                            int selection = scanner.nextInt();
                            //checkSelection.add(selection);
                            try{
                                if(!checkSelection.contains(selection)){
                                    checkSelection.add(selection);
                                    prizeftomBonus=bonus.getRandomSelection(list,selection);
                                    if(prizeftomBonus==0){
                                        System.out.println("Your game is done , you're out of luck ");
                                        break;
                                    }else {
                                        finalfromBonus+= prizeftomBonus;
                                    }
                                }else{
                                    System.out.println("The entered selection is already used, use other selection");
                                }

                            }catch (IndexOutOfBoundsException ex){
                                System.out.println("The entered box slection is invalid or enter a valid box number");
                                checkBonus=true;

                            }

                            System.out.println("Prize won "+finalfromBonus);
                            prizetoPrint = finalfromBonus+prize;
                            //finalMoney = finalMoney+prize+finalfromBonus;

                        }
                        finalMoney = finalMoney+finalfromBonus;
                        System.out.println("You have $" + finalMoney +". Would you like to play normal game again ?Press Y or N");
                        String playAgain = scanner.nextLine();
                        if(playAgain.equalsIgnoreCase("N"));{
                            System.out.println("Okay, bye. You game ended and your total balance"+finalMoney);
                            break;
                        }

                    }
                    else{
                        System.out.println("Okay, bye. You ended with $" + prizetoPrint+" and your total balance"+finalMoney);
                    }

                }



            }else{
                System.out.println("Thanks for Visiting us");
                break;
            }

        }



    }
    public static void startGameSimulation(int money ){
        BonusGameConsolebased bonus =  new BonusGameConsolebased();
        int finalMoney = money;
        int prize = 0;

        while (finalMoney > 0){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("You have $" + finalMoney +". Would you like to play normal game?Press Y or N");
//            String input = scanner.nextLine();
            String input = service.checkYesorNoforSImulation();
            if(input.equalsIgnoreCase("Y")){
                countofNormalGames++;
                finalMoney=finalMoney-10;
                prize = service.spin();
                System.out.println("---------------------------------");
                System.out.println("Your lucky symbols are :");
                System.out.println(service.toString());
                System.out.println("---------------------------------");
                System.out.println("Prize won "+prize);
                prizetoPrint += prize;
                finalMoney += prize;
                if (prize==70){
                    System.out.println("Congratulations you have won a bonus game , Press Y to continue, Your Total Money"+finalMoney);
                    String inputB =service.checkYesorNoforSImulation();
                    if(inputB.equalsIgnoreCase("Y")){
                        counofBonusGames++;
                        System.out.println("Select one of the lucky box");
                        boolean checkBonus = true;
                        int prizeftomBonus=0;
                        int finalfromBonus=0;
                        List<Integer> checkSelection= new ArrayList<>();
                        while (checkBonus){
                            int selection = service.getRandomNumberInRange(1,5);
                            //checkSelection.add(selection);
                            try{
                                if(!checkSelection.contains(selection)){
                                    checkSelection.add(selection);
                                    try{
                                        prizeftomBonus=bonus.getRandomSelection(list,selection);
                                    }catch (IllegalArgumentException ex){
                                        System.out.println(ex);
                                    }

                                    if(prizeftomBonus==0){
                                        System.out.println("Your game is done , you're out of luck ");
                                        break;
                                    }else {
                                        finalfromBonus+= prizeftomBonus;
                                    }
                                }else{
                                    System.out.println("The entered selection is already used, use other selection");
                                }

                            }catch (IndexOutOfBoundsException ex){
                                System.out.println("The entered box slection is invalid or enter a valid box number");
                                checkBonus=true;

                            }

                            System.out.println("Prize won "+finalfromBonus);
                            prizetoPrint = finalfromBonus+prize;
                            //finalMoney = finalMoney+prize+finalfromBonus;

                        }
                        finalMoney = finalMoney+finalfromBonus;
                        System.out.println("You have $" + finalMoney +". Would you like to play normal game again ?Press Y or N");
                        String playAgain = service.checkYesorNoforSImulation();
                        if(playAgain.equalsIgnoreCase("N"));{
                            System.out.println("Okay, bye. You game ended and your total balance"+finalMoney);
                            break;
                        }

                    }
                    else{
                        System.out.println("Okay, bye. You ended with $" + prizetoPrint+" and your total balance"+finalMoney);
                    }

                }



            }else{
                System.out.println("Thanks for Visiting us");
                break;
            }

        }



    }


    private static void printStatistics() {
        int lostMoney=countofNormalGames*10;
        System.out.println("Won money:\t" + prizetoPrint);
        System.out.println("Lost money:\t" + lostMoney);
        System.out.println("Total Number of Games  :\t" + (countofNormalGames));
        System.out.println();

        System.out.println("Total RTP:\t" + ((double) prizetoPrint / (double) lostMoney) + "\t\t"
                + (100.0D * (double) prizetoPrint / (double) lostMoney) + "%");
        System.out.println();

    }


}
