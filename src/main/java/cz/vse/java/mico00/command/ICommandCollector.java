package cz.vse.java.mico00.command;

import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

public class ICommandCollector {
    /**
     * dope way to get around creating another class like `commandSet` which is useless
     */
    public static Set<ICommand> getCommands() {
        Reflections reflections = new Reflections("cz.vse.java.mico00.command");
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
