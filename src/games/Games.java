
package games;

import java.util.Random;
import java.util.Scanner;


public class Games {

    public static void main(String[] args) {
   
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        
        String computer_attack_description = "";
        String player_attack_description = "";
        int turn_count=1;
        int player_attack=0;
        int computer_attack=0;
        float player_life = 100;
        float player_mana = 100;
        float  computer_life = 100;
        float computer_mana = 100;
        int player_switcher = 0;
        int computer_switcher = 0;
        int normal_effect =8;
        int skill_effect =14;
        int special_effect =30;
        float regen_effect = .2f;
        int mana_cost_skill = 15;
        int mana_cost_special = 30;
        int mana_cost_regen = 5;
        
        float critical_effect = 0.5f;

 try{  
     
     System.out.println("");
     System.out.println("               \t\t    ╔═════════════════════╗");
     System.out.println("               \t\t    ║       TEKKEN PHILIPPINES        ║");
     System.out.println("               \t\t    ╚═════════════════════╝");
     
  
       while(player_life>0 && computer_life>0){ 
           
            
             
        System.out.println("\n");
        System.out.println("╔════════════════════╗                        ╔═════════════════════╗");
        System.out.println("║ Player 1\t\t\t ║                        ║ Computer                        ║");
        System.out.println("║ Life: "+(String.format("%.5f",player_life))+"\t\t ║                        ║ "+"Life: "+(String.format("%.5f",computer_life))+"  \t             ║");
        System.out.println("║ Mana: "+(String.format("%.5f",player_mana))+"\t\t ║                        ║ "+"Mana: "+(String.format("%.5f",computer_mana))+"   \t             ║");
        System.out.println("╚════════════════════╝                        ╚═════════════════════╝");
        System.out.println("\n");
        System.out.println("-------------------------------------------------------------------------------------------");
        
              if(player_mana<50){
                        
                    player_mana = player_mana+((player_life+player_mana)*.25f);
                    System.out.println("Player 1 Mana Regen Automatically \n");
              }
                    
              if(computer_mana<50){
                        
                    computer_mana = computer_mana+((computer_life+computer_mana)*.25f);
                    System.out.println("Computer Mana Regen Automatically \n");
              }  
            
            System.out.println("\nTurn Count: "+turn_count);
            System.out.print("Input Attack :  ");
            player_attack = in.nextInt();

    
            computer_attack = 1+random.nextInt(4);
            
          
            
            if(turn_count%3!=0){
  
            while(player_switcher==0){
                          
                switch(player_attack){
                    
                    case 1:
                        player_attack_description = "Normal Attack";
                        
                        
                        if(computer_life<20){
                          computer_life = computer_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          computer_life = computer_life-normal_effect; 
                        }
                        
                        player_switcher = 1;
                        break;
                        
                    case 2:
                        System.out.println("System : Skill Attack only happens every 3rd turn!!!");
                        
                        System.out.println("Input Attack Again :  ");
                        player_attack = in.nextInt();
                        break;
                     
                    case 3:
                        System.out.println("System : Special Attack only happens every 6rd turn!!!");
                        
                        System.out.println("Input Attack Again :  ");
                        player_attack = in.nextInt();
                        break;
                    
                    case 4:
                        player_attack_description = "Regen";
                        player_life = player_life+(player_life*regen_effect);
                         player_mana = player_mana-mana_cost_regen;
                        player_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input only 1,2,3 and 4 ");
                    
                         System.out.println("Input Attack Again :  ");
                         player_attack = in.nextInt();
                }
                 
            
            }
            
            
            
             while(computer_switcher==0){
                          
                switch(computer_attack){
                    
                    case 1:
                        computer_attack_description = "Normal Attack";
                        
                        if(player_life<20){
                          player_life = player_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          player_life = player_life-normal_effect; 
                        }
                        computer_switcher = 1;
                        break;
                        
                    case 2:
                        
                        computer_attack = 1+random.nextInt(4);
                           
                        break;
                     
                    case 3:
                        computer_attack = 1+random.nextInt(4);
                            
                        break;
                    
                    case 4:
                        computer_attack_description = "Regen";
                         computer_life = computer_life+(computer_life*regen_effect);
                         computer_mana = computer_mana-mana_cost_regen;
                        computer_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input ");
                        computer_attack = 1+random.nextInt(4);
                }
                 
            
            }
            
           }
            
            
            
            
           else if(turn_count%6==0){
               
               while(player_switcher==0){
                
               switch(player_attack){
                    
                    case 1:
                        player_attack_description = "Normal Attack";
                        
                        if(computer_life<20){
                          computer_life = computer_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          computer_life = computer_life-normal_effect; 
                        }
                        

                          player_switcher = 1;
                        break;
                        
                    case 2:         
                        player_attack_description = "Skill Attack";

                        
                        if(computer_life<20){
                          computer_life = computer_life-(skill_effect+(skill_effect*critical_effect));
                        }else{
                          computer_life = computer_life-skill_effect; 
                        }
                        
                         player_mana = player_mana-mana_cost_skill;
                          player_switcher = 1;
                        break;
                     
                    case 3:
                        player_attack_description = "Special Attack";
               
                        if(computer_life<20){
                          computer_life = computer_life-(special_effect+(special_effect*critical_effect));
                        }else{
                          computer_life = computer_life-special_effect; 
                        }
                        
                         player_mana = player_mana-mana_cost_special;
                          player_switcher = 1;
                        break;
                    
                    case 4:
                        player_attack_description = "Regen";
                        player_life = player_life+(player_life*regen_effect);
                        player_mana = player_mana-mana_cost_regen;
                        player_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input only 1,2,3 and 4 ");
                        System.out.println("Input Attack Again :  ");
                        player_attack = in.nextInt();
                }
               }
               
               while(computer_switcher==0){
               
                switch(computer_attack){
                    
                    case 1:
                        computer_attack_description = "Normal Attack";
                        
                        if(player_life<20){
                          computer_life = computer_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          computer_life = computer_life-normal_effect; 
                        }
                        
                        computer_switcher = 1;
                        break;
                        
                    case 2:         
                        computer_attack_description = "Skill Attack";
                        
                                       
                        if(player_life<20){
                          player_life = player_life-(skill_effect+(skill_effect*critical_effect));
                        }else{
                          player_life = player_life-skill_effect; 
                        }

                        computer_mana = computer_mana-mana_cost_skill;
                        computer_switcher = 1;
                        break;
                     
                    case 3:
                        computer_attack_description = "Special Attack";
                        
                                       
                        if(player_life<20){
                          player_life = player_life-(special_effect+(special_effect*critical_effect));
                        }else{
                          player_life = player_life-special_effect; 
                        }

                        computer_mana = computer_mana-mana_cost_special;
                        computer_switcher = 1;
                        break;
                    
                    case 4:
                        computer_attack_description = "Regen";
                        computer_life = computer_life+(computer_life*regen_effect);
                        computer_mana = computer_mana-mana_cost_regen;
                        computer_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input ");
  
                }
                
               }
                
            }
             
             
            else if(turn_count%3==0){
              
                 while(player_switcher==0){
                     
                 
                 switch(player_attack){
                    
                    case 1:
                        player_attack_description = "Normal Attack";
                  
                        if(computer_life<20){
                          computer_life = computer_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          computer_life = computer_life-normal_effect;
                        }

        
                        player_switcher = 1;
                        break;
                        
                    case 2: 
                        
                        player_attack_description = "Skill Attack";
                        
                        if(computer_life<20){
                          computer_life = computer_life-(skill_effect+(skill_effect*critical_effect));
                        }else{
                          computer_life = computer_life-skill_effect;
                        }
                                                

                        player_mana = player_mana-mana_cost_skill;
                        player_switcher = 1;
                        break;
                     
                    case 3:
                        
                        System.out.println("System : Special Attack only happens every 6rd turn!!!");                       
                        System.out.println("Input Attack Again  :  ");
                        player_attack = in.nextInt();
                        break;
                    
                    case 4:
                        
                        player_attack_description = "Regen";
                        player_life = player_life+(player_life*regen_effect);
                        player_mana = player_mana-mana_cost_regen;
                        player_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input only 1,2,3 and 4 ");
                        System.out.println("Input Attack Again :  ");
                        player_attack = in.nextInt();
                }
                
                 }
               
               
               while(computer_switcher==0){
                   
               
                switch(computer_attack){
                    
                    case 1:
                        
                        computer_attack_description = "Normal Attack";
                                      
                        if(player_life<20){
                          player_life = player_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          player_life = player_life-normal_effect; 
                        }

                        computer_switcher = 1;
                        break;
                        
                    case 2:   
                        
                        computer_attack_description = "Skill Attack";
                        
                        if(player_life<20){
                          player_life = player_life-(skill_effect+(skill_effect*critical_effect));
                        }else{
                          player_life = player_life-skill_effect; 
                        }

                        computer_mana = computer_mana-mana_cost_skill;
                        computer_switcher = 1;
                        break;
                     
                    case 3:
                        computer_attack = 1+random.nextInt(4);
                        break;
                    
                    case 4:
                        computer_attack_description = "Regen";
                        computer_life = computer_life+(computer_life*regen_effect);
                        computer_mana = computer_mana-mana_cost_regen;
                        computer_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input ");
  
                }
                 
               } 
             }
             
             
             
             
             
     
                    System.out.println("Player 1 used : "+player_attack_description);
                    System.out.println("Computer used : "+computer_attack_description);

                    turn_count++;   
                    player_switcher=0;
                    computer_switcher=0;
                    
                    

         
        }

           
           if(player_life<=0){
               
               System.out.println("\n\nComputer wins");

               
           }else if(computer_life<=0){
               
                System.out.println("\n\nPlayer 1 wins");
           }
          
 }catch(Exception e){
     
     System.out.println("Invalid Input Numbers Only ERROR ----> "+e);
 }

    }
    
}
