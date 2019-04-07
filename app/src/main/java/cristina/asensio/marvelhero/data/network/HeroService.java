package cristina.asensio.marvelhero.data.network;

import com.serjltt.moshi.adapters.Wrapped;

import java.util.List;

import cristina.asensio.marvelhero.domain.model.Hero;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroService {

    String PARAM_NAME = "name=thor";
    String PARAM_API_KEY = "apikey=8a42b42c15b9898a45b6da0bbe018757";
    String PARAM_HASH = "hash=bc1f342fe6c53106d7acd60a7c8a3516";
    String PARAM_TIMESTAMP = "ts=1";

    @GET("/v1/public/characters?"
            + PARAM_NAME + "&"
            + PARAM_API_KEY + "&"
            + PARAM_HASH + "&"
            + PARAM_TIMESTAMP)
    @Wrapped(path = {"data", "results"})
    Call<List<Hero>> getCharacter();
}
