package main;

import data.Character;
import data.Enemy;
import data.Friend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Character[] characters = new Character[10];

        for (int i = 0; i < 5; i++) {
            characters[i] = new Friend();
        }

        for (int i = 0; i < 5; i++) {
            characters[i] = new Enemy();
        }

        Collections.shuffle(Arrays.asList(characters));

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] instanceof Enemy) {
                System.out.println("Character " + i + " is an enemy! Kill it!");
                ((Enemy) characters[i]).kill();
            }
            else {
                System.out.println("Character " + i + " is a friend! :-)");
            }
        }
    }
}
