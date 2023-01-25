package com.ShikharD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Locations locations = new Locations();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> vocab = new HashMap<String, String>();
        vocab.put("QUIT","Q");
        vocab.put("NORTH","N");
        vocab.put("EAST","E");
        vocab.put("SOUTH","S");
        vocab.put("WEST","W");

        int loc =64;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc==0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are: ");
            for(String exit:exits.keySet()){
                System.out.print(exit+", ");
            }
            System.out.println();

            String direction = sc.nextLine().toUpperCase();
            if(direction.length()> 1){
                String[] words= direction.split(" ");
                for(String word:words){
                    if(vocab.containsKey(word)){
                        direction = vocab.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }else{
                System.out.println("You cannot move in that direction");
            }
        }

    }
}