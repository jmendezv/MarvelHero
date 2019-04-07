package cristina.asensio.marvelhero.presentation.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cristina.asensio.marvelhero.presentation.home.ComicsFragment;
import cristina.asensio.marvelhero.presentation.home.EventsFragment;

public class TabsAdapter extends FragmentPagerAdapter {

    private static final String COMICS = "comics";
    private static final String EVENTS = "events";

    public TabsAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = ComicsFragment.newInstance();
                break;
            case 1:
                fragment = EventsFragment.newInstance();
                break;
            default:
                fragment = ComicsFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return COMICS;
            case 1:
                return EVENTS;
            default:
                return COMICS;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
