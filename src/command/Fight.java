package command;

import game.Game;
import game.GameTexts;
import item.Creature;
import item.Dragon;
import item.Item;
import item.Loot;

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

            if (!creature.isFriendly()) {
                player.setHp(player.getHp() - creature.getHitRandomized());
            }

            creature.setHp(creature.getHp() - player.getHitRandomized());

            if (creature.isFriendly()) {
                player.setHp(player.getHp() - creature.getHitRandomized());
            }

            if (player.getHp() <= 0) {
                GameTexts.printDead(player);
                GameTexts.printGoodbye();
                System.exit(0);
            }
            if (creature.getHp() <= 0) {
                GameTexts.printDead(creature);

                if(itemOnLocation.getClass() == Creature.class){
                    game.getCurrentPlan().getCreatures().remove(creature);
                }
                if(itemOnLocation.getClass() == Dragon.class){
                    game.getCurrentPlan().getDragons().remove((Dragon) creature);
                }
                player.addLoot(creature.getLootSet());

                if(creature.getLootSet().size() > 0){
                    player.setHp(player.getHpInitial());
                    for (Creature creatureInPlan : game.getCurrentPlan().getCreatures()) {
                        creatureInPlan.setHp(creatureInPlan.getHpInitial());
                    }
                }
            }

            GameTexts.printHP(player);
            GameTexts.printHP(creature);
        }

        checkGameEnd(game.getPlayer());
    }

    private void checkGameEnd(Creature player) {
        for (Loot loot : player.getLootSet()) {
            if(loot.getName().equals("dragon soul") && loot.getDescription().equals("from Alduin")){
                GameTexts.printEpilogue(player);
                GameTexts.printGoodbye();
                System.exit(0);
            }
        }
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
