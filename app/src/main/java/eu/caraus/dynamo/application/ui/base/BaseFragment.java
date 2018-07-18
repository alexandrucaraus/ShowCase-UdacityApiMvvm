package eu.caraus.dynamo.application.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by alex on 11/27/17.
 */

public class BaseFragment extends Fragment implements HasSupportFragmentInjector, EasyPermissions.PermissionCallbacks {

    private boolean isRestored = false;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        AndroidSupportInjection.inject(this);

        if( savedInstanceState == null ) {
            isRestored = false;
        } else {
            isRestored = true;
        }

        setupArguments();

        super.onCreate(savedInstanceState);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public boolean isAfterRotation () {
        return isRestored;
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    protected void setupArguments(){

    }

    protected void showBackArrowInToolbar(boolean isShowBack){
        if( isShowBack &&
                getActivity()!=null &&
                    ((BaseActivity)getActivity()).getSupportActionBar()!=null){
            ((BaseActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled( isShowBack);
        }
    }


    public void setTitle(String title){
        if( getActivity()!=null)
        if( ((BaseActivity)getActivity()).getSupportActionBar()!=null)
            ((BaseActivity)getActivity()).getSupportActionBar().setTitle( title);
    }

    public void setTitle(@StringRes int strintResId){
        if( getActivity()!=null)
        if( ((BaseActivity)getActivity()).getSupportActionBar()!=null)
            ((BaseActivity)getActivity()).getSupportActionBar().setTitle( strintResId);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

}

