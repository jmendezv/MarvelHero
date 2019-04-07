package cristina.asensio.marvelhero.domain.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import cristina.asensio.marvelhero.domain.model.Hero;

public interface HeroRepository {

    LiveData<List<Hero>> getHero();
}
