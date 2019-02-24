package cristina.asensio.marvelhero.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cristina.asensio.marvelhero.R;
import cristina.asensio.marvelhero.model.Comic;
import cristina.asensio.marvelhero.model.Thumbnail;

public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ViewHolder> {

    // dummy data until we get the real one from the server
    List<Comic> comics = Arrays.asList(
            new Comic("Mighty Thor Vol. 5: The Death of the Mighty Thor", "The death of the Mighty Thor! The final judgment comes as the Mangog arrives.", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/3/d0/5bf4913d84581", "jpg")),
            new Comic("Marvel Super Hero Adventures: Captain Marvel - Mealtime Mayhem (2018)", "Not just one but two teams with godlike creative talents grace the latest Marvel Masterworks!", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/5/f0/5bdb6980a4113", "jpg")),
            new Comic("Avengers (2018)", "The Queen of Cinders and her fire goblin army have invaded the land of the dead", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/6/50/5c083b7261c9c", "jpg")),
            new Comic("Marvel Masterworks: The Mighty Thor Vol. 17", "Not just one but two teams with godlike creative talents grace the latest Marvel Masterworks! ", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/c/f0/5be5fae78943b", "jpg")),
            new Comic("Mighty Thor Vol. 5: The Death of the Mighty Thor", "The death of the Mighty Thor! The final judgment comes as the Mangog arrives.", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/3/d0/5bf4913d84581", "jpg")),
            new Comic("Marvel Super Hero Adventures: Captain Marvel - Mealtime Mayhem (2018)", "Not just one but two teams with godlike creative talents grace the latest Marvel Masterworks!", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/5/f0/5bdb6980a4113", "jpg")),
            new Comic("Avengers (2018)", "The Queen of Cinders and her fire goblin army have invaded the land of the dead", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/6/50/5c083b7261c9c", "jpg")),
            new Comic("Marvel Masterworks: The Mighty Thor Vol. 17", "Not just one but two teams with godlike creative talents grace the latest Marvel Masterworks! ", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/c/f0/5be5fae78943b", "jpg")),
            new Comic("Mighty Thor Vol. 5: The Death of the Mighty Thor", "The death of the Mighty Thor! The final judgment comes as the Mangog arrives.", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/3/d0/5bf4913d84581", "jpg")),
            new Comic("Marvel Super Hero Adventures: Captain Marvel - Mealtime Mayhem (2018)", "Not just one but two teams with godlike creative talents grace the latest Marvel Masterworks!", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/5/f0/5bdb6980a4113", "jpg")),
            new Comic("Avengers (2018)", "The Queen of Cinders and her fire goblin army have invaded the land of the dead", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/6/50/5c083b7261c9c", "jpg")),
            new Comic("Marvel Masterworks: The Mighty Thor Vol. 17", "Not just one but two teams with godlike creative talents grace the latest Marvel Masterworks! ", new Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/c/f0/5be5fae78943b", "jpg"))
    );

    private Context context;
    private LayoutInflater layoutInflater;

    public ComicsAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(comics.get(position));
    }

    @Override
    public int getItemCount() {
        return comics.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item)
        ImageView comicImage;

        @BindView(R.id.tv_item_title)
        TextView comicTitle;

        @BindView(R.id.tv_item_description)
        TextView comicDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Comic comic) {
            comicTitle.setText(comic.getTitle());
            comicDescription.setText(comic.getDescription());
            final Thumbnail thumbnail = comic.getThumbnail();

            Glide.with(context)
                    .load(thumbnail.getPath() + "." + thumbnail.getExtension())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(comicImage);
        }
    }
}
