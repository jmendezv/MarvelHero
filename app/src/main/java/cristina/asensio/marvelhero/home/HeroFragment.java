package cristina.asensio.marvelhero.home;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cristina.asensio.marvelhero.R;
import cristina.asensio.marvelhero.manager.LinkHandler;
import cristina.asensio.marvelhero.model.Hero;
import cristina.asensio.marvelhero.model.Link;
import cristina.asensio.marvelhero.model.Thumbnail;
import cristina.asensio.marvelhero.util.LinkType;
import cristina.asensio.marvelhero.viewmodel.HeroViewModel;

public class HeroFragment extends Fragment {

    private HeroViewModel viewModel;
    private Unbinder unbinder;

    @BindView(R.id.iv_hero_image)
    ImageView heremoImage;

    @BindView(R.id.tv_hero_name)
    TextView heroName;

    @BindView(R.id.tv_hero_description)
    TextView heroDescription;

    @BindView(R.id.btn_wiki)
    Button wikiButton;

    @BindView(R.id.btn_comics)
    Button comicButton;

    @BindView(R.id.btn_detail)
    Button detailButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.hero_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(HeroViewModel.class);

        observeViewModel();
    }

    private void observeViewModel() {
        viewModel.getHero().observe(this, heroes -> {
            if (heroes != null) {
                final Hero thor = heroes.get(0);
                final List<Link> links = thor.getLinks();
                final Thumbnail thumbnail = thor.getThumbnail();

                heroName.setText(thor.getName());
                heroDescription.setText(thor.getDescription());

                Glide
                        .with(getContext())
                        .load(thumbnail.getPath() + "." + thumbnail.getExtension())
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .centerCrop()
                        .into(heremoImage);

                comicButton.setOnClickListener(comic -> {
                    final String url = LinkHandler.getUrl(links, LinkType.COMICLINK);
                    openLink(url);
                });

                wikiButton.setOnClickListener(wiki -> {
                    final String url = LinkHandler.getUrl(links, LinkType.WIKI);
                    openLink(url);
                });

                detailButton.setOnClickListener(detail -> {
                    final String url = LinkHandler.getUrl(links, LinkType.DETAIL);
                    openLink(url);
                });
            } else {
                Log.d(HeroFragment.class.getSimpleName(), getContext().getString(R.string.no_data));
            }
        });
    }

    private void openLink(String url) {
        if (url != null) {
            final Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        } else {
            Toast.makeText(getContext(), getContext().getString(R.string.link_not_available), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
