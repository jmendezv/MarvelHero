package cristina.asensio.marvelhero.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cristina.asensio.marvelhero.R;
import cristina.asensio.marvelhero.adapter.ComicsAdapter;

public class ComicsFragment extends Fragment {

    @BindView(R.id.comics_recycler_view)
    RecyclerView comicsRecyclerView;

    private Unbinder unbinder;

    public ComicsFragment() {
        // Required empty public constructor
    }

    public static ComicsFragment newInstance() {
        return new ComicsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_comics, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final ComicsAdapter adapter = new ComicsAdapter(getActivity());
        comicsRecyclerView.setAdapter(adapter);
        comicsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
