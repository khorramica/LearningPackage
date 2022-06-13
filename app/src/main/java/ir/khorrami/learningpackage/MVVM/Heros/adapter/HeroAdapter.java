package ir.khorrami.learningpackage.MVVM.Heros.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.khorrami.learningpackage.MVVM.Heros.model.Heros;
import ir.khorrami.learningpackage.R;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {

    Context context;
    List<Heros> data;

    public HeroAdapter(Context context, List<Heros> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_heros, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        holder.txtHeroName.setText(data.get(position).getName());
        Picasso.get().load(data.get(position).getImageurl()).into(holder.imgHeroImage);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class HeroViewHolder extends RecyclerView.ViewHolder {

        TextView txtHeroName;
        ImageView imgHeroImage;

        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);

            txtHeroName = itemView.findViewById(R.id.txt_HeroName);
            imgHeroImage = itemView.findViewById(R.id.img_HeroImage);
        }
    }
}
