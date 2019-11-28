package luxurious.studios.moodscanner;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView resultText;
    private String[] moodResults = {"You are Happy", "Someone has made you angry", "You are feeling hungry", "Excited!", "You feel blessed", "You are worried about something"};

    private final Random rand = new Random();

    Boolean changeColors = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img);
        resultText = findViewById(R.id.result);


        imageView.setBackgroundColor(getResources().getColor(R.color.color1));

        //List when imageview has been pressed for long
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                changeColors = true;

                resultText.setText("");
                showResult();

                return false;
            }
        });

    }

    public void showResult() {

        //Display Changing color animation
        changeColor();
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int random = rand.nextInt(moodResults.length);
                resultText.setText(moodResults[random]);
                changeColors = false;

                //Reset the background color of the imageview back to the original color
                imageView.setBackgroundColor(getResources().getColor(R.color.color1));

            }
        }, 5000);


    }

    public void changeColor() {

        if (changeColors) {
            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    int randomColor = rand.nextInt(5);
                    switch (randomColor) {

                        case 0:
                            imageView.setBackgroundColor(getResources().getColor(R.color.color1));

                            break;

                        case 1:
                            imageView.setBackgroundColor(getResources().getColor(R.color.color2));

                            break;

                        case 2:
                            imageView.setBackgroundColor(getResources().getColor(R.color.color3));

                            break;

                        case 3:
                            imageView.setBackgroundColor(getResources().getColor(R.color.color4));

                            break;

                        case 4:
                            imageView.setBackgroundColor(getResources().getColor(R.color.color5));

                            break;


                    }

                    changeColor();

                }
            }, 100);

        }

    }


}



