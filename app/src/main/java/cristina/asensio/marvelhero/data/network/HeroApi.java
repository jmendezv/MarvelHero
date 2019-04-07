package cristina.asensio.marvelhero.data.network;


import com.serjltt.moshi.adapters.Wrapped;
import com.squareup.moshi.Moshi;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class HeroApi {

    private static final String BASE_URL = "http://gateway.marvel.com/v1/public/";

    private static Retrofit retrofit;
    private static HeroService repoService;

    public static HeroService getInstance() {

        if (repoService != null) {
            return repoService;
        }

        if (retrofit == null) {
            initializeRetrofit();
        }

        repoService = retrofit.create(HeroService.class);
        return repoService;
    }

    private static void initializeRetrofit() {
        Moshi moshi = new Moshi.Builder()
        .add(Wrapped.ADAPTER_FACTORY)
        .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();
    }

    private HeroApi() {

    }
}
