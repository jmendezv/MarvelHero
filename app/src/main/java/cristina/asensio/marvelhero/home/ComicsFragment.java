package cristina.asensio.marvelhero.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cristina.asensio.marvelhero.R;

public class ComicsFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_comics, container, false);
    }
}
