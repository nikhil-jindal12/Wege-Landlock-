import javafx.application.Application;
import java.util.Collections;
import java.util.List;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;

/**
 * Class that has the rules and GUI for the Wege game
 * @author Nikhil Jindal
 */
public class Wege extends Application {

    /** How tall the board should be */
    private static int gridHeight = 6;
    
    /** How wide the board should be */
    private static int gridLength = 6;

    /** the number of land cards */
    private static int landCard = 12;

    /** the number of water cards */
    private static int waterCard = 12;

    /** the number of land cards with land gnomes */
    private static int landLandGnome = 3;

    /** the number of land cards with water gnomes */
    private static int landWaterGnome = 2;

    /** the number of water cards with land gnomes */
    private static int waterLandGnome = 3;

    /** the number of water cards with water gnomes */
    private static int waterWaterGnome = 2;

    /** the number of cossack cards */
    private static int cossackCard = 3;

    /** the number of bridge cards */
    private static int bridgeCard = 3;

    /** the number of cards that have been played so far */
    private int cardsPlayed = 0;

    /** create the button at the bottom of the board */
    WegeButton nextCard = new WegeButton(500/getGridHeight() + 25, 500/getGridHeight() + 25);

    /** label that indicates the player's turn */
    Label turnIndicator = new Label("LAND's turn");

    /** create a board that adheres to the inputted or default values */
    WegeButton[][] gameBoard = createBoard();

    /**
     * Returns how wide the grid will be
     * @return how wide the grid will be
     */
    public static int getGridLength() {
        return gridLength;
    }

    /**
     * Returns how tall the grid will be
     * @return how tall the grid will be
     */
    public static int getGridHeight() {
        return gridHeight;
    }

    /**
     * Returns the number of land cards in the deck
     * @return the number of land cards in the deck
     */
    public static int getLandCard() {
        return landCard;
    }

    /**
     * Returns the number of water cards in the deck
     * @return the number of water cards in the deck
     */
    public static int getWaterCard() {
        return waterCard;
    }

    /**
     * Returns the number of land cards with land gnomes in the deck
     * @return the number of land cards with land gnomes in the deck
     */
    public static int getLandLandGnome() {
        return landLandGnome;
    }

    /**
     * Returns the number of land cards with water gnomes in the deck
     * @return the number of land cards with water gnomes in the deck
     */
    public static int getLandWaterGnome() {
        return landWaterGnome;
    }

    /**
     * Returns the number of water cards with land gnomes in the deck
     * @return the number of water cards with land gnomes in the deck
     */
    public static int getWaterLandGnome() {
        return waterLandGnome;
    }

    /**
     * Returns the number of water cards with water gnomes in the deck
     * @return the number of water cards with water gnomes in the deck
     */
    public static int getWaterWaterGnome() {
        return waterWaterGnome;
    }

    /**
     * Returns the number of cossack cards in the deck
     * @return the number of cossack cards in the deck
     */
    public static int getCossackCard() {
        return cossackCard;
    }

    /**
     * Returns the number of bridge cards in the deck
     * @return the number of bridge cards in the deck
     */
    public static int getBridgeCard() {
        return bridgeCard;
    }

    /**
     * Returns the nextCardbutton
     * @return the nextCardbutton
     */
    public WegeButton getNextCard() {
        return nextCard;
    }

    /**
     * Sets the height of the grid
     * @param gridHeight! the height of the grid
     */
    public static void setGridHeight(int gridHeight) {
        Wege.gridHeight = gridHeight;
    }

    /**
     * Sets the width of the grid
     * @param gridLength! the width of the grid
     */
    public static void setGridLength(int gridLength) {
        Wege.gridLength = gridLength;
    }

    /**
     * Sets the number of land cards in the deck
     * @param landCard the number of land cards in the deck
     */
    public static void setLandCard(int landCard) {
        Wege.landCard = landCard;
    }

    /**
     * Sets the number of water cards in the deck
     * @param waterCard the number of water cards in the deck
     */
    public static void setWaterCard(int waterCard) {
        Wege.waterCard = waterCard;
    }

    /**
     * Sets the number of land cards with land gnomes in the deck
     * @param landLandGnome the number of land cards with land gnomes in the deck
     */
    public static void setLandLandGnome(int landLandGnome) {
        Wege.landLandGnome = landLandGnome;
    }

    /**
     * Sets the number of land cards with water gnomes in the deck
     * @param landWaterGnome the number of land cards with water gnomes in the deck
     */
    public static void setLandWaterGnome(int landWaterGnome) {
        Wege.landWaterGnome = landWaterGnome;
    }

    /**
     * Sets the number of water cards with water gnomes in the deck
     * @param waterWaterGnome the number of water cards with water gnomes in the deck
     */
    public static void setWaterWaterGnome(int waterWaterGnome) {
        Wege.waterWaterGnome = waterWaterGnome;
    }

