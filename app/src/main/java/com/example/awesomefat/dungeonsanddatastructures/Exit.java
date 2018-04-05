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
            p.setCurrentRoom(r2);
        }
        else{
            p.setCurrentRoom(r1);
        }
        //make the player move to the room they are NOT currently in.
    }
}
