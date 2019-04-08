package slotgame;


import com.netent.service.Service;


import java.util.Random;
import java.util.Scanner;

public class SlotMachineMain {

    private static int initialMoney = 1000;
    private static int prizetoPrint=0;
    private static int countofNormalGames=0;
    private static int counofFreeGames=0;
    private static Service service = new Service();
    //private  static Random rnadomeGeneratorFoSimulation = new Random();



    public static void main(String[] args) {

       // int prizeMoney= slot.spin();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play a free game or normal game Press Y or N ");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("Y")){
            System.out.println("I here"+input);
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

        int finalMoney = money;
        int prize = 0;
        while (finalMoney > 0){
            Scanner scanner = new Scanner(System.in);
            System.out.println("You have $" + finalMoney +". Would you like to play normal game?Press Y or N");
            String input = scanner.nextLine();
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
                    boolean isPrize70= true;
                    while(isPrize70){
                        System.out.println("Congratulations you have won a free game , Press Y to continue, Your Total Money"+finalMoney);
                        if(scanner.nextLine().equalsIgnoreCase("Y")){
                            counofFreeGames++;
                            prize = service.spin();
                            System.out.println("---------------------------------");
                            System.out.println("Your lucky symbols are :");
                            System.out.println(service.toString());
                            System.out.println("---------------------------------");
                            System.out.println("Prize won "+prize);
                            prizetoPrint += prize;
                            finalMoney += prize;
                            if(prize!=70){
                                isPrize70= false;
                            }
                        }
                        else{
                            System.out.println("Okay, bye. You ended with $" + prizetoPrint+" and your total balance"+finalMoney);
                        }

                    }

                }

            }else{
                System.out.println("Thanks for Visiting us");
                break;
            }

        }

        //System.out.println("Okay, bye. You ended with $" + prizetoPrint+" and your total balance"+finalMoney);

    }

    public static void startGameSimulation(int money ){

        int finalMoney = money;
        int prize = 0;
        String input = "";

        while (finalMoney > 0){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("You have $" + finalMoney +". Would you like to play normal game?Press Y or N");
//            String input = scanner.nextLine();
                input=service.checkYesorNoforSImulation();
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
                    boolean isPrize70= true;
                    while(isPrize70){
                        if(input.equalsIgnoreCase("Y")){
                            counofFreeGames++;
                            finalMoney=finalMoney-10;
                            prize = service.spin();
                            System.out.println("---------------------------------");
                            System.out.println("Your lucky symbols are :");
                            System.out.println(service.toString());
                            System.out.println("---------------------------------");
                            System.out.println("Prize won "+prize);
                            prizetoPrint += prize;
                            finalMoney += prize;
                            if(prize!=70){
                                isPrize70= false;
                            }
                        }
                        else{
                            System.out.println("Okay, bye. You ended with $" + prizetoPrint+" and your total balance"+finalMoney);
                        }

                    }

                }

            }else{
                System.out.println("Thanks for Visiting us");
                break;
            }

        }

        System.out.println("Okay, bye. You ended with $" + prizetoPrint+" and your total balance"+finalMoney);

    }


    private static void printStatistics() {
        int lostMoney=countofNormalGames*10;
        System.out.println("Won money:\t" + prizetoPrint);
        System.out.println("Lost money:\t" + lostMoney);
        System.out.println("Total Number of Games includes Free plus normal :\t" + (counofFreeGames+countofNormalGames));
        System.out.println("Total Number of  FREE Games  :\t" + (counofFreeGames));
        System.out.println("Total Number of  normal Games  :\t" + (countofNormalGames));
        System.out.println();

        System.out.println("Total RTP:\t" + ((double) prizetoPrint / (double) lostMoney) + "\t\t"
                + (100.0D * (double) prizetoPrint / (double) lostMoney) + "%");
        System.out.println();


    }

}
