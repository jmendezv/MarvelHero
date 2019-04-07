package cristina.asensio.marvelhero.domain.usecase;

import android.arch.lifecycle.LiveData;

import java.util.List;

import cristina.asensio.marvelhero.data.repository.HeroRepositoryImpl;
import cristina.asensio.marvelhero.domain.model.Hero;
import cristina.asensio.marvelhero.domain.repository.HeroRepository;

public class GetHero {

    HeroRepository heroRepository = new HeroRepositoryImpl();

    public LiveData<List<Hero>> getHero() {
        return heroRepository.getHero();
    }

}
