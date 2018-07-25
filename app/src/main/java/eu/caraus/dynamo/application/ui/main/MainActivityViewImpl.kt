package eu.caraus.dynamo.application.ui.main

import android.os.Bundle
import com.idescout.sql.SqlScoutServer
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

    lateinit var sqlScoutServer : SqlScoutServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sqlScoutServer = SqlScoutServer.create(this, packageName )

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

    override fun onResume() {
        super.onResume()
        sqlScoutServer.resume()
    }

    override fun onPause() {
        super.onPause()
        sqlScoutServer.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        sqlScoutServer.destroy()
    }

    override fun onStop() {
        super.onStop()

    }

}
