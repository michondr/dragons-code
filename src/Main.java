import command.ICommand;
import game.Game;
import game.GameTexts;
import org.reflections.Reflections;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 *
 * Simple java game inspired by
 * Your quest is to kill Alduin, the World Eater
 *
 *
 */
public class Main {

    public static void main(String[] args){
        GameTexts.printWelcome();

        SwingUtilities.invokeLater(() -> {
            Game dragons_code = new Game();
            dragons_code.setFocusable(true);
            dragons_code.setVisible(true);
            dragons_code.setSize(100, 0);

            dragons_code.setCommands(getCommands());
            dragons_code.init();
        });
    }

    private static Set<ICommand> getCommands(){
        Reflections reflections = new Reflections("command");
        Set<Class<? extends ICommand>> commands = reflections.getSubTypesOf(ICommand.class);

        Set<ICommand> ics = new HashSet<>();

        for (Class<? extends ICommand> ic : commands) {
            try {
                ics.add(ic.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ics;
    }
}
