package EntityClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestInterface {

    /**  推荐***/

    @Headers("Content-Type:application/json;charset=utf-8")
    @GET("mybasketball//news/listnews")
    Call<List<News>> getT(@Query( "newsType")int type);


}
