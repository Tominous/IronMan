package com.spigotcodingacademy.ironman.manager;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {

    public static ArrayList<Player> Suit = new ArrayList<>();
    public static ArrayList<Player> buildingSuit = new ArrayList<>();
    public static ArrayList<Player> isLowHealth = new ArrayList<>();
    public static ArrayList<Player> isOnFire = new ArrayList<>();
    public static ArrayList<Player> isPoisened = new ArrayList<>();
    public static HashMap<Player, String> suitAssigned = new HashMap<>();

}