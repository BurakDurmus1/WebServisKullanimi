package RestApi;

import java.util.List;

import Models.Bilgi;
import Models.Result;
import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }
    public Call<List<Bilgi>> getirCall()
    {
        Call<List<Bilgi>> x = getRestApi().getir();
        return x;
    }
    public Call<List<Result>> managergetResult(String post,String id)
    {
        Call<List<Result>> y = getRestApi().getirResult(post,id);
        return y;
    }
}
