package eu.caraus.dynamo.application.ui.base;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import javax.inject.Inject;

//import butterknife.ButterKnife;
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

        super.onCreate(savedInstanceState, persistentState);

        //Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        AndroidInjection.inject( this);

        beforeCreate();

        if( getIntent()!=null && getIntent().getExtras()!=null){
            setupArguments( getIntent().getExtras());
        }

        super.onCreate(savedInstanceState);

        //Icepick.restoreInstanceState(this, savedInstanceState);

        if( savedInstanceState == null ){
            loadDefaults();
        }

    }

    @Override
    public void setContentView(int layoutResID) {

        super.setContentView(layoutResID);

        //ButterKnife.bind(this);

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        //Icepick.saveInstanceState(this, outState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Icepick.saveInstanceState(this, outState);
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
