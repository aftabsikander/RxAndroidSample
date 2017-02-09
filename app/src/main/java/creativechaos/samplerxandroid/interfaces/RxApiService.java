package creativechaos.samplerxandroid.interfaces;

import creativechaos.samplerxandroid.models.GithubUserModel;
import creativechaos.samplerxandroid.models.UserRepository;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by afali on 2/8/2017.
 */

public interface RxApiService {

    @GET("users/{username}")
    Observable<GithubUserModel> getUser(@Path("username") String username);


    @GET("users/{username}/repos")
    Observable<UserRepository> getUserRepos(@Path("username") String login);

}
