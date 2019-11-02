package cz.vse.java.mico00.output;

import cz.vse.java.mico00.game.Game;

public interface IOutput {
    void output(String str);

    void outputRewrite(String str);

    void outputPlan(Game game);
}
