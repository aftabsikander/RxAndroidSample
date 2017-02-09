package creativechaos.samplerxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func1;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rxExamples();
    }


    //region Various Rx Various example
    private void rxExamples() {
        Observable<String> myObservable
                = Observable.just("Hello"); // Emits "Hello"

        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                // Called when the observable has no more data to emit
                Timber.d("Steam has ended");
            }

            @Override
            public void onError(Throwable e) {
                // Called when the observable encounters an error
                Timber.e(e, "An error has been encountered while trying to emit data.");
            }

            @Override
            public void onNext(String s) {
                // Called each time the observable emits data
                Timber.d(s);
            }
        };

        myObservable.subscribe(myObserver);

        fromRxOperatorExample();
        mapRxOperatorExample();
    }

    /***
     * This method is used to demonstrate how to use operator which emits list or Array object one by one
     */
    private void fromRxOperatorExample() {
        Observable<String> myStringArrayObservable =
                Observable.from(new String[]{"Aftab", "Ali", "Ahsan", "Noman", "Tabraiz", "Sohail", "Danish", "Hasan", "Touqeer"});
        Timber.d("Starting From Operator Example");
        myStringArrayObservable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Timber.d(s);
            }
        });
    }

    private void mapRxOperatorExample() {
        Observable<Integer> myIntArrayObservable =
                Observable.from(new Integer[]{1, 2, 3, 4, 5, 6});
        // Input and Output are both Integer
      /*  myIntArrayObservable = myIntArrayObservable.map(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer * integer; // Square the number
            }
        });

        myIntArrayObservable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Timber.d(integer + "");
            }
        });*/

        //Chain Example

        // Input and Output are both Integer
        myIntArrayObservable.map(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer * integer; // Square the number
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Timber.d("Square number: " + integer);
            }
        });

        //Skip and Filter Chain example
        myIntArrayObservable
                .skip(2) //Skip first two indexes
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) { // Filter Out ODD numbersa
                        return integer % 2 == 0;
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Timber.d("Even Numbers: " + integer);
                    }
                });

    }

    //endregion


}
