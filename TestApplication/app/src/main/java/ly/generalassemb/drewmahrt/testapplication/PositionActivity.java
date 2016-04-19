package ly.generalassemb.drewmahrt.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PositionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);

        // Rather than hardcode the key name, use the constant defined in MainActivity so as to
        // avoid errors in the future if the hardcoded value is changed.
        //int pos = getIntent().getIntExtra("position", -1);
        int pos = getIntent().getIntExtra(MainActivity.POSITION_KEY, -1);

        TextView text = (TextView)findViewById(R.id.text_view);
        text.setText("Position clicked: "+pos);
    }
}
