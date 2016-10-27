/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.ui;

/**
 *
 * @author kenystev
 */
public class ConsoleUserOutput implements UserOutput {
    
    @Override
    public void showErrorMessage(String message) {
        System.out.println(message);
    }
    
    @Override
    public void showMainMenu() {
        String[] menu = {"----Main Menu---","a) ----Play-----", "b) ----Score----", "c) ----Exit-----"};
        for (int i = 0; i< menu.length-1; i++) {
            System.out.println(menu[i]);
        }
    }

    @Override
    public void showMenu() {
        String[] menu = {"----Main Menu---", "a) --Continue---", "b) -Statistics--", "c) ----Exit-----"};
        for (int i = 0; i< menu.length-1; i++) {
            System.out.println(menu[i]);
        }
    }
    
}
