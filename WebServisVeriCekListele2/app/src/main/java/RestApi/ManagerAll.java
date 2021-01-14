package RestApi;

import java.util.List;

import Models.Bilgi;
import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourgetInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance()
    {
        return ourgetInstance;
    }
    public Call<List<Bilgi>> getirBilgi()
    {
        Call<List<Bilgi>> x = getRestApiClient().getir();
        return x;

    }
}
