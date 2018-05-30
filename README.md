# dragons&code
This is simple java game, made upon story of Skyrim and style of NetHack. 
You kill enemies, gain loot, boost armour and strength, and you defeat dragons.

Your quest is to kill dragon by name Alduin, the World Eater

Game is designed to run in IntelliJ IDEA console, do dimensions of planes compensate output font not being rectangular.
Java version is 9.0

## story
The player character is a prisoner being led to an Imperial execution in Helgen. 
Alduin unexpectedly interrupts the procession, destroying the town before the player can be executed. 
The player escapes in the chaos when the city is already burned to ashes and Alduin is gone.

## controls
* moving by w, s, a, d
* h for help
* i for inventory
* f for fighting creatures
* c for collecting loot
* g to go to through door to new location
* b for returning to base, which is Helgen
* q for quitting the game

## principles
You, `Laat Dovahkiin`,  start with 100 hp (health point) and 1 (hit), because you're naked and fist fighting.
By collecting items you can change your hp and hit.

Game plans are displayed in ASCII art-like graphics with following symbols:
* `|` and `-` for borders
* `@` player location
* `!` creature you can kill
* `$` loot you can collect
* `#` door/road to location you can go to

When you attack a creature, it hits you depending on whether it is friendly or not. 
Unfriendly creature hits you sooner than you hit it and vice versa. 
When you kill a creature, you automatically gain its loot and your hp gets restored.

Throughout the game are randomly printed quotes from the game when player is moving.

Some creatures are moving on every your step. 
This especially applies to dragons which are hard to match your position with theirs.
Also creatures which are likely to kill you are red.

Hit you give to creatures and hit you receive is randomized between +- 10% of set hit.

## game end
when you kill Alduin, or any time you die

## game plan

![game plan](https://lh3.googleusercontent.com/040LDKgV1MaAs22ezI28rNO4SOKv9IBNQ_xGz4rN1Y45EmIAqQOCG9h4tRmp6gxwNTl5cxce6_Urgq8yI7IJkqj_Mgx17t1TeVZXSWj3D_OmEE6e74_ylo6jvcOZMnZmV4U6lhOpFMk=w1246-h934-no "game plan")

## TODO
* JUnit tests - game is so advanced that I had no time and joy in writing those
* play testing and fiddling with hp and hit of creatures and boosts to have best play