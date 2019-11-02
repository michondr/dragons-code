package cz.vse.java.mico00.command;

import cz.vse.java.mico00.game.Game;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public interface ICommand {

    public char getKey();

    public String getDescription();

    public void init(Game game);

    public boolean isMove();
}
