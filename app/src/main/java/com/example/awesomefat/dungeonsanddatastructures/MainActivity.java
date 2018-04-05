package com.example.awesomefat.dungeonsanddatastructures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.buildDungeon();
    }

    private void buildDungeon()
    {
        Player p = new Player("Mike");
        Room s120 = new Room("S120", "S120 Classroom");
        Room csHallway = new Room("CS Hallway", "The CS Hallway");
        Exit s120_csHallway = new Exit(s120, csHallway);

        s120.addPlayer(p);

        s120.addExit("north", s120_csHallway);
        csHallway.addExit("south", s120_csHallway);
        s120.takeExit("north");
        s120.takeExit("west");
        csHallway.takeExit("south");
    }
}
