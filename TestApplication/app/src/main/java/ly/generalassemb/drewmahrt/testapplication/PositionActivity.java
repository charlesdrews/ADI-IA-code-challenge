package ly.generalassemb.drewmahrt.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PositionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);

        int pos = getIntent().getIntExtra("position", -1);
        TextView text = (TextView)findViewById(R.id.text_view);
        text.setText("Position clicked: "+pos);
    }
}
