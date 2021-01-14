package RestApi;

import java.util.List;

import Models.Bilgi;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/todos")
    Call<List<Bilgi>> getir();
}
