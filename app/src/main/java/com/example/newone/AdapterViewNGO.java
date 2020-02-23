package com.example.newone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AdapterViewNGO extends RecyclerView.Adapter<AdapterViewNGO.CreditHolder> {

    private List<NGONameModel> ngoList;
    private Context context;


    String TAG = "AdapterViewNGO";


    public AdapterViewNGO(List<NGONameModel> creditList, Context context) {
        this.ngoList = ngoList;
        this.context = context;
    }


    @Override
    public CreditHolder onCreateViewHolder(ViewGroup viewGroup, int p) {
        View view = LayoutInflater.from( viewGroup.getContext( ) ).inflate( R.layout.item_view
                , null );
        CreditHolder viewHolder = new CreditHolder( view );

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CreditHolder holder, int position) {
        NGONameModel ngoNameModel = ngoList.get( position );

        NGONameModel model = ngoList.get( position );

        holder.name.setText( model.getNgoId( ) + "      " + model.getNgoName( ) );
        holder.emailid.setText( model.getNgoId( ) + "      " + model.getNgoEmail( ) );
        holder.ngotype.setText( model.getNgoId( ) + "      " + model.getNgoNgoType( ) );


     holder.name.setText( ngoNameModel.getNgoName( ) );
    }

    @Override
    public int getItemCount() {
        final int i = null != ngoList ? ngoList.size( ) : 0;
        return i;
    }

    class CreditHolder extends RecyclerView.ViewHolder {
        private TextView name, address,emailid,ngotype;


        public CreditHolder(View itemView) {
            super( itemView );
            this.name = (TextView) itemView.findViewById( R.id.et_ngoname );
            this.emailid = (TextView) itemView.findViewById( R.id.et_emailid );
            this.ngotype = (TextView) itemView.findViewById( R.id.ngotype );


        }
    }


}