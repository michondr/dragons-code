package cz.vse.java.mico00.command;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;
import cz.vse.java.mico00.item.Creature;
import cz.vse.java.mico00.item.Dragon;
import cz.vse.java.mico00.item.Item;
import cz.vse.java.mico00.item.Loot;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Fight implements ICommand {

    @Override
    public char getKey() {
        return 'f';
    }

    @Override
    public String getDescription() {
        return "fight - hit creature so much it begs you for mercy and then dies";
    }

    /**
     * heal player when he kills monster which possesses loot
     * check if player killed Alduin, where the game ends,
     */
    @Override
    public void init(Game game) {
        Item itemOnLocation = game.getCurrentPlan().getItemByLocation(game.getPlayer().getLocation());

        if (itemOnLocation == null) {
            return;
        }

        if (itemOnLocation.getClass() == Creature.class || itemOnLocation.getClass() == Dragon.class) {
            Creature creature = (Creature) itemOnLocation;
            Creature player = game.getPlayer();

            handleCreatureHp(player, creature);

            if (player.getHp() <= 0) {
                game.getTexts().printDead(player);
                game.end();
            }
            if (creature.getHp() <= 0) {
                game.getTexts().printDead(creature);

                if (itemOnLocation.getClass() == Creature.class) {
                    game.getCurrentPlan().getCreatures().remove(creature);
                }
                if (itemOnLocation.getClass() == Dragon.class) {
                    game.getCurrentPlan().getDragons().remove((Dragon) creature);
                }
                player.addLoot(creature.getLootSet());

                if (creature.getLootSet().size() > 0) {
                    player.setHp(player.getHpInitial());
                    for (Creature creatureInPlan : game.getCurrentPlan().getCreatures()) {
                        creatureInPlan.setHp(creatureInPlan.getHpInitial());
                    }
                }
            }

            game.getTexts().printHP(player);
            game.getTexts().printHP(creature);
        }

        checkGameEnd(game);
    }

    public void handleCreatureHp(Creature player, Creature creature) {
        if (!creature.isFriendly()) {
            player.setHp(player.getHp() - creature.getHitRandomized());
        }

        creature.setHp(creature.getHp() - player.getHitRandomized());

        if (creature.isFriendly()) {
            player.setHp(player.getHp() - creature.getHitRandomized());
        }
    }

    private void checkGameEnd(Game game) {
        Creature player = game.getPlayer();

        for (Loot loot : player.getLootSet()) {
            if (loot.getName().equals("dragon soul") && loot.getDescription().equals("from Alduin")) {
                game.getTexts().printEpilogue(player);
                game.getTexts().printGoodbye();
                System.exit(0);
            }
        }
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
