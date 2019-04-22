package EntityClass;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    public static void newsList(String json) {
        List<News> responnews = new ArrayList<>();
        try {

            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = jsonObject.getJSONArray("success");

            Log.e("sdasdsa", jsonArray.getString(0));
//            for (int i = 0; i < jsonArray.length(); i++) {
//                News news = new News();
//                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//
//                News news1 = new News();
//
//
//            }


        } catch (JSONException e) {



            e.printStackTrace();

        }
    }

}
