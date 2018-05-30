package command;

import game.Game;
import game.GameTexts;
import item.Creature;
import item.Dragon;
import item.Item;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Kill implements ICommand {

    @Override
    public char getKey() {
        return 'k';
    }

    @Override
    public String getDescription() {
        return "kill - hit creature so much it begs you for mercy and the dies";
    }

    @Override
    public void init(Game game) {
        Item itemOnLocation = game.getCurrentPlan().getItemByLocation(game.getPlayer().getLocation());

        if (itemOnLocation == null) {
            return;
        }

        if (itemOnLocation.getClass() == Creature.class || itemOnLocation.getClass() == Dragon.class) {
            Creature creature = (Creature) itemOnLocation;
            Creature player = game.getPlayer();

            creature.setHp(creature.getHp() - player.getHitRandomized());

            if(!creature.isFriendly()){
                player.setHp(player.getHp() - creature.getHitRandomized());
            }

            if (player.getHp() <= 0) {
                GameTexts.printDead(player);
                GameTexts.printGoodbye();
                System.exit(0);
            }
            if (creature.getHp() <= 0) {
                GameTexts.printDead(creature);
                game.getCurrentPlan().getCreatures().remove(creature);
                player.addLoot(creature.getLootSet());
            }

            GameTexts.printHP(player);
            GameTexts.printHP(creature);
        }
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
