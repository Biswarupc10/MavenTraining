package com.acc.lkm.MavenProject;

/**
 * Hello world!
 *
 */
import java.util.*;



import java.io.Serializable;

public class App 

{	
	private String player;
    private Integer player_no;
    private Boolean present ;
    
    
    public App(String player,int player_no,boolean present) {
    	this.player=player;
    	this.player_no=player_no;
    	this.present=present;
    }
	
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public Integer getPlayer_no() {
		return player_no;
	}
	public void setPlayer_no(Integer player_no) {
		this.player_no = player_no;
	}
	public Boolean getPresent() {
		return present;
	}
	public void setPresent(Boolean present) {
		this.present = present;
	}
	
	@Override
	public String toString() {
        return "Customer{" +
                "PlayerName='" + player + '\'' +
                ", Jersey No.='" + player_no + '\'' +
                ", Present ='" + present + '\'' +
                '}';
    }

	
	
	
	
	public static HashSet<App> set=new HashSet<>();
	public static Scanner sc=new Scanner(System.in);
    public static void main( String[] args )
    {
    	
    	
    	
    	
    	while(true) {
    		System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Remove Customer");
            System.out.println("4. Display Customers");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

    		
    		
    		
        	
        	switch(choice) {
        	case 1:addMember();
        	break;
        	case 2:removeMember();
        	break;
        	case 3:updateMember();
        	break;
        	case 4:displayMember();
        	break;
        	case 5:System.exit(0);
        	
        	default: System.out.println("Player details not found");
        
        	}
    	}	
        
    }
    public static void addMember() {
    	System.out.print("Enter Player Name ");
        String player = sc.nextLine();
        
       
        System.out.print("Enter Jersey No: ");
        int player_no = sc.nextInt();
        System.out.print("Present in the team or not:Yes/No");
        boolean present = Boolean.parseBoolean(sc.nextLine());
        sc.nextLine(); // Consume newline

        set.add(new App(player,player_no,present));
        
        System.out.println("Player added successfully.");
    }
    
    public static void removeMember() {
    	System.out.print("Enter the jersey no.");
        int jersey = sc.nextInt();
        
        for (App player : set) {
            if (player.getPlayer_no()==jersey) {
                set.remove(player);
                System.out.println("Player removed successfully.");
              
                return;
            }
        }
    }
    
    public static void updateMember() {
    	 System.out.print("Enter the jersey no.");
         int jersey = sc.nextInt();
         
         String name="";
         int jersey_no=0;
         boolean present=false;
         for (App player : set) {
             if (player.getPlayer_no()==jersey) {
                 System.out.print("Enter new name: ");
                  name = sc.nextLine();
                 System.out.print("Enter new jerseyNo.: ");
                jersey_no = sc.nextInt();
                 System.out.print("Present in the team:Y/N ");
                  present = Boolean.parseBoolean(sc.nextLine());
                 sc.nextLine(); // Consume newline

                 player.setPlayer(name);
                 player.setPlayer_no(jersey_no);
                 player.setPresent(present);
                 
                 
                 
                 System.out.println("Player updated successfully.");
                 break;
             }
         }
    }
    
    public static void displayMember() {
    	if (set.isEmpty()) {
            System.out.println("No player to display.");
        } else {
            System.out.println("Customer List for HashSet:");
            for (App player : set) {
                System.out.println(player);
            }
            System.out.println();
        }
        
        
    }
}
