# Wege (Landlock)
Rules of the game:
------------------

Wege, or Landlock, is a game for two players. One player is "Land" and the other is "Water". The players take turns playing cards/tiles into a 6x6 grid to form a park. If you are "Land", your goal is to have a connected land path touch as many sides of the park as possible. If you are "Water", your goal is to create a connected stream of water that connects as many sides of the park as possible.

You can also win points by blocking your opponent. For "Land", you get bonus points for every pond you create (water that can't reach any side), and for "Water", you get bonus points for every island you create (a path that fails to reach any side). There are also gnomes that wander the path or swim in the water, and you get points for as many of these you can get to "face" each other on the board.

The game ends once a full 6x6 grid of tiles is played.

Each player takes turns, and on their turn they draw a new card/tile and decide where to play it. There are 4 kinds of cards: water cards that depict a stream of water. Land cards that depict a path of land. Cossack cards that depict neither paths nor streams, and bridge cards that depict crossing paths of land and streams of water. Some cards will have "gnomes" on them. A gnome can either be in the water or on the land, and the gnome is always at the corner of the card.

- To get a card, click on the large button at the bottom of the board.
- The first card played can go anywhere.
- Each additional card played must be placed adjacent to an existing card, either horizontally or vertically.
- The land and water on the card must match with the land/water of the card it is placed next to. Water cannot connect to land and land cannot connect to water.
  - Cards can be rotated 90° by clicking on the card while it is in the large button at the bottom of the board.

- There are special "bridge" cards. With a bridge card, you can either play it like a regular card, or you can use it to replace an existing water or land card. But:
  - A bridge card cannot replace a cossack card.
  - A bridge card cannot replace a land or water card if that card has a gnome AND that gnome is part of a group of "facing" gnomes.
  - If you replace a card with a bridge card, the other player must then use that replaced card on their turn instead of drawing a new card.


The game has 40 cards as follows:
- 12 land cards without gnomes
- 12 water cards without gnomes
- 3 land cards with a land gnome on the path
- 2 land cards with a water gnome on one of the water corners
- 3 water cards with a water gnome on the stream
- 2 water cards wtih a land gnome on one of the land corners
- 3 cossack cards
- 3 bridge cards
These cards are placed into a random order at the beginning of every game.

Using the `main` method in Java, you can play the game with default parameters or change them. Typing 

`java Wege`

should create a game with a 6x6 board and the 40 cards listed above. You can also change the size of the board and the cards in the deck.

- `java Wege 7 5` should start a game with a 7x5 grid and the 40 cards listed. If the new grid has significantly more or fewer tiles than the standard 36, increase or decrease the number of land and water cards (without gnomes) so that there are the same number of road and water cards, but at least 2 more total cards than there are tiles in the game.
- `java Wege 7 5 2` should start a game with a 7x5 grid, 2 cossack cards, 2 bridge cards, 2 of each water and land cards with gnomes on the path corners and gnomes on the non-path corners.
- `java Wege 5` should start a game with a 6x6 grid and 5 each of the specialty cards (cossack cards, bridge cards, each variation of a card with a gnome).

If you enter something other than realistic numbers, the code will display an error message.

**_Bugs in relation to bridge cards and game rules have been fixed. Automatic scoring will be added shortly._**
