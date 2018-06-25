package eu.caraus.dynamo.application.ui.base;

import android.Manifest;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.lang.reflect.Field;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

import eu.caraus.dynamo.R;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by alex on 11/27/17.
 */

public class BaseFragment extends Fragment implements HasSupportFragmentInjector, EasyPermissions.PermissionCallbacks {

    private boolean isRestored = false;

    public static final int RC_LOCATION_PERM = 123;
    public static final int RC_STORAGE_PERM = 124;
    public static final int RC_ALL_PERM = 125;

    private static String[] STORAGE_PERMISSIONS = new String[] {
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                            };

    private static String[] CAMERA_PERMISSIONS  = new String[] {
                                        Manifest.permission.ACCESS_FINE_LOCATION
                            };

    private static String[] ALL_PERMISSIONS = new String[] {
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.ACCESS_FINE_LOCATION
                            };

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        AndroidSupportInjection.inject(this);

        //Icepick.restoreInstanceState(this,savedInstanceState);
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
        //Icepick.saveInstanceState(this, outState);
    }

    public boolean isAfterRotation(){
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

//    protected boolean hasLocationPermission(){
//        return EasyPermissions.hasPermissions( getContext(), CAMERA_PERMISSIONS);
//    }
//
//    protected void requestLocationPermission(){
//        EasyPermissions.
//                requestPermissions( this,
//                        getString(R.string.permission_rationale_location),
//                        RC_LOCATION_PERM,
//                        CAMERA_PERMISSIONS);
//    }
//
//    protected boolean hasStoragePermission(){
//        return EasyPermissions.hasPermissions( getContext(), STORAGE_PERMISSIONS);
//    }
//
//    protected void requestStoragePermission(){
//        EasyPermissions.
//                requestPermissions( this,
//                        getString(R.string.permission_rationale_storage),
//                        RC_STORAGE_PERM,
//                        STORAGE_PERMISSIONS);
//    }
//
//    protected void showDialog(DialogFragment dialog){
//        if( dialog!=null && getActivity().getFragmentManager()!=null && !dialog.isAdded())
//            dialog.show( getActivity().getFragmentManager(),"TAG");
//    }

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

    //    private static final int DEFAULT_CHILD_ANIMATION_DURATION = 250;

//    @Override
//    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
//
//        final Fragment parent = getParentFragment();
//              Fragment parentOfParent = null;
//
//        if( parent!=null ) {
//            parentOfParent = parent.getParentFragment();
//        }
//        if( !enter && parent != null && parentOfParent!=null && parentOfParent.isRemoving()){
//            Animation doNothingAnim = new AlphaAnimation(1, 1);
//            doNothingAnim.setDuration(getNextAnimationDuration(parent, DEFAULT_CHILD_ANIMATION_DURATION));
//            return doNothingAnim;
//        } else
//        if (!enter && parent != null && parent.isRemoving()) {
//            Animation doNothingAnim = new AlphaAnimation(1, 1);
//            doNothingAnim.setDuration(getNextAnimationDuration(parent, DEFAULT_CHILD_ANIMATION_DURATION));
//            return doNothingAnim;
//        } else {
//            return super.onCreateAnimation(transit, enter, nextAnim);
//        }
//    }
//
//    private static long getNextAnimationDuration(Fragment fragment, long defValue) {
//        try {
//            Field nextAnimField = Fragment.class.getDeclaredField("mNextAnim");
//            nextAnimField.setAccessible(true);
//            int nextAnimResource = nextAnimField.getInt(fragment);
//            Animation nextAnim = AnimationUtils.loadAnimation(fragment.getActivity(), nextAnimResource);
//            return (nextAnim == null) ? defValue : nextAnim.getDuration();
//        } catch (NoSuchFieldException|IllegalAccessException|Resources.NotFoundException ex) {
//            return defValue;
//        }
//    }

}

