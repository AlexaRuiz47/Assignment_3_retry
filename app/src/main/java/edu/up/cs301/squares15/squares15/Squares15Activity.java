package edu.up.cs301.squares15.squares15;

import android.content.DialogInterface;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.widget.Button;
import android.view.View;

/**
 * Created by alexaruiz on 9/22/17.
 * enhacement: all puzzles are solvable
 * */

public class Squares15Activity extends AppCompatActivity implements OnClickListener {
    Button buttons[]  = new Button [16];//creating an array of buttons so I can hold all of my positions.
    Point rc[]= new Point[16];//creating an array of points to be able to use to compare to the original positions of the buttons
    //array is used for checking if the board has been correctly completed
    Button reset;//making button reset(not part of buttons array because I dont want it to move around, want it to be counted separately.



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)//in order to run needs the following software on device
    @Override
    protected void onCreate(Bundle savedInstanceState) {//onCreate method hold main instantiations of objects
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squares15);

        /**all of the following below are created so every spot in my array buttons[16] has a button connected to it
        I set them all equal to the buttons corresponding on the Gui so they could be used as an array but the gui
        would still react*/
        buttons[0] = (Button) findViewById(R.id.one);
        buttons[1] = (Button) findViewById(R.id.two);
        buttons[2] = (Button) findViewById(R.id.three);
        buttons[3] = (Button) findViewById(R.id.four);
        buttons[4] = (Button) findViewById(R.id.five);
        buttons[5] = (Button) findViewById(R.id.six);
        buttons[6] = (Button) findViewById(R.id.seven);
        buttons[7] = (Button) findViewById(R.id.eight);
        buttons[8] = (Button) findViewById(R.id.nine);
        buttons[9] = (Button) findViewById(R.id.ten);
        buttons[10] = (Button) findViewById(R.id.eleven);
        buttons[11] = (Button) findViewById(R.id.twelve);
        buttons[12] = (Button) findViewById(R.id.thirteen);
        buttons[13] = (Button) findViewById(R.id.fourteen);
        buttons[14] = (Button) findViewById(R.id.fifteen);
        buttons[15] = (Button) findViewById(R.id.empty);
        reset = (Button) findViewById(R.id.Reset);


        /** all methods below set an on click listener for the buttons so I can then click on them and move
         * them to empty spot when clicked in the method move below
         */

        buttons[0].setOnClickListener(new View.OnClickListener() {//listener for button one
                @Override
                public void onClick(View v) {
                    move(0);//calls method move


                }
            });

            buttons[1].setOnClickListener(new View.OnClickListener() {//listener for button two
                @Override
                public void onClick(View v) {
                    move(1);//calls method move


                }
            });

            buttons[2].setOnClickListener(new View.OnClickListener() {//listener for button three
                @Override
                public void onClick(View v) {
                    move(2);//calls method move


                }
            });

            buttons[3].setOnClickListener(new View.OnClickListener() {//listener for button four
                @Override
                public void onClick(View v) {
                    move(3);//calls method move


                }
            });

            buttons[4].setOnClickListener(new View.OnClickListener() {//listener for button five
                @Override
                public void onClick(View v) {
                    move(4);//calls method move


                }
            });

            buttons[5].setOnClickListener(new View.OnClickListener() {//listener for button six
                @Override
                public void onClick(View v) {
                    move(5);//calls method move


                }
            });

            buttons[6].setOnClickListener(new View.OnClickListener() {//listener for button seven
                @Override
                public void onClick(View v) {
                    move(6);//calls method move


                }
            });

            buttons[7].setOnClickListener(new View.OnClickListener() {//listener for button eight
                @Override
                public void onClick(View v) {
                    move(7);//calls method move


                }
            });

            buttons[8].setOnClickListener(new View.OnClickListener() {//listener for button nine
                @Override
                public void onClick(View v) {
                    move(8);//calls method move


                }
            });

            buttons[9].setOnClickListener(new View.OnClickListener() {//listener for button ten
                @Override
                public void onClick(View v) {
                    move(9);//calls method move


                }
            });

            buttons[10].setOnClickListener(new View.OnClickListener() {//listener for button eleven
                @Override
                public void onClick(View v) {
                    move(10);//calls method move


                }
            });

            buttons[11].setOnClickListener(new View.OnClickListener() {//listener for button twelve
                @Override
                public void onClick(View v) {
                    move(11);//calls method move


                }
            });

            buttons[12].setOnClickListener(new View.OnClickListener() {//listener for button thirteen
                @Override
                public void onClick(View v) {
                    move(12);//calls method move


                }
            });

            buttons[13].setOnClickListener(new View.OnClickListener() {//listener for button fourteen
                @Override
                public void onClick(View v) {
                    move(13);//calls method move


                }
            });

        buttons[14].setOnClickListener(new View.OnClickListener() {//listener for button fifteen
            @Override
            public void onClick(View v) {
                move(14);//calls method move


            }
        });
        buttons[15].setOnClickListener(new View.OnClickListener() {//listener for button fifteen
            @Override
            public void onClick(View v) {
                move(15);//calls method move


            }
        });
            //reset is the only button that is not called on and used in the move method but rather in the "inClick" method
            reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inClick(v);//calls method inClick

            }
        });

        random();//calls random method so that when the code runs the buttons should already be randomize


        /** When method is run will look through all the spaces on the grid and if any of the buttons are in the original placing of the
         * buttons before randomizing then they are colored differently through the correct method to show that
         */
        for (int i = 0; i <16; i++) {

            correct(i);
        }
    }

    private int blankPosition = 15;//instantiating an int fo the method used below

    /**
     * method below gets and sets the text of the empty button and switches that along with the background color depending
     * if it is found in the correct spacing or not.
     * @param index
     */
    public void move(int index) {

        String bText = buttons[index].getText().toString();//creates a string for the buttons and gets the text inside(that being a number) and turns it into a string
        buttons[blankPosition].setText(bText);//sets the black position's text in this case being buttons[15] and replaces it with the text of the button found above
        buttons[index].setText("");//sets the text of the button that was clicked to empty
        buttons[blankPosition].setBackgroundColor(Color.rgb(223,175,251));//sets the color of the background to match the others
        blankPosition = index;

        for (index = 0; index<16; index++){//for loop created to go through all the indexes and when move will show it they are in the right place by changing colors
            correct(index);
        }
        }



    /**
     * method below calls on the reset button and the method Random so that when the button reset is clicked it
     * will randomize all the buttons so the player may restart the game after it is finished
     * @param v
     */

        public void inClick(View v) {

            if (v.equals(reset))//if the reset button is clicked then do following below

            {
                random();//calls method random
            }
        }

    /**
     * method uses a for look of int i to go through 200 possible values of int for the placement of the buttons
     *
     */

            public void random(){
                int i;
                for( i = 0; i <200; i++){
                    int num;

                   num = (int)(Math.random()*16);
                    /**because the random number generator is multiplied by 16 and the game starts off
                     * being in an already solved state this makes every randomized option that it gives SOLVABLE
                    */
                    move(num);//goes back to the method move and uses the new int as a paramter for the next positions of the buttons

                }

            }

    /**
     * method created in order to check if buttons are in the right position so that the user knows when they have one
     * @param index
     */
    public void correct (int index) {
               Button check = buttons[index];//button check is equal to the index of the button selected
                String one = "" + check.getText();//creating two string one for each of the squares text
                String two = "" +(index+ 1);

                if(one.equals(two)) {//if string one is equal to string two then do the following
                    check.setBackgroundColor(Color.rgb(14,47,68));//setting the background colow depending on if its right or wrong
                }

                else if(! check.getText().equals(buttons[blankPosition])) {//if not then do the following and keep it the same as before
                    check.setBackgroundColor(Color.rgb(223,175,251));

                }

            }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }

}