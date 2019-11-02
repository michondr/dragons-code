package cz.vse.java.mico00;

import cz.vse.java.mico00.command.ICommand;
import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Main {

    public static void main(String[] args) {
        GameTexts.printWelcome();

        Game dragons_code = new Game();
//        dragons_code.setFocusable(true);
//        dragons_code.setVisible(true);
//        dragons_code.setSize(100, 0);

        dragons_code.setCommands(getCommands());
        dragons_code.init();
    }

    /**
     * dope way to get around creating another class like `commandSet` which is useless
     */
    private static Set<ICommand> getCommands() {
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
