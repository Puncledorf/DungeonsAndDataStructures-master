package com.example.awesomefat.dungeonsanddatastructures;

/**
 * Created by awesomefat on 3/29/18.
 */

public class Exit
{
    private Room r1;
    private Room r2;

    public Exit(Room r1, Room r2)
    {
        this.r1 = r1;
        this.r2 = r2;
    }

    public void takeExit(Player p)
    {
        if (p.getCurrentRoom()==r1){
            r1.removePlayer(p);
            r2.addPlayer(p);
        }
        else{
            r2.removePlayer(p);
            r1.addPlayer(p);
        }
        //make the player move to the room they are NOT currently in.
    }
}
