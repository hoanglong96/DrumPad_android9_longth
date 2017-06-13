package school.coding.techkids.drumpads_android9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ImageView> listButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        listButtons = new ArrayList<>();
        listButtons.add((ImageView) findViewById(R.id.bt_1));
        listButtons.add((ImageView) findViewById(R.id.bt_2));
        listButtons.add((ImageView) findViewById(R.id.bt_3));
        listButtons.add((ImageView) findViewById(R.id.bt_4));
        listButtons.add((ImageView) findViewById(R.id.bt_5));
        listButtons.add((ImageView) findViewById(R.id.bt_6));
        listButtons.add((ImageView) findViewById(R.id.bt_7));
        listButtons.add((ImageView) findViewById(R.id.bt_8));
        listButtons.add((ImageView) findViewById(R.id.bt_9));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        for (ImageView imageView : listButtons) {
            if (isInside(event.getX(), event.getY(), imageView)) {
                imageView.setBackgroundResource(R.drawable.custom_btn1);
                if (imageView.getTag().equals("2")) {
                    imageView.setBackgroundResource(R.drawable.custom_btn2);
                } else if (imageView.getTag().equals("3")) {
                    imageView.setBackgroundResource(R.drawable.custom_btn3);
                } else if (imageView.getTag().equals("4")) {
                    imageView.setBackgroundResource(R.drawable.custom_btn4);
                } else if (imageView.getTag().equals("5")) {
                    imageView.setBackgroundResource(R.drawable.custom_btn5);
                } else if (imageView.getTag().equals("6")) {
                    imageView.setBackgroundResource(R.drawable.custom_btn6);
                } else if (imageView.getTag().equals("7")) {
                    imageView.setBackgroundResource(R.drawable.custom_btn7);
                } else if (imageView.getTag().equals("8")) {
                    imageView.setBackgroundResource(R.drawable.custom_btn8);
                } else if (imageView.getTag().equals("9")) {
                    imageView.setBackgroundResource(R.drawable.custom_btn9);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    imageView.setBackgroundResource(R.drawable.custom_default);
                }
            }
        }
        for (ImageView imageView : listButtons) {
            if (!isInside(event.getX(), event.getY(), imageView)) {
                imageView.setBackgroundResource(R.drawable.custom_default);
            }
        }
        return super.onTouchEvent(event);
    }

    public boolean isInside(float x, float y, View v) {
        int[] location = new int[2];
        v.getLocationOnScreen(location);

        int left = location[0];
        int top = location[1];
        int right = left + v.getWidth();
        int bot = top + v.getHeight();
        return x > left && x < right && y > top && y < bot;
    }
}
