package eu.caraus.dynamo.application.ui.main

import android.os.Bundle
import eu.caraus.dynamo.R

import eu.caraus.dynamo.application.ui.base.BaseActivity
import eu.caraus.dynamo.application.ui.main.znav.MainNavigation
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivityViewImpl : BaseActivity() {

    companion object {
        val TAG = MainActivityViewImpl::class.java.simpleName!!
    }

    @Inject
    lateinit var navigator : MainNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView( R.layout.activity_main )
        setSupportActionBar( toolbar )

        savedInstanceState?.let { } ?: run {
            navigator.navigateToCourseList()
        }

    }

    override fun onBackPressed() {
        when( supportFragmentManager.backStackEntryCount ){
            1    -> finish()
            else -> navigator.goBack()
        }
    }

}
