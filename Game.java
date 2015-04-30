/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cwagner0604
 */
public class Game
{
    GUI gui;
    
    Player enemy;
    Player player;

    int takePlayerTurn(){
    
        //String currentWord = player.getNextWord();
    
        //input = player.WaitForWord( currentPlayer.currentDiffuclty.allotedTime );
    
        //atkParameter = currentPlayer.currentDifficulty.analyze( input );
    
        //damage = currentPlayer.currentDifficulty.playerDamage * atkParameter;

        //displayAttackDamge(damage);

        //enemy.damage( globalDamage * atkParameter);

        //player.updateDifficulty();
        
        //return enemy.getHealth();
        return 0;
    }


    int takeEnemyTurn()
    {
        //currentWord = currentPlayer.getNextWord();
    
        //displayDefendWord( currentWord );

        //input = player.WaitForWord();
    
        //defParameter = currentPlayer.currentDifficulty.analyze( input );
    
        //if defParameter > 1:
            //defParameter = 1;
        
        //damage = 1 – defParameter * currentPlayer.currentDifficulty.enemyDamage;
        
        //displayDefendDamage( damage);
        
        //currentPlayer.damage( damage );

        //player.updateDifficulty();    

        //return currentPlayer.getHealth();
        return 0;
    }

    int takeTurn(){
        
        //GoesFirst = randint(1);
        //if goesFirst:
            //t = takePlayerTurn();
            //drawUI( currentPlayer, enemy);
            //if t <= 0
                //return 1;
            //takeEnemyTurn();
            //drawUI( currentPlayer, enemy);
            //if t <= 0
                //return 0;
        //else:
            //takeEnemyTurn();
            //drawUI( currentPlayer, enemy);
            //if t <= 0
                //return 0;
            //takePlayerTurn();
            //drawUI( currentPlayer, enemy);
            //if t <= 0
                //return 1;
        //return 2;
        return 0;       
    }
};
