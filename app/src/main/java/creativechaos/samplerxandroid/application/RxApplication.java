package creativechaos.samplerxandroid.application;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by afali on 2/6/2017.
 */

public class RxApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree() {
            @Override
            protected String createStackElementTag(StackTraceElement element) {
                return super.createStackElementTag(element) + ":" + element.getLineNumber();
            }
        });

    }
}
