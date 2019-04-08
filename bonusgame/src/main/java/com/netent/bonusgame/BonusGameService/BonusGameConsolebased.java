package com.netent.bonusgame.BonusGameService;



import java.util.*;


public class BonusGameConsolebased {


    /**
     * Returns the random box number depending on selection.
     */

    public int getRandomSelection(List<Integer> list,
                                  int selectedItem){
        Random rand = new Random();

        List<Integer> items= new ArrayList<>();
        items.add(selectedItem);
        int totalItems= items.size();


        // create a temporary list for storing
        // selected element
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {

            // take a raundom index between 0 to size
            // of given List
            int randomIndex=0;
            if(list.size()!=0){
                randomIndex= rand.nextInt(list.size());
            }
            else{
                throw new IllegalArgumentException("Size should not be zero");
            }


            // add element in temporary list
            newList.add(list.get(randomIndex));

            // Remove selected element from orginal list
            list.remove(randomIndex);
        }
        return newList.get(0);

    }



}