    /**
     * Sets the number of water cards with land gnomes in the deck
     * @param waterLandGnome the number of water cards with land gnomes in the deck
     */
    public static void setWaterLandGnome(int waterLandGnome) {
        Wege.waterLandGnome = waterLandGnome;
    }

    /**
     * Sets the number of cossack cards in the deck
     * @param cossackCard the number of cossack cards in the deck
     */
    public static void setCossackCard(int cossackCard) {
        Wege.cossackCard = cossackCard;
    }

    /**
     * Sets the number of bridge cards in the deck
     * @param bridgeCard the number of bridge cards in the deck
     */
    public static void setBridgeCard(int bridgeCard) {
        Wege.bridgeCard = bridgeCard;
    }

    /**
     * Creates an array of the desired size that will be the game's board
     * Every button in the board will be a WegeButton
     * @return array of WegeButtons that is the size of the board
     */
    public WegeButton[][] createBoard() {

        // create a new board 
        WegeButton[][] board = new WegeButton[getGridLength()][getGridHeight()];

        // create a two-dimensional array of WegeButtons
        for (int i = 0; i < getGridLength(); i++) {
            for (int count = 0; count < getGridHeight(); count++) {
                board[i][count] = new WegeButton(500/getGridHeight(), 500/getGridHeight());
            }
        }

        // return the board
        return board;

    }

    /**
     * Creates the entry point for the application to be run
     * @param  primaryStage layout to display onto the Application
     */
    public void start(Stage primaryStage) {
        
        // create a GridPane and add the WegeButtons to the grid        
        GridPane layout = new GridPane();
        for (int i = 0; i < getGridLength(); i++) {
            for (int count = 0; count < getGridHeight(); count++) {
                layout.add(gameBoard[i][count], i, count);
            }
        }

        // create a WegeButton and Labels, and add it using a FlowPane
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 0.0, 0.0);
        Label directions = new Label("Click the tile to select and rotate a card");
        pane.getChildren().add(directions);
        pane.getChildren().add(nextCard);
        pane.getChildren().add(turnIndicator);
        layout.add(pane, 0, gridHeight);
        GridPane.setColumnSpan(pane, gridLength);
        GridPane.setValignment(pane, VPos.CENTER);

        // create a LinkedList that will store all of the shuffled cards
        LinkedList<WegeCard> cardDeck = new LinkedList<WegeCard>();

        // create an ArrayList that will store the unshuffled instances of the cards
        List<WegeCard> arrayOfCards = new ArrayList<WegeCard>();
        
        // add desired number of land w/o gnomes cards to the list
        for (int i = 0; i < getLandCard(); i++) {
            arrayOfCards.add(new WegeCard(WegeCard.CardType.LAND, false, false));
        }

        // add desired number of water w/o gnomes cards to the list
        for (int i = 0; i < getWaterCard(); i++) {
            arrayOfCards.add(new WegeCard(WegeCard.CardType.WATER, false, false));
        }

        // add desired number of land cards with a land gnome on the path to the list
        for (int i = 0; i < getLandLandGnome(); i++) {
            arrayOfCards.add(new WegeCard(WegeCard.CardType.LAND, true, true));
        }

        // add desired number of land cards with a water gnome on one of the water corners to the list
        for (int i = 0; i < getLandWaterGnome(); i++) {
            arrayOfCards.add(new WegeCard(WegeCard.CardType.LAND, true, false));
        }

        // add desired number of water cards with a water gnome on the stream to the list
        for (int i = 0; i < getWaterWaterGnome(); i++) {
            arrayOfCards.add(new WegeCard(WegeCard.CardType.WATER, true, true));
        }

        // add desired number of water cards with a land gnome on one of the land corners to the list
        for (int i = 0; i < getWaterLandGnome(); i++) {
            arrayOfCards.add(new WegeCard(WegeCard.CardType.WATER, true, false));
        }

        // add desired number of cossack cards to the list
        for (int i = 0; i < getCossackCard(); i++) {
            arrayOfCards.add(new WegeCard(WegeCard.CardType.COSSACK, false, false));
        }

        // add desired number of bridge cards to the list
        for (int i = 0; i < getBridgeCard(); i++) {
            arrayOfCards.add(new WegeCard(WegeCard.CardType.BRIDGE, false, false));
        }

        // shuffle the cards in the ArrayList
        Collections.shuffle(arrayOfCards);

        // add in the shuffled cards from the ArrayList to the LinkedList
        for (WegeCard card : arrayOfCards) {
            cardDeck.addToEnd(card);
        }

