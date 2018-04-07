package com.example.awesomefat.dungeonsanddatastructures;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by awesomefat on 3/29/18.
 */

public class Room
{
    private LinkedList<Player> players;
    private LinkedList<NPC> npcs;
    private Dictionary<String, Exit> exits;
    private String description;
    private String name;

    public Room(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.players = new LinkedList<Player>();
        this.npcs = new LinkedList<NPC>();
        this.exits = new Hashtable<String, Exit>();
    }

    //Exit Management
    synchronized  public void addExit(String direction, Exit e)
    {
        this.exits.put(direction, e);
    }

    public boolean takeExit(String direction)
    {
        Exit e = this.exits.get(direction);
        if (e == null){
            return false;
        }
        else {

            return true;
        }
    }

    public void printRoom(){
        System.out.println("Current Location: "+this.name);
        System.out.println("Description: " + this.description);
        System.out.println("Players in "+this.name+": ");
        for(int a =0; a<this.players.size(); a++){
            Player currentPlayer = this.players.get(a);
            System.out.print(a+". ");
            currentPlayer.printPlayer();
            System.out.println();
        }
        System.out.println("Available Exits:");
        for(int a=0; a<this.exits.size(); a++){
            Exit currentExit = this.exits.get(a);
            System.out.println(this.exits.keys());
            this.exits.keys().nextElement();
        }
    }

    //Player management
    synchronized private void players_PerformAction(String action, Object[] params)
    {
        if(action.equals("addPlayer"))
        {
            Player temp = (Player)params[0];
            this.players.add(temp);
            temp.setCurrentRoom(this);
        }
        else if(action.equals("removePlayer"))
        {
            Player temp = (Player)params[0];
            if(this.players.remove(temp))
            {
                temp.setCurrentRoom(null);
            }
        }
    }

    public void addPlayer(Player p)
    {
        Object[] params = {p};
        this.players_PerformAction("addPlayer", params);
    }

    public void removePlayer(Player p)
    {
        Object[] params = {p};
        this.players_PerformAction("removePlayer", params);
    }

    //NPC management
    synchronized private void npcs_PerformAction(String action, Object[] params)
    {
        if(action.equals("addNPC"))
        {
            NPC temp = (NPC)params[0];
            this.npcs.add(temp);
            temp.setCurrentRoom(this);
        }
        else if(action.equals("removeNPC"))
        {
            NPC temp = (NPC)params[0];
            if(this.npcs.remove(temp))
            {
                temp.setCurrentRoom(null);
            }
        }
    }

    public void addNPC(NPC n)
    {
        Object[] params = {n};
        this.npcs_PerformAction("addNPC", params);
    }

    public void removeNPC(NPC n)
    {
        Object[] params = {n};
        this.npcs_PerformAction("removeNPC", params);
    }
}
