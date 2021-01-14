package RestApi;

import java.util.List;

import Models.Bilgiler;
import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }
    public Call<List<Bilgiler>> getirBilgileri(){
        Call<List<Bilgiler>> call= getRestApiClient().bilgiGetir();
        return call;
    }
}