        /**
         * Create a set of actions that will run if the button in the FlowPane was clicked
         */
        nextCard.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            /**
             * Overrides the handle method from EventHandler
             * @param  e the ActionEvent for the button that was clicked
             */
            public void handle(ActionEvent e) {

                // adds a card to the button if there isn't one there already
                if (nextCard.getCard() == null) {
                    nextCard.setCard(cardDeck.getFirstNode().getElement());
                    cardDeck.removeFromFront();
                }

                // rotate the card in the button if there is a card there
                else {
                    nextCard.rotate();
                }

            }

        });

        /**
         * have each button on the board run the same actions
         */
        for (int i = 0; i < gridLength; i++) {
            for (int count = 0; count < gridHeight; count++) {
                gameBoard[i][count].setOnAction(new ButtonAction());
            }
        }

        // name the window, add the layout to the Scene, set the Stage, and display the Stage
        primaryStage.setTitle("Wege (Landlock)");
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * class which runs the necessary actions if a button on the board is clicked
     */
    private class ButtonAction implements EventHandler<ActionEvent> {

        /** Stores the x-coordinate of the button that was clicked on the board */
        private int buttonXPos;

        /** Stores the y-coordinate of the button that was clicked on the board */
        private int buttonYPos;

        /** determines whether the move that the players wants to make is legal */
        private boolean legalMove = true;

        /** determines how many gnomes are acing each other */
        private int gnomeCount = 0;

        /**
         * Returns the x-coordinate of the button that was clicked
         * @return the x-coordinate of the button that was clicked
         */
        private int getButtonXPos() {
            return buttonXPos;
        }

        /**
         * Returns the y-coordinate of the button that was clicked
         * @return the y-coordinate of the button that was clicked
         */
        private int getButtonYPos() {
            return buttonYPos;
        }

        /**
         * Returns whether the move that the players wants to make is legal
         * @return whether the move that the players wants to make is legal
         */
        private boolean getLegalMove() {
            return legalMove;
        }

        /**
         * Returns the number of gnomes facing each other
         * @return the number of gnomes facing each other
         */
        private int getGnomeCount() {
            return gnomeCount;
        }

        /**
         * Sets the x-coordinate of the button that was clicked
         * @param buttonXPos the x-coordinate of the button that was clicked
         */
        private void setButtonXPos(int buttonXPos) {
            this.buttonXPos = buttonXPos;
        }

        /**
         * Sets the y-coordinate of the button that was clicked
         * @param buttonYPos the y-coordinate of the button that was clicked
         */
        private void setButtonYPos(int buttonYPos) {
            this.buttonYPos = buttonYPos;
        }

        /**
         * Sets whether the move that the players wants to make is legal
         * @param legalMove whether the move that the players wants to make is legal
         */
        private void setLegalMove(boolean legalMove) {
            this.legalMove = legalMove;
        }

        /**
         * Sets the number of gnomes facing each other
         * @param gnomeCount the number of gnomes facing each other
         */
        private void setGnomeCount(int gnomeCount) {
            this.gnomeCount = gnomeCount;
        } 

        /**
         * Overrides the handle method from EventHandler
         */
        @Override
        public void handle(ActionEvent e) {

            // get a reference to the button that was clicked
            WegeButton button = (WegeButton)e.getSource();

            // return the position of the button that was clicked on the board
            getButtonPosition(button);

            // set the indicator to be true at the beginning of every click
            setLegalMove(true);

            // do nothing if there is no card to play
            if (nextCard.getCard() == null) {
                // do nothing
            }

            // run the following actions if the card that is being played is a bridge card and is a legal move
            else if (nextCard.getCard().getCardType() == WegeCard.CardType.BRIDGE && isBridgeLegal() ) {
                
                // 1. create a temp variable to store the board card
                WegeCard temp = button.getCard();

                // 2. set the board card to be the nextCard
                button.setCard(nextCard.getCard());

                // 3. keep the same orientation
                button.setAlignment(nextCard.getCard().getOrientation());

                // 4. set the nextCard to be the saved card
                nextCard.setCard(temp);

                // 5. change the turn indicator
                if (cardsPlayed % 2 == 0) {
                    turnIndicator.setText("WATER's turn");
                }
                else {
                    turnIndicator.setText("LAND's turn");
                }

                // 6. increment the number of cards played
                cardsPlayed = cardsPlayed + 1;

            }

            // run the following actions if the button in the FlowPane has a card in it and is a legal move
            else if (nextCard.getCard() != null && isLegal()) {
                
                // 1. set the board button to be the same as the next card button
                button.setCard(nextCard.getCard());

                // 2. keep the same orientation
                button.setAlignment(nextCard.getCard().getOrientation());

                // 3. make the next card button empty
                nextCard.setCard(null);

                // 4. change the turn indicator
                if (cardsPlayed % 2 == 0) {
                    turnIndicator.setText("WATER's turn");
                }
                else {
                    turnIndicator.setText("LAND's turn");
                }

                // 5. increment the number of cards played
                cardsPlayed = cardsPlayed + 1;

            }

            else {
                // do nothing
            }
        
        }

        

        /**
         * finds the x and y-coordinate of the button that was clicked on the grid
         * @param button the reference to the actual button that was clicked
         */
        private void getButtonPosition(WegeButton button) {

            // scan the array to find which card corresponds
            for (int i = 0; i < getGridLength(); i++) {
                for (int count = 0; count < getGridHeight(); count++) {
                    if (gameBoard[i][count].equals(button)) {
                        setButtonXPos(i);
                        setButtonYPos(count);
                    }
                }
            }

        }

        /**
         * Checks to see if the move being made is legal or not
         * @return a boolean representing whether or not the move is legal
         */
        private boolean isLegal() {

            // make sure that at least one card has been played and that the button that was pressed does not have a card already
            if (cardsPlayed != 0 && gameBoard[getButtonXPos()][getButtonYPos()].getCard() == null) {
                
                // check cards not on the edge of the board
                if ((getButtonXPos() > 0 && getButtonXPos() < getGridLength() - 1) && (getButtonYPos() > 0 && getButtonYPos() < getGridHeight() - 1)) {
                    
                    // check to see if there is a card around the button
                    if (gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard() == null) {
                        setLegalMove(false);
                    }
                    
                    // check left side
                    checkLeft();

                    // check right
                    checkRight();
                
                    // check below
                    checkBelow();

                    // check above
                    checkAbove();
                    
                }

                // check card in top left corner of board
                else if (getButtonXPos() == 0 && getButtonYPos() == 0) {
                    
                    // check to see if there is a card around the button
                    if (gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard() == null) {
                        setLegalMove(false);
                    }

                    // check below
                    checkBelow();

                    // check right
                    checkRight();

                }

                // check card in top right corner of board
                else if (getButtonXPos() == getGridLength() - 1 && getButtonYPos() == 0) {

                    // check to see if there is a card around the button
                    if (gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard() == null) {
                        setLegalMove(false);
                    }

                    // check left side
                    checkLeft();

                    // check below
                    checkBelow();

                }

                // check card in bottom left corner of board
                else if (getButtonXPos() == 0 && getButtonYPos() == getGridHeight() - 1) {

                    // check to see if there is a card around the button
                    if (gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard() == null) {
                        setLegalMove(false);
                    }

                    // check above
                    checkAbove();

                    // check right
                    checkRight();

                }

                // check card in bottom right corner of board
                else if (getButtonXPos() == getGridLength() - 1 && getButtonYPos() == getGridHeight() - 1) {

                    // check to see if there is a card around the button
                    if (gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard() == null) {
                        setLegalMove(false);
                    }

                    // check above
                    checkAbove();

                    // check left side
                    checkLeft();

                }
                
                // check cards on left edge
                else if (getButtonXPos() == 0 && (getButtonYPos() > 0 && getButtonYPos() < getGridHeight() - 1)) {

                    // check to see if there is a card around the button
                    if (gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard() == null) {
                        setLegalMove(false);
                    }

                    // check above
                    checkAbove();

                    // check below
                    checkBelow();

                    // check right
                    checkRight();

                }

                // check cards on right edge
                else if (getButtonXPos() == getGridLength() - 1 && (getButtonYPos() > 0 && getButtonYPos() < getGridHeight() - 1)) {
                    
                    // check to see if there is a card around the button
                    if (gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard() == null) {
                        setLegalMove(false);
                    }

                    // check above
                    checkAbove();

                    // check left side
                    checkLeft();

                    // check below
                    checkBelow();

                }
                
                // check cards on top edge
                else if ((getButtonXPos() > 0 && getButtonXPos() < getGridLength() - 1) && getButtonYPos() == 0) {

                    // check to see if there is a card around the button
                    if (gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard() == null) {
                        setLegalMove(false);
                    }

                    // check left side
                    checkLeft();

                    // check below
                    checkBelow();

                    // check right
                    checkRight();

                }

                // check cards on bottom edge
                else if ((getButtonXPos() > 0 && getButtonXPos() < getGridLength() - 1) && getButtonYPos() == getGridHeight() - 1) {

                    // check to see if there is a card around the button
                    if (gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard() == null && gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard() == null) {
                        setLegalMove(false);
                    }
                    
                    // check above
                    checkAbove();
                    
                    // check left side
                    checkLeft();

                    // check right
                    checkRight();

                }

                else {

                    // if none of the conditions are met, then this is not a legal move
                    setLegalMove(false);

                }

                return getLegalMove();

            }

            // if no cards have been played yet, the move is legal
            else if (cardsPlayed == 0) {

                return getLegalMove();

            }
            
            // if none of the requirements are met, then the move is not legal
            else {

                setLegalMove(false);
                return getLegalMove();

            }

        }

        /**
         * Checks to see if the move using a bridge card being made is legal 
         * @return a boolean representing whether or not the move is legal
         */
        private boolean isBridgeLegal() {
           
            /**
             * 1. return false if card to replace is cossack
             * 2. return false if replacing card with gnomes "facing" each other
             * 3. check to see if the move is legal otherwise
             */


            // the move will always be legal if there is no card in the position that was clicked
            if (gameBoard[getButtonXPos()][getButtonYPos()].getCard() == null) {

                return isLegal();

            }

            // the move will always be not legal if it is trying to repace a cossack card
            else if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getCardType() == WegeCard.CardType.COSSACK) {
                
                return false;

            }

            // run the following code if the button pressed has a gnome on it
            else if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().hasGnome() == true) {

                // set that there is at least one gnome facing each other
                setGnomeCount(1);

                // check cards not on the edge of the board
                if ((getButtonXPos() > 0 && getButtonXPos() < getGridLength() - 1) && (getButtonYPos() > 0 && getButtonYPos() < getGridHeight() - 1)) {
                
                    // check to see if there is a gnome at the intersection
                    checkGnomeAbove();
                    checkGnomeBelow();
                    checkGnomeLeft();
                    checkGnomeRight();
                    checkGnomeLeftAbove();
                    checkGnomeLeftBelow();
                    checkGnomeRightAbove();
                    checkGnomeRightBelow(); 
                    
                }
                
                // check card in top right corner of board
                else if (getButtonXPos() == getGridLength() - 1 && getButtonYPos() == 0) {
                    
                    // check to see if there is a gnome at the intersection
                    checkGnomeLeft();
                    checkGnomeBelow();
                    checkGnomeLeftBelow();
                    
                }

                // check card in the top left corner of the board
                else if (getButtonXPos() == 0 && getButtonYPos() == 0) {
                    
                    // check to see if there is a gnome at the intersection
                    checkGnomeRight();
                    checkGnomeBelow();
                    checkGnomeRightBelow();
                    
                }
                
                // check card in bottom left corner of board
                else if (getButtonXPos() == 0 && getButtonYPos() == getGridHeight() - 1) {
                    
                    // check to see if there is a gnome at the intersection
                    checkGnomeAbove();
                    checkGnomeRight();
                    checkGnomeRightAbove();
                    
                }
                
                // check card in bottom right corner of board
                else if (getButtonXPos() == getGridLength() - 1 && getButtonYPos() == getGridHeight() - 1) {
                    
                    // check to see if there is a gnome at the intersection
                    checkGnomeAbove();
                    checkGnomeLeft();
                    checkGnomeLeftAbove();
                    
                }
                
                // check cards on left edge
                else if (getButtonXPos() == 0 && (getButtonYPos() > 0 && getButtonYPos() < getGridHeight() - 1)) {
        
                    // check to see if there is a gnome at the intersection
                    checkGnomeAbove();
                    checkGnomeBelow();
                    checkGnomeRight();
                    checkGnomeRightAbove();
                    checkGnomeRightBelow();
                    
                }
        
                // check cards on right edge
                else if (getButtonXPos() == getGridLength() - 1 && (getButtonYPos() > 0 && getButtonYPos() < getGridHeight() - 1)) {
                    
                    // check to see if there is a gnome at the intersection
                    checkGnomeAbove();
                    checkGnomeBelow();
                    checkGnomeLeft();
                    checkGnomeLeftAbove();
                    checkGnomeLeftBelow();
                    
                }
                
                // check cards on top edge
                else if ((getButtonXPos() > 0 && getButtonXPos() < getGridLength() - 1) && getButtonYPos() == 0) {
                    
                    // check to see if there is a gnome at the intersection
                    checkGnomeLeft();
                    checkGnomeRight();
                    checkGnomeBelow();
                    checkGnomeRightBelow();
                    checkGnomeLeftBelow();
                    
                }
                
                // check cards on bottom edge
                else if ((getButtonXPos() > 0 && getButtonXPos() < getGridLength() - 1) && getButtonYPos() == getGridHeight() - 1) {
                    
                    // check to see if there is a gnome at the intersection
                    checkGnomeLeft();
                    checkGnomeRight();
                    checkGnomeAbove();
                    checkGnomeRightAbove();
                    checkGnomeLeftAbove();
                    
                }
                
                // run the following code if there is only 1 gnome at the intersection
                if (getGnomeCount() == 1) {
                    WegeCard temp = gameBoard[getButtonXPos()][getButtonYPos()].getCard();
                    gameBoard[getButtonXPos()][getButtonYPos()].setCard(null);
                    boolean result = isLegal();
                    gameBoard[getButtonXPos()][getButtonYPos()].setCard(temp);
                    return result;
                }
                
                // run the following code if there are 2+ gnomes at the intersection
                else {
                    return getLegalMove();
                }
                
            }
            
            // run the following code if the button pressed does not have a gnome on it
            else {
                WegeCard temp = gameBoard[getButtonXPos()][getButtonYPos()].getCard();
                gameBoard[getButtonXPos()][getButtonYPos()].setCard(null);
                boolean result = isLegal();
                gameBoard[getButtonXPos()][getButtonYPos()].setCard(temp);
                return result;
            }
            
        }
        
        /**
         * Checks the card to the right to see if there is an adjacent gnome for the current card
         * Method will change an indicator if the move is not legal
         */
        private void checkGnomeRight() {
            
            // only check if there is a card exists and it has a gnome
            if (gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard() != null && gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard().hasGnome()) {
                
                // check if there is an adjacent gnome when the current card's gnome is in the top right
                if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.TOP_RIGHT) {
                    
                    if (gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard().getGnomePosition() == Pos.TOP_LEFT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }

                // check is there is an adjacent gnome when the current card's gnome is in the bottom right
                else if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.BOTTOM_RIGHT) {
                    
                    if (gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard().getGnomePosition() == Pos.BOTTOM_LEFT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }
                
            }
            
        }
        
        /**
         * Checks the card to the left to see if there is an adjacent gnome for the current card
         * Method will change an indicator if the move is not legal
         */
        private void checkGnomeLeft() {
            
            // only check if a card exists and it has a gnome
            if (gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard() != null && gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard().hasGnome()) {
                
                // check if there is an adjacent gnome when the current card's gnome is in the top left
                if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.TOP_LEFT) {
                    
                    if (gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard().getGnomePosition() == Pos.TOP_RIGHT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }

                // check if there is an adjacent gnome when the current card's gnome is in the bottom left
                else if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.BOTTOM_LEFT) {
                    
                    if (gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard().getGnomePosition() == Pos.BOTTOM_RIGHT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }

            }

        }

        /**
         * Checks the above card to see if there is an adjacent gnome for the current card
         * Method will change an indicator if the move is not legal
         */
        private void checkGnomeAbove() {
            
            // only check if a card exists and it has a gnome
            if (gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard() != null && gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard().hasGnome()) {

                // check if there is an adjacent gnome when the current card's gnome is in the top left
                if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.TOP_LEFT) {
                    
                    if (gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard().getGnomePosition() == Pos.BOTTOM_LEFT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }

                // check if there is an adjacent gnome when the current card's gnome is in the top right
                else if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.TOP_RIGHT) {
                    
                    if (gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard().getGnomePosition() == Pos.BOTTOM_RIGHT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }

            }

        }

        /**
         * Checks the below card to see if there is an adjacent gnome for the current card
         * Method will change an indicator if the move is not legal
         */
        private void checkGnomeBelow() {

            // only check if a card exists and it has a gnome
            if (gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard() != null && gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard().hasGnome()) {

                // check if there is an adjacent gnome when the current card's gnome is in the bottom left
                if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.BOTTOM_LEFT) {
                    
                    if (gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard().getGnomePosition() == Pos.TOP_LEFT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }

                // check if there is an adjacent gnome when the current card's gnome is in the bottom right
                else if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.BOTTOM_RIGHT) {
                    
                    if (gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard().getGnomePosition() == Pos.TOP_RIGHT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }

            }

        }

        /**
         * Checks the card to the left and above to see if there is an adjacent gnome for the current card
         * Method will change an indicator if the move is not legal
         */
        private void checkGnomeLeftAbove() {

            // only check if a card exists and it has a gnome
            if (gameBoard[getButtonXPos() - 1][getButtonYPos() - 1].getCard() != null && gameBoard[getButtonXPos() - 1][getButtonYPos() - 1].getCard().hasGnome()) {

                // check if there is a diagonal gnome when the gnome's current position is in the top left
                if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.TOP_LEFT) {
                    
                    if (gameBoard[getButtonXPos() - 1][getButtonYPos() - 1].getCard().getGnomePosition() == Pos.BOTTOM_RIGHT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }

            }            
            
        }

        /**
         * Checks the card to the left and below to see if there is an adjacent gnome for the current card
         * Method will change an indicator if the move is not legal
         */
        private void checkGnomeLeftBelow() {

            // only check if a card exists and it has a gnome
            if (gameBoard[getButtonXPos() - 1][getButtonYPos() + 1].getCard() != null && gameBoard[getButtonXPos() - 1][getButtonYPos() + 1].getCard().hasGnome()) {

                // check if there is a diagonal gnome when the gnome's current position is in the bottom left
                if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.BOTTOM_LEFT) {
                    
                    if (gameBoard[getButtonXPos() - 1][getButtonYPos() + 1].getCard().getGnomePosition() == Pos.TOP_RIGHT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }

            }  

        }

        /**
         * Checks the card to the right and above to see if there is an adjacent gnome for the current card
         * Method will change an indicator if the move is not legal
         */
        private void checkGnomeRightAbove() {

            // only check if a card exists and it has a gnome
            if (gameBoard[getButtonXPos() + 1][getButtonYPos() - 1].getCard() != null && gameBoard[getButtonXPos() + 1][getButtonYPos() - 1].getCard().hasGnome()) {

                // check if there is a diagonal gnome when the gnome's current position is in the top right
                if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.TOP_RIGHT) {

                    if (gameBoard[getButtonXPos() + 1][getButtonYPos() - 1].getCard().getGnomePosition() == Pos.BOTTOM_LEFT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }

            } 

        }

        /**
         * Checks the card to the right and below to see if there is an adjacent gnome for the current card
         * Method will change an indicator if the move is not legal
         */
        private void checkGnomeRightBelow() {

            // only check if a card exists and it has a gnome
            if (gameBoard[getButtonXPos() + 1][getButtonYPos() + 1].getCard() != null && gameBoard[getButtonXPos() + 1][getButtonYPos() + 1].getCard().hasGnome()) {

                // check if there is a diagonal gnome when the gnome's current position is in the bottom right
                if (gameBoard[getButtonXPos()][getButtonYPos()].getCard().getGnomePosition() == Pos.BOTTOM_RIGHT) {
                   
                    if (gameBoard[getButtonXPos() + 1][getButtonYPos() + 1].getCard().getGnomePosition() == Pos.TOP_LEFT) {
                        setLegalMove(false);
                        setGnomeCount(getGnomeCount() + 1);
                    }

                }

            } 

        }       

        /**
         * Check to see if the clicked card's bottom side matches the corners
         */
        private void checkBelow() {

            // only check if the adjacent card exists
            if (gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard() != null) {
                
                // if the clicked card's bottom right corner and the card below it's corner don't match, then this is not a legal move
                if (!(gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard().isLand(Pos.TOP_RIGHT) == nextCard.getCard().isLand(Pos.BOTTOM_RIGHT) || gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard().isWater(Pos.TOP_RIGHT) == nextCard.getCard().isWater(Pos.BOTTOM_RIGHT))) {
                    setLegalMove(false);   
                }
                
                // if the clicked card's bottom left corner and the card below it's corner don't match, then this is not a legal move
                if (!(gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard().isLand(Pos.TOP_LEFT) == nextCard.getCard().isLand(Pos.BOTTOM_LEFT) || gameBoard[getButtonXPos()][getButtonYPos() + 1].getCard().isWater(Pos.TOP_LEFT) == nextCard.getCard().isWater(Pos.BOTTOM_LEFT))) {
                    setLegalMove(false);  
                }
            
            }

        }

        /**
         * Check to see if the clicked card's top side matches the corners
         */
        private void checkAbove() {

            // only check if the adjacent card exists
            if (gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard() != null) {
                
                // if the clicked card's top left corner and the card above it's corner don't match, then this is not a legal move
                if (!(gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard().isLand(Pos.BOTTOM_LEFT) == nextCard.getCard().isLand(Pos.TOP_LEFT) || gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard().isWater(Pos.BOTTOM_LEFT) == nextCard.getCard().isWater(Pos.TOP_LEFT))) {
                    setLegalMove(false);   
                }
                            
                // if the clicked card's top right corner and the card above it's corner don't match, then this is not a legal move
                if (!(gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard().isLand(Pos.BOTTOM_RIGHT) == nextCard.getCard().isLand(Pos.TOP_RIGHT) || gameBoard[getButtonXPos()][getButtonYPos() - 1].getCard().isWater(Pos.BOTTOM_RIGHT) == nextCard.getCard().isWater(Pos.TOP_RIGHT))) {
                    setLegalMove(false);   
                }

            }
            
        }

        /**
         * Check to see if the clicked card's left side matches the corners
         */
        private void checkLeft() {

            // only check if the adjacent card exists
            if (gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard() != null) {

                // if the clicked card's top left corner and the card to its left's corner don't match, then this is not a legal move
                if (!(gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard().isLand(Pos.TOP_RIGHT) == nextCard.getCard().isLand(Pos.TOP_LEFT) || gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard().isWater(Pos.TOP_RIGHT) == nextCard.getCard().isWater(Pos.TOP_LEFT))) {
                    setLegalMove(false);   
                }
            
                // if the clicked card's bottom left corner and the card to its left's corner don't match, then this is not a legal move
                if (!(gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard().isLand(Pos.BOTTOM_RIGHT) == nextCard.getCard().isLand(Pos.BOTTOM_LEFT) || gameBoard[getButtonXPos() - 1][getButtonYPos()].getCard().isWater(Pos.BOTTOM_RIGHT) == nextCard.getCard().isWater(Pos.BOTTOM_LEFT))) {
                    setLegalMove(false);   
                }
            
            }
            
        }

        /**
         * Check to see if the clicked card's right side matches the corners 
         */
        private void checkRight() {

            // only check if the adjacent card exists
            if (gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard() != null) {

                // if the clicked card's top right corner and the card to its right's corner don't match, then this is not a legal move
                if (!(gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard().isLand(Pos.TOP_LEFT) == nextCard.getCard().isLand(Pos.TOP_RIGHT) || gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard().isWater(Pos.TOP_LEFT) == nextCard.getCard().isWater(Pos.TOP_RIGHT))) {
                    setLegalMove(false);   
                }
                
                // if the clicked card's bottom right corner and the card to its right's corner don't match, then this is not a legal move
                if (!(gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard().isLand(Pos.BOTTOM_LEFT) == nextCard.getCard().isLand(Pos.BOTTOM_RIGHT) || gameBoard[getButtonXPos() + 1][getButtonYPos()].getCard().isWater(Pos.BOTTOM_LEFT) == nextCard.getCard().isWater(Pos.BOTTOM_RIGHT))) {
                    setLegalMove(false);   
                }

            }
            
        }
    }

    /**
     * Passes on the arguments from the method to the application that is being run
     * Prints a line in the command window if the inputs do not meet certain specifications
     * @param args a series of arguments from the user to change gameplay
     */
    public static void main(String[] args) {
        
        // run the program if there are no arguments that are inputted
        if (args.length == 0) {

            Application.launch(args);
        
        }

        // set the number of specialty cards if one argument is inputted
        else if (args.length == 1) {
            
            // there should only be 1-5 of each type of specialty card in the deck
            if (Integer.parseInt(args[0]) > 0 && Integer.parseInt(args[0]) < 6) {
                
                // set the number of specialty cards
                Wege.setLandLandGnome(Integer.parseInt(args[0]));
                Wege.setLandWaterGnome(Integer.parseInt(args[0]));
                Wege.setWaterLandGnome(Integer.parseInt(args[0]));
                Wege.setWaterWaterGnome(Integer.parseInt(args[0]));
                Wege.setCossackCard(Integer.parseInt(args[0]));
                Wege.setBridgeCard(Integer.parseInt(args[0]));

                // launch the application
                Application.launch(args);
            }

            // print this message if the argument is not within the bounds
            else {

                // print an error message if the input does not meet the requirements
                System.out.println("There are too many specialty cards. Please play with a lower number of specialty cards.");

            }

        }

        // set the size of the board if 2 arguments are inputted
        else if (args.length == 2) {

            // try the following code if there is no exception
            try {

                // set the grid's height to the first input
                if (Integer.parseInt(args[0]) > 0) {
                    Wege.setGridHeight(Integer.parseInt(args[0]));
                }

                // set the grid's width to the second input
                if (Integer.parseInt(args[1]) > 0) {
                    Wege.setGridLength(Integer.parseInt(args[1]));
                }

            }

            // catch any number format exceptions
            catch (NumberFormatException e) {

                // print this line if the arguments do not meet the requirements
                System.out.println("Please only enter integers as arguments.");

            }

            // ensure that the grid is no bigger than 10 x 10
            if (getGridHeight() > 10 || getGridLength() > 10) {

                // print this line if the grid is bigger than these dimensions
                System.out.println("This board is too big. Please create a smaller board.");

            }

            // create more cards if the board has more than 40 spaces
            else if (getGridHeight() * getGridLength() > 40) {

                // set the number of land cards
                Wege.setLandCard((int) ((((getGridHeight() * gridLength) - 16) / 2) + 1.5));

                // set the number of water cards
                Wege.setWaterCard((int) ((((getGridHeight() * gridLength) - 16) / 2) + 1.5));

            }

            // run the application only if the requirements are met
            if (getGridHeight() < 10 && getGridLength() < 10) {
                Application.launch(args);
            }
            
        }

        // set the size of the board and the number of specialty cards if there are 3 inputs
        else if (args.length == 3) {

            // there should be more than one of each specialty card in the deck
            if (Integer.parseInt(args[2]) > 0) {

                // set the number of specialty cards
                Wege.setLandLandGnome(Integer.parseInt(args[2]));
                Wege.setLandWaterGnome(Integer.parseInt(args[2]));
                Wege.setWaterLandGnome(Integer.parseInt(args[2]));
                Wege.setWaterWaterGnome(Integer.parseInt(args[2]));
                Wege.setCossackCard(Integer.parseInt(args[2]));
                Wege.setBridgeCard(Integer.parseInt(args[2]));

            }

            // print this message if the specialty card does not follow the requirements
            else {

                // print an error message if the requirements are not met
                System.out.println("There are not enough specialty cards. Please play with more specialty cards.");

            }

            // try the following code if there are no exceptions
            try {

                // set the grid's height to the first input
                if (Integer.parseInt(args[0]) > 0) {
                    Wege.setGridHeight(Integer.parseInt(args[0]));
                }

                // set the grid's width to the second input
                if (Integer.parseInt(args[1]) > 0) {
                    Wege.setGridLength(Integer.parseInt(args[1]));
                }
            }

            // catch any NumberFormatExceptions
            catch (NumberFormatException e) {

                // print the following line if an error is thrown
                System.out.println("Please only enter integers as arguments.");

            }

            // ensure that the board is smaller than 10 x 10
            if (getGridHeight() > 10 || getGridLength() > 10) {

                // if the requirements are not met then print the following line
                System.out.println("This board is too big. Please create a smaller board.");

            }

            // add more cards if the board is bigger than 40 spaces
            else if (getGridHeight() * getGridLength() > 40) {

                // set the number of land cards
                Wege.setLandCard((int) ((((getGridHeight() * gridLength) - 16) / 2) + 1.5));

                // set the number of water cards
                Wege.setWaterCard((int) ((((getGridHeight() * gridLength) - 16) / 2) + 1.5));

            }

            // launch the application only if the requirements are met
            if (getGridHeight() < 10 && getGridLength() < 10 && Integer.parseInt(args[2]) > 0) {
                Application.launch(args);
            }

        }

        // if there are more than three arguments then print an error message
        else {

            // print an error message if there are too many arguments
            System.out.println("There were too many arguments");

        }
        
    }

}
