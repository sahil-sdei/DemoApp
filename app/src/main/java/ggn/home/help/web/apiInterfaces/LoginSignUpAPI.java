package ggn.home.help.web.apiInterfaces;

import com.efarmx.app.web.BasicApiDataModel;

import ggn.home.help.web.Web;
import ggn.home.help.web.models.User;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginSignUpAPI {

    @FormUrlEncoded
    @POST(Web.Path.SIGN_IN)
    Observable<BasicApiDataModel<User>> signIn(@Field(Web.Keys.USERNAME) String username, @Field(Web.Keys.PASSWORD) String password);
}