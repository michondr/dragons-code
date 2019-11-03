package cz.vse.java.mico00.game;

import cz.vse.java.mico00.item.Creature;
import cz.vse.java.mico00.item.Dragon;
import cz.vse.java.mico00.item.Loot;

import java.util.Set;

public class GameItemsCreator {

    public LocationPlan baseLocationPlan;
    public LocationPlan currentLocationPlan;

    public void init() {
        // Helgen
        LocationPlan helgen = new LocationPlan("Helgen", 16, 6);

        GameItemsFactory.createItems(helgen,
                new Creature("Malpenar Lusius", "Leader of this unit, half of his men died during an attack of a dragon", false, true, 150, 10),
                new Creature("Arenara Acicius"),
                new Creature("Oritonde Cedus"),
                new Creature("Clagius Entius"),
                new Creature("Namana Egnatius"),
                new Loot("broken arrow", "hit impenetrable dragon scale", 0, 1),
                new Loot("imperial sword", "+2 hit", 3, 1)
        );

        // Falkreath
        LocationPlan falkreath = new LocationPlan("Falkreath", 35, 10);

        GameItemsFactory.createItems(falkreath,
                new Creature("Jarl Siddgeir", "jarl of Falkreath", true, false, 100, 1,
                        new Loot("key", "key to Falkreathen cemetery", 1, 0)
                ),
                new Creature("Dro'Baad", "bandit", false, true, 101, 13,
                        new Loot("fur")
                ),
                new Creature("Ri'Dat", "bandit", false, true, 20, 1,
                        new Loot("khajit needle", "+12 hit", 4, 1),
                        new Loot("furry armor", "+10 armor", 5, 1)
                ),
                new Creature("Wadargo", "bandit", false, true, 102, 8,
                        new Loot("gold", "", 0, 4)
                ),
                new Dragon("Odahviing", "As for myself, you've proven your mastery twice over. Thuri, Dovahkiin. I gladly acknowledge the power of your Thu'um", 20, 30,
                        new Loot("dragon soul", "from Odahviing", 0, 1),
                        new Loot("gold", "", 0, 100)
                ),
                new Dragon("Odahviing2", "As for myself, you've proven your mastery twice over. Thuri, Dovahkiin. I gladly acknowledge the power of your Thu'um", 20, 30,
                        new Loot("dragon soul", "from Odahviing2", 0, 1),
                        new Loot("gold", "", 0, 100)
                ),
                new Loot("gold", "", 0, 20),
                new Loot("potion of strength", "+6 hit", 3, 1)
        );

        // Riften
        LocationPlan riften = new LocationPlan("Riften", 30, 6);

        GameItemsFactory.createItems(riften,
                new Creature("Lasila Law-Giver", "jarl of Riften", true, true, 100, 4,
                        new Loot("note", "Laila: \"Ahhh... It's good to be home.\"\n" +
                                "Maven: \"Welcome back. I've left a few surprises for you to discover.\"\n" +
                                "Laila: \"How kind of you. And I've brought an army to give you a going away parade.\"\n" +
                                "Galmar: \"If you two are finished with the touching homecoming, there's a city in chaos out there.\"\n" +
                                "Laila: \"Indeed. Come, there is much to be done.\"", 1, 1)
                ),
                new Creature("Wadargo", "dealer", true, true, 100, 4,
                        new Loot("gold", "", 0, 23),
                        new Loot("golden amulet", "", 2, 1),
                        new Loot("ring of medium destruction", "+18 hit", 1, 1),
                        new Loot("amulet of meditation", "+1 hit +1 hp", 1, 1)
                ),
                new Creature("Ergnin", "dealer", true, true, 100, 4,
                        new Loot("firewood", "", 18, 4),
                        new Loot("ash", "", 2, 15),
                        new Loot("bone dust", "", 1, 5),
                        new Loot("deer fur", "", 5, 2)
                ),
                new Creature("Khadba Rush", "dealer", true, true, 100, 4,
                        new Loot("sword of oath", "+3 hit -3hp", 4, 1),
                        new Loot("armor of Dead Nord", "+12 hp", 13, 1),
                        new Loot("gold", "", 0, 13)
                ),
                new Creature("Gancol", "dealer", true, true, 100, 4,
                        new Loot("gold", "", 0, 14)
                ),
                new Creature("Hingot", "dealer", true, true, 100, 4,
                        new Loot("gold", "", 0, 26)
                ),
                new Dragon("Fire dragon", "", 40, 40,
                        new Loot("dragon soul"),
                        new Loot("potion of great strength", "+23 hit", 2, 1),
                        new Loot("imperial arrow", "+1 hit", 1, 12)
                ),
                new Loot("Thieves Guild Bow", "+21 hit", 11, 1),
                new Loot("Thieves Guild Armor", "+10 hit, +30 hp", 15, 1)
        );

        // Windhelm
        LocationPlan windhelm = new LocationPlan("Windhelm", 30, 13);

        GameItemsFactory.createItems(windhelm,
                new Creature("Draugr king", "buried as Ulfric Stormcloak, awoken draugr king", false, false, 150, 40,
                        new Loot("draugr sword", "+12 hit", 4, 1)
                ),
                new Creature("draugr"),
                new Creature("draugr"),
                new Creature("draugr"),
                new Creature("draugr"),
                new Creature("draugr"),
                new Creature("draugr"),
                new Creature("draugr"),
                new Creature("draugr"),
                new Creature("draugr"),
                new Loot("gold", "draughiric treasure", 0, 512)
        );

        GameItemsFactory.addLootToCreature(windhelm, "draugr",
                new Loot("draugr bow", "+3 hit", 3, 1),
                new Loot("gold", "", 3, 1)
        );

        // Winterhold
        LocationPlan winterhold = new LocationPlan("Winterhold", 45, 20);

        GameItemsFactory.createItems(winterhold,
                new Creature("Korir", "jarl of Winterhold, master sorcerer", true, false, 100, 20),
                new Creature("Arch-Mage Shalidor", "builder of school of magic College of Winterhold", true, true, 190, 200),
                new Loot("Scroll of Grand Healing", "+30 hp", 1, 1),
                new Loot("Scroll of Cure Wounds", "+10 hp", 1, 1),
                new Loot("Scroll of Guardian Circle", "+50 hp", 1, 1),
                new Loot("Scroll of Circle of Protection", "+5 hp", 1, 1),
                new Loot("Scroll of Turn Greater Undead", "+13 hp", 1, 1),
                new Loot("Scroll of Fast Healing", "+30 hp", 1, 1),
                new Loot("Scroll of Firebolt", "+10 hit", 1, 1),
                new Loot("Scroll of Fire Storm", "+10 hit", 1, 1),
                new Loot("J'zargo's Flame Cloak Scroll", "+50 hit -50 hp", 1, 1),
                new Loot("Scroll of Lightning Rune", "+15 hit", 1, 1),
                new Loot("Book of healing", "+10 hp", 1, 1),
                new Loot("Book of protection", "+10 hp", 1, 1),
                new Loot("Advances in healing spells", "+15 hp", 1, 1)
        );

        // Dawnstar
        LocationPlan dawnstar = new LocationPlan("Dawnstar", 20, 18);

        GameItemsFactory.createItems(dawnstar,
                new Creature("Skald the Elder", "jarl of Dawnstar", true, false, 100, 1,
                        new Loot("gold", "", 0, 30)
                ),
                new Creature("Malpenar Lusius", "Imperial Legion member", false, true, 100, 20),
                new Creature("Arenara Acicius", "Imperial Legion member", false, true, 100, 24),
                new Creature("Oritonde Cedus", "Imperial Legion member", false, true, 100, 26),
                new Creature("Clagius Entius", "Imperial Legion member", false, true, 100, 29),
                new Creature("Arenar Guarnia", "Imperial Legion member", false, true, 100, 30),
                new Dragon("Frost dragon", "", 350, 98,
                        new Loot("dragon soul")
                ),
                new Loot("fish"),
                new Loot("fish"),
                new Loot("fish"),
                new Loot("fish"),
                new Loot("fish")
        );

        // Morthal
        LocationPlan morthal = new LocationPlan("Morthal", 30, 16);

        GameItemsFactory.createItems(morthal,
                new Creature("Idgrod Ravencrone", "jarl of Morthal", true, false, 100, 1),
                new Creature("Saeta", "bandit", true, false, 100, 1),
                new Creature("Hodlin", "bandit", true, false, 100, 1),
                new Loot("crab"),
                new Loot("crab"),
                new Loot("crab"),
                new Loot("crab"),
                new Loot("crab")
        );

        // Solitude
        LocationPlan solitude = new LocationPlan("Solitude", 30, 10);

        GameItemsFactory.createItems(solitude,
                new Creature("Elisif the Fair", "jarl of Solitude", true, false, 100, 1),
                new Creature("Sadean", "bandit", false, false, 100, 15),
                new Creature("Jartod", "bandit", false, false, 100, 20),
                new Creature("Ugdul Mogdum", "bandit", false, false, 100, 40),
                new Creature("Dan-Za", "bandit", false, false, 50, 100),
                new Creature("Effe-Tee", "bandit", false, false, 100, 40),
                new Loot("gold", "", 0, 1),
                new Loot("gold", "", 0, 1),
                new Loot("gold", "", 0, 1),
                new Loot("gold", "", 0, 1),
                new Loot("gold", "", 0, 1),
                new Loot("gold", "", 0, 20),
                new Loot("gold", "", 0, 1)
        );

        // Markarth
        LocationPlan markarth = new LocationPlan("Markarth", 35, 28);

        GameItemsFactory.createItems(markarth,
                new Creature("Igmund", "jarl of Markarth", true, true, 100, 60,
                        new Loot("mace of Molag Bal", "+40 hit", 50, 1)
                ),
                new Creature("goblin"),
                new Creature("goblin"),
                new Creature("goblin"),
                new Creature("goblin"),
                new Creature("goblin"),
                new Creature("goblin"),
                new Creature("goblin"),
                new Dragon("Durnehviir", "My claws have rended the flesh of innumerable foes, but I have never once been felled on the field of battle", 300, 100,
                        new Loot("dragon soul", "from Durnehviir", 0, 1),
                        new Loot("dragon scale armour", "+100 hp", 50, 1)
                ),
                new Loot("great goblin axe", "+25 hit", 12, 1),
                new Loot("ring of medium destruction", "+18 hit", 1, 1),
                new Loot("forging gloves", "+2 hp +12 hit", 4, 1)
        );

        GameItemsFactory.addLootToCreature(markarth, "goblim",
                new Loot("light potion of life", "+3 hp", 2, 1)
        );

        // Whiterun
        LocationPlan whiterun = new LocationPlan("Whiterun", 65, 20);

        GameItemsFactory.createItems(whiterun,
                new Creature("Balgruuf the Greater", "jarl of Windhelm", true, false, 100, 1,
                        new Loot("gold", "", 0, 99),
                        new Loot("stromcloack hood", "+5 hp, keeps you under stormcloack protection spell", 2, 1)
                ),
                new Creature("Galmar Stone-Fist", "stormcloak", true, true, 100, 1),
                new Creature("Ralof", "stormcloak", true, true, 100, 1),
                new Creature("Gunjar", "stormcloak", true, true, 100, 1),
                new Creature("Yrsarald Thrice-Pierced", "stormcloak", true, true, 100, 1),
                new Creature("Hjornskar Head-Smasher", "stormcloak", true, true, 100, 1),
                new Creature("Jo'Rakha", "thief", true, true, 100, 1,
                        new Loot("gold", "", 0, 25),
                        new Loot("light potion of weakness", "-4 hp", 0, 25)
                ),
                new Creature("S'Baad", "thief", true, true, 100, 1),
                new Creature("Ma'Dat", "thief", true, true, 100, 1),
                new Dragon("Paarthurnax", "What is better - to be born good, or to overcome your evil nature through great effort?", 300, 120,
                        new Loot("gold", "", 0, 120),
                        new Loot("dragon soul", "from Paarthurnax", 0, 1)
                ),
                new Dragon("Alduin", "And the Scrolls have foretold of black wings in the cold, That when brothers wage war come unfurled! Alduin, Bane of Kings, ancient shadow unbound, With a hunger to swallow the world!", 750, 433,
                        new Loot("gold", "", 0, 999),
                        new Loot("dragon soul", "from Alduin", 0, 1)
                )
        );

        // placing doors
        GameItemsFactory.createDoor(helgen, falkreath, new Location(1, 5), "Fight Ri'Dat and boost your armour and hit");

        GameItemsFactory.createDoor(falkreath, helgen, new Location(22, 2), "terrible dragon attack happened here, you must find out!");
        GameItemsFactory.createDoor(falkreath, markarth, new Location(0, 4));
        GameItemsFactory.createDoor(falkreath, whiterun, new Location(10, 0));
        GameItemsFactory.createDoor(falkreath, riften, new Location(falkreath.getPlanSizeEndpoint().getX() - 1, 7));

        GameItemsFactory.createDoor(riften, falkreath, new Location(0, 3));
        GameItemsFactory.createDoor(riften, whiterun, new Location(1, 0));
        GameItemsFactory.createDoor(riften, windhelm, new Location(18, 0));

        GameItemsFactory.createDoor(windhelm, riften, new Location(17, windhelm.getPlanSizeEndpoint().getY() - 1));
        GameItemsFactory.createDoor(windhelm, whiterun, new Location(0, 7));
        GameItemsFactory.createDoor(windhelm, winterhold, new Location(4, 0));

        GameItemsFactory.createDoor(winterhold, windhelm, new Location(35, winterhold.getPlanSizeEndpoint().getY() - 1));
        GameItemsFactory.createDoor(winterhold, dawnstar, new Location(0, 10));

        GameItemsFactory.createDoor(dawnstar, whiterun, new Location(5, dawnstar.getPlanSizeEndpoint().getY() - 1));
        GameItemsFactory.createDoor(dawnstar, morthal, new Location(0, 9));
        GameItemsFactory.createDoor(dawnstar, winterhold, new Location(dawnstar.getPlanSizeEndpoint().getX() - 1, dawnstar.getPlanSizeEndpoint().getY() - 4));

        GameItemsFactory.createDoor(morthal, whiterun, new Location(14, morthal.getPlanSizeEndpoint().getY() - 1));
        GameItemsFactory.createDoor(morthal, markarth, new Location(0, 10));
        GameItemsFactory.createDoor(morthal, solitude, new Location(6, 0));
        GameItemsFactory.createDoor(morthal, dawnstar, new Location(morthal.getPlanSizeEndpoint().getX() - 1, 6));

        GameItemsFactory.createDoor(solitude, morthal, new Location(25, solitude.getPlanSizeEndpoint().getY() - 1));
        GameItemsFactory.createDoor(solitude, markarth, new Location(2, solitude.getPlanSizeEndpoint().getY() - 1));

        GameItemsFactory.createDoor(markarth, solitude, new Location(3, 0));
        GameItemsFactory.createDoor(markarth, morthal, new Location(markarth.getPlanSizeEndpoint().getX() - 1, 6));
        GameItemsFactory.createDoor(markarth, whiterun, new Location(markarth.getPlanSizeEndpoint().getX() - 1, 10));
        GameItemsFactory.createDoor(markarth, falkreath, new Location(markarth.getPlanSizeEndpoint().getX() - 1, markarth.getPlanSizeEndpoint().getY() - 1));

        GameItemsFactory.createDoor(whiterun, falkreath, new Location(30, whiterun.getPlanSizeEndpoint().getY() - 1));
        GameItemsFactory.createDoor(whiterun, markarth, new Location(0, 10));
        GameItemsFactory.createDoor(whiterun, morthal, new Location(20, 0));
        GameItemsFactory.createDoor(whiterun, dawnstar, new Location(55, 0));
        GameItemsFactory.createDoor(whiterun, windhelm, new Location(whiterun.getPlanSizeEndpoint().getX() - 1, 6));
        GameItemsFactory.createDoor(whiterun, riften, new Location(whiterun.getPlanSizeEndpoint().getX() - 1, whiterun.getPlanSizeEndpoint().getY() - 5), "city of the thieves");

        currentLocationPlan = helgen;
        baseLocationPlan = helgen;
    }

    public LocationPlan getBaseLocationPlan() {
        return baseLocationPlan;
    }

    public LocationPlan getCurrentLocationPlan() {
        return currentLocationPlan;
    }

    public void setCurrentLocationPlan(LocationPlan currentLocationPlan) {
        this.currentLocationPlan = currentLocationPlan;
    }
}
