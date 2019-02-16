package alidoran.ir.learnrecyclerview;

import android.content.Context;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.ViewHolder> {

    private List <LearnModel> learnModelList;
    private Context myContext;

    LearnAdapter(List <LearnModel> learnModelList , Context myContext){
        this.myContext=myContext;
        this.learnModelList=learnModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder ( @NonNull ViewGroup viewGroup , int i ) {
        View view = LayoutInflater.from ( myContext ).inflate ( R.layout.model , viewGroup ,false );
        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder viewHolder , final int i ) {
        LearnModel learnModel = learnModelList.get ( i );
        viewHolder.txt_model.setText ( learnModel.getModel () );

        //for click
        viewHolder.lin_model.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                Toast.makeText ( myContext , i + "" , Toast.LENGTH_LONG ).show ();
            }
        } );
    }

    @Override
    public int getItemCount ( ) {
        return learnModelList.size ();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_model;
        LinearLayout recyclelayout;

        LinearLayout lin_model; //for click

        ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            txt_model = itemView.findViewById ( R.id.txt_model );
            recyclelayout = itemView.findViewById ( R.id.recyclerview );

            lin_model = itemView.findViewById ( R.id.lin_model ); //for click
        }
    }
}
