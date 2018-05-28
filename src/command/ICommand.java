package command;

import game.Game;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public interface ICommand {

    public char getKey();

    public String getDescription();

    public void init(Game game);
}
