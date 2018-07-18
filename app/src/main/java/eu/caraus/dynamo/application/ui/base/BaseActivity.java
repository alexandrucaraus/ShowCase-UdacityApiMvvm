package eu.caraus.dynamo.application.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by alex on 11/27/17.
 */

public class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    public String TAG = BaseActivity.class.getSimpleName();

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

        AndroidInjection.inject(this);

        beforeCreate();

        super.onCreate( savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        AndroidInjection.inject( this);

        beforeCreate();

        if( getIntent()!=null && getIntent().getExtras()!=null ){
            setupArguments( getIntent().getExtras() );
        }

        super.onCreate(savedInstanceState);

        if( savedInstanceState == null ){
            loadDefaults();
        }

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    protected void setupArguments(Bundle bundle){

    }

    public void beforeCreate(){

    }

    public void loadDefaults(){

    }

}
