package alidoran.ir.learnrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List <LearnModel> learnModelList = new ArrayList <> ( );
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        recyclerView = findViewById ( R.id.recyclerview );
        adapter = new LearnAdapter ( learnModelList , this );
        recyclerView.setLayoutManager ( new GridLayoutManager ( this , 2 ) );
        recyclerView.setAdapter ( adapter );
        setdata ( );

    }

    private void setdata ( ) {
        for (int i = 0; i < 300; i++) {
            LearnModel learnModel = new LearnModel ( );
            learnModelList.add ( learnModel );
            learnModel.setModel ( i + " = i" );
            adapter.notifyDataSetChanged ( );
        }
    }
}
