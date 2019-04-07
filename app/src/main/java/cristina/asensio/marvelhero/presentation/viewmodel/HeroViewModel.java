package cristina.asensio.marvelhero.presentation.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import cristina.asensio.marvelhero.domain.model.Hero;
import cristina.asensio.marvelhero.domain.usecase.GetHero;


public class HeroViewModel extends ViewModel {

    private GetHero getHeroUseCase = new GetHero();

    public LiveData<List<Hero>> getHero() {
        return getHeroUseCase.getHero();
    }
}
