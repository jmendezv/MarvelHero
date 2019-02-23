package cristina.asensio.marvelhero.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cristina.asensio.marvelhero.R;
import cristina.asensio.marvelhero.model.Hero;
import cristina.asensio.marvelhero.viewmodel.HeroViewModel;

public class HeroFragment extends Fragment {

    private HeroViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.hero_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(HeroViewModel.class);

        observeViewModel();
    }

    private void observeViewModel() {
        viewModel.getHero().observe(this, heroes -> {
            if(heroes != null) {
                final Hero thor = heroes.get(0);
            } else {
                Log.d(HeroFragment.class.getSimpleName(), "Error trying to fetch hero data.");
            }
        });
    }
}
