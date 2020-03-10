
package games;

import java.util.Random;
import java.util.Scanner;


public class new_game {

    public static void main(String[] args) {
   
        String com_attack_description = "",p_attack_description = "";
        int p_attack=0,turn_count=1,com_attack=0,p_switcher = 0,com_switcher = 0,normal_effect =8,skill_effect =14,special_effect =30,mana_cost_skill = 15,mana_cost_special = 30,mana_cost_regen = 5;
        float p_life = 100,p_mana = 100,com_life = 100,com_mana = 100,regen_effect = .2f,critical_effect = 0.5f;    
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        

 try{  
     
        System.out.println(" \t\t          NAME OF GAME       ");
   
       while(p_life>0 && com_life>0){ 
           
        System.out.println("****************************************************************************************************\n\n\n");   
        System.out.println(" Player 1\t\t\t                   Computer");
        System.out.println("Life: "+(String.format("%.3f",p_life))+"\t\t                       "+"Life: "+(String.format("%.3f",com_life))+"  \t          ");
        System.out.println("Mana: "+(String.format("%.3f",p_mana))+"\t\t                       "+"Mana: "+(String.format("%.3f",com_mana))+"   \t         ");
      
        System.out.println("\n");
      
        
              if(p_mana<50){
                        
                    p_mana = p_mana+((p_life+p_mana)*.25f);
                    System.out.println("Player 1 Mana Regen Automatically \n");
              }
                    
              if(com_mana<50){
                        
                    com_mana = com_mana+((com_life+com_mana)*.25f);
                    System.out.println("Computer Mana Regen Automatically \n");
              }  
            
            System.out.println("\nTurn Count: "+turn_count);
            System.out.print("Input Attack :  ");
            p_attack = in.nextInt();

    
            com_attack = 1+random.nextInt(4);
            
          
            
            //dito yung itetest nya kung ang input ng player ay modulo 3 ibig sabihin ng %3!0 bawal ang skill or speacial attack sa turn na to normal at regen lng pwede ...
           //kpag hindi sa dalawa ang napili nya normal at regen magloop ulit sya kung pinili nya yung special at skill attack na mangyayari lang evey 3 or 6 turn......
            
            
            if(turn_count%3!=0){
  
            while(p_switcher==0){
                          
                switch(p_attack){
                    
                    case 1:
                        p_attack_description = "Normal Attack";
                        
                        
                        if(com_life<20){
                          com_life = com_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          com_life = com_life-normal_effect; 
                        }
                        
                        p_switcher = 1;
                        break;
                        
                    case 2:
                        System.out.println("System : Skill Attack only happens every 3rd turn!!!");
                        
                        System.out.println("Try Attack Again :  ");
                        p_attack = in.nextInt();
                        break;
                     
                    case 3:
                        System.out.println("System : Special Attack only happens every 6rd turn!!!");
                        
                        System.out.println("Input Attack Again :  ");
                        p_attack = in.nextInt();
                        break;
                    
                    case 4:
                        p_attack_description = "Regen";
                        p_life = p_life+(p_life*regen_effect);
                         p_mana = p_mana-mana_cost_regen;
                        p_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input only 1,2,3 and 4 ");
                    
                         System.out.println("Input Attack Again :  ");
                         p_attack = in.nextInt();
                }
                 
            
            }
            
       //eto ang computer turn automatic na nag iinput yan dahil sa random function na ginamit ko ganun din d2 kpag ang turn count ay hindi modulo sa 3 or 6 magloloop ulit sya ng paulit ulit hanggang sa matama nya yung input mmo.....     
            
             while(com_switcher==0){
                          
                switch(com_attack){
                    
                    case 1:
                        com_attack_description = "Normal Attack";
                        
                        if(p_life<20){
                          p_life = p_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          p_life = p_life-normal_effect; 
                        }
                        com_switcher = 1;
                        break;
                        
                    case 2:
                        
                        com_attack = 1+random.nextInt(4);
                           
                        break;
                     
                    case 3:
                        com_attack = 1+random.nextInt(4);
                            
                        break;
                    
                    case 4:
                        com_attack_description = "Regen";
                         com_life = com_life+(com_life*regen_effect);
                         com_mana = com_mana-mana_cost_regen;
                        com_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input ");
                        com_attack = 1+random.nextInt(4);
                }
                 
            
            }
            
           }
       
            
            
            
      //   player turn nmn to d2 ichecheck nya kung modulo sa 6 its mean kapag gumamit ka ng special skill d2 papsok yung sa condition mo then ichecheck nya kung spekill skill yung ginamit mo dyan..
      // magloloop din sya kpag wala sa pagpipilian yung input mo example kpag 6 yung input dba wala nmn 6 sa pagpipilian maglolooop ulit sya hanggang matama yung input mo...      
                      
           else if(turn_count%6==0){
               
               while(p_switcher==0){
                
               switch(p_attack){
                    
                    case 1:
                        p_attack_description = "Normal Attack";
                        
                        if(com_life<20){
                          com_life = com_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          com_life = com_life-normal_effect; 
                        }
                        

                          p_switcher = 1;
                        break;
                        
                    case 2:         
                        p_attack_description = "Skill Attack";

                        
                        if(com_life<20){
                          com_life = com_life-(skill_effect+(skill_effect*critical_effect));
                        }else{
                          com_life = com_life-skill_effect; 
                        }
                        
                         p_mana = p_mana-mana_cost_skill;
                          p_switcher = 1;
                        break;
                     
                    case 3:
                        p_attack_description = "Special Attack";
               
                        if(com_life<20){
                          com_life = com_life-(special_effect+(special_effect*critical_effect));
                        }else{
                          com_life = com_life-special_effect; 
                        }
                        
                         p_mana = p_mana-mana_cost_special;
                          p_switcher = 1;
                        break;
                    
                    case 4:
                        p_attack_description = "Regen";
                        p_life = p_life+(p_life*regen_effect);
                        p_mana = p_mana-mana_cost_regen;
                        p_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input only 1,2,3 and 4 ");
                        System.out.println("Input Attack Again :  ");
                        p_attack = in.nextInt();
                }
               }
               
              //computer turn naman toh 
               
               while(com_switcher==0){
               
                switch(com_attack){
                    
                    case 1:
                        com_attack_description = "Normal Attack";
                        
                        if(p_life<20){
                          com_life = com_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          com_life = com_life-normal_effect; 
                        }
                        
                        com_switcher = 1;
                        break;
                        
                    case 2:         
                        com_attack_description = "Skill Attack";
                        
                                       
                        if(p_life<20){
                          p_life = p_life-(skill_effect+(skill_effect*critical_effect));
                        }else{
                          p_life = p_life-skill_effect; 
                        }

                        com_mana = com_mana-mana_cost_skill;
                        com_switcher = 1;
                        break;
                     
                    case 3:
                        com_attack_description = "Special Attack";
                        
                                       
                        if(p_life<20){
                          p_life = p_life-(special_effect+(special_effect*critical_effect));
                        }else{
                          p_life = p_life-special_effect; 
                        }

                        com_mana = com_mana-mana_cost_special;
                        com_switcher = 1;
                        break;
                    
                    case 4:
                        com_attack_description = "Regen";
                        com_life = com_life+(com_life*regen_effect);
                        com_mana = com_mana-mana_cost_regen;
                        com_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input ");
  
                }
                
               }
                
            }
             
         // player turn namn toh ichecheck nya kung modulo 3 nmn sya its mean sa skill attack nmn toh kpag nagtrue sa condition cocomputine nya na sa loob ng condition yung formula para dyan sa skill
           
           
            else if(turn_count%3==0){
           
                
                
               while(p_switcher==0){
                     
                 
                 switch(p_attack){
                    
                    case 1:
                        p_attack_description = "Normal Attack";
                  
                        if(com_life<20){
                          com_life = com_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          com_life = com_life-normal_effect;
                        }

        
                        p_switcher = 1;
                        break;
                        
                    case 2: 
                        
                        p_attack_description = "Skill Attack";
                        
                        if(com_life<20){
                          com_life = com_life-(skill_effect+(skill_effect*critical_effect));
                        }else{
                          com_life = com_life-skill_effect;
                        }
                                                

                        p_mana = p_mana-mana_cost_skill;
                        p_switcher = 1;
                        break;
                     
                    case 3:
                        
                        System.out.println("System : Special Attack only happens every 6rd turn!!!");                       
                        System.out.println("Input Attack Again  :  ");
                        p_attack = in.nextInt();
                        break;
                    
                    case 4:
                        
                        p_attack_description = "Regen";
                        p_life = p_life+(p_life*regen_effect);
                        p_mana = p_mana-mana_cost_regen;
                        p_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input only 1,2,3 and 4 ");
                        System.out.println("Input Attack Again :  ");
                        p_attack = in.nextInt();
                }
                
                 }
               
               
               //computer turn nmn toh same lng nmn sila turn lang toh ng computer
               
               while(com_switcher==0){
                   
               
                switch(com_attack){
                    
                    case 1:
                        
                        com_attack_description = "Normal Attack";
                                      
                        if(p_life<20){
                          p_life = p_life-(normal_effect+(normal_effect*critical_effect));
                        }else{
                          p_life = p_life-normal_effect; 
                        }

                        com_switcher = 1;
                        break;
                        
                    case 2:   
                        
                        com_attack_description = "Skill Attack";
                        
                        if(p_life<20){
                          p_life = p_life-(skill_effect+(skill_effect*critical_effect));
                        }else{
                          p_life = p_life-skill_effect; 
                        }

                        com_mana = com_mana-mana_cost_skill;
                        com_switcher = 1;
                        break;
                     
                    case 3:
                        com_attack = 1+random.nextInt(4);
                        break;
                    
                    case 4:
                        com_attack_description = "Regen";
                        com_life = com_life+(com_life*regen_effect);
                        com_mana = com_mana-mana_cost_regen;
                        com_switcher = 1;
                        break;
                    
                    default:System.out.println("invalid Input ");
  
                }
                 
               } 
             }
             
             
             
             
             //eto yung label ng player and computer kung anu anu mga tira nila bawat turn ng games
     
                    System.out.println("Player 1 used : "+p_attack_description);
                    System.out.println("Computer used : "+com_attack_description);

                //loop para sa mga invalid na input or subra sa hinihingi na input balw pang validation toh kya importante to    
                    
                    turn_count++;   
                    p_switcher=0;
                    com_switcher=0;
                    
                    

         
        }

       
       //d2 malalamn kung cno nanalo kpag ang life ng bawat player ay nag equal or bumaba sa 0 its mean talo yun else yung isa yung win
           
           if(p_life<=0){
               
               System.out.println("\n\nComputer wins");

               
           }else if(com_life<=0){
               
                System.out.println("\n\nPlayer 1 wins");
           }
          
 }catch(Exception e){
     
     System.out.println("Invalid Input "+e);
 }

    }
    
}
