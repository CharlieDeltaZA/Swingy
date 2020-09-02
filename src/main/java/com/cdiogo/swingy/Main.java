package com.cdiogo.swingy;

import com.cdiogo.swingy.models.heros.Ranger;
import com.cdiogo.swingy.models.heros.Player;

public class Main {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        Player hunter = new Ranger("Charlie", "Hunter");
        System.out.println(hunter.toString());
    }
}