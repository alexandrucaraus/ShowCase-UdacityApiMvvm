package eu.caraus.dynamo.application.ui.main

import android.os.Bundle
import eu.caraus.dynamo.R

import eu.caraus.dynamo.application.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivityViewImpl : BaseActivity(), MainContract.View {

    companion object {
        val TAG = MainActivityViewImpl::class.java.simpleName!!
    }

    @Inject
    lateinit var presenter : MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver( presenter )

        setContentView( R.layout.activity_main )

        setSupportActionBar( toolbar )

    }

    override fun onStart() {
        super.onStart()
        presenter.onViewAttached(this)
    }

    override fun onStop() {
        presenter.onViewDetached(false)
        super.onStop()
    }

    override fun onDestroy() {
        lifecycle.removeObserver( presenter )
        super.onDestroy()
    }

    override fun onBackPressed() {
        if( presenter.onBack() )
        else
            finish()
    }

}
