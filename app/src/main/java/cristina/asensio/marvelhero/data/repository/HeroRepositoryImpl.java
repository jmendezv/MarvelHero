package cristina.asensio.marvelhero.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;

import cristina.asensio.marvelhero.data.network.HeroApi;
import cristina.asensio.marvelhero.domain.model.Hero;
import cristina.asensio.marvelhero.domain.repository.HeroRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroRepositoryImpl implements HeroRepository {

    private Call<List<Hero>> heroCall;

    private final MutableLiveData<List<Hero>> hero = new MutableLiveData<>();

    @Override
    public LiveData<List<Hero>> getHero() {
        heroCall = HeroApi.getInstance().getCharacter();
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

        return hero;
    }
}
