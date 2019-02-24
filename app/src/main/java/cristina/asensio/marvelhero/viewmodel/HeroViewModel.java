package cristina.asensio.marvelhero.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import cristina.asensio.marvelhero.model.Hero;
import cristina.asensio.marvelhero.network.HeroApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HeroViewModel extends ViewModel {

    private final MutableLiveData<List<Hero>> hero = new MutableLiveData<>();

    private Call<List<Hero>> heroCall;

    @Inject
    public HeroViewModel() {
        fetchHero();
    }

    public LiveData<List<Hero>> getHero() {
        return hero;
    }

    private void fetchHero() {
        heroCall = HeroApi.getInstance().getCharacter();
        Log.d(HeroViewModel.class.getSimpleName(), "heroCall request: " + heroCall.request());
        heroCall.enqueue(new Callback<List<Hero>>() {

            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                hero.setValue(response.body());
                heroCall = null;
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Log.e(getClass().getSimpleName(), "Error loading hero", t);
                heroCall = null;
            }
        });
    }

    @Override
    protected void onCleared() {
        if (heroCall != null) {
            heroCall.cancel();
            heroCall = null;
        }
    }
}
