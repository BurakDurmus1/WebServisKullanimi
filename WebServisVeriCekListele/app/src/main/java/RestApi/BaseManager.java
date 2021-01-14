package RestApi;

public class BaseManager {
    protected RestApi getRestApiClient()
    {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url_Bilgi);
        return restApiClient.getRestApi();
    }
}
