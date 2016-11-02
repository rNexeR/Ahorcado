/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.actions;

import ahorcado.enums.OPTION_MENU;

/**
 *
 * @author kenystev
 */
public class ActionFactory {

    static public Action createAction(OPTION_MENU OPTION) throws OptionNoValidException {
        switch(OPTION){
            case PLAY: return new StartToPlayAction();
            case SCORE: return new ShowScoreAction();
            case EXIT: return new ExitAction();
            case CONTINUE: return new ContinueAction();
            case STATISTICS: return new ShowStatisticsAction();
            case SURRENDER: return new SurrenderAction();
        }
        throw new OptionNoValidException(OPTION);
    }
    
}
