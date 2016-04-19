package ly.generalassemb.drewmahrt.testapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Rather than hardcode the key when adding the position of the item clicked to the intent
    // below, use this constant to avoid errors if the hardcoded value is changed.
    public static final String POSITION_KEY = "position_key";

    String [] mStatesArray;
    BaseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStatesArray = getResources().getStringArray(R.array.states);

        ListView listView = (ListView)findViewById(R.id.list_view);

        TextView emptyText = (TextView)findViewById(R.id.emptyText);
        listView.setEmptyView(emptyText);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatesArray = new String[]{};

                // The original code did not notify the adapter after changing the underlying data.
                // To do this, the notifyDataSetChanged() method must be called, then the adapter
                // will update the list view to reflect the change.
                mAdapter.notifyDataSetChanged();
            }
        });

        mAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mStatesArray.length;
            }

            @Override
            public Object getItem(int position) {
                return mStatesArray[position];
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view;

                if (convertView == null){
                    convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_view_item, parent, false);
                }

                view = convertView;

                TextView text1 = (TextView) view.findViewById(R.id.state);

                // This extra text view is not necessary
                //TextView text2 = (TextView) view.findViewById(R.id.state);

                text1.setText(mStatesArray[position]);

                // This extra text view is not necessary
                //text2.setText(mStatesArray[position]);

                return view;
            }
        };

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,PositionActivity.class);

                // the original code did not send the position of the item clicked to the
                // PositionActivity. In order to do that, the data must be added to the
                // intent as an extra. In this case I added 1 so that the position shown in
                // PositionActivity is based at 1 rather than 0 to be more user friendly.
                intent.putExtra(POSITION_KEY, position + 1);

                startActivity(intent);
            }
        });
    }

}
