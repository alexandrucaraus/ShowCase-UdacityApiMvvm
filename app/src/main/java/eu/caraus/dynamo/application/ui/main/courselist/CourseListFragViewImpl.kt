package eu.caraus.dynamo.application.ui.main.courselist

import android.arch.lifecycle.Observer

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_course_list.view.*

import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.ViewTreeObserver
import android.widget.ImageView

import eu.caraus.dynamo.application.domain.udacity.CoursesItem

import eu.caraus.dynamo.R
import eu.caraus.dynamo.application.ui.base.BaseActivity
import eu.caraus.dynamo.application.ui.base.BaseFragment
import eu.caraus.dynamo.application.ui.main.znav.MainNavigation


import javax.inject.Inject

class CourseListFragViewImpl : BaseFragment() , CourseListAdapter.CourseListCallback {


    companion object {
        val TAG = CourseListFragViewImpl::class.java.simpleName!!
        private const val SCROLL_TO_COURSE_ID = "SCROLL_TO_COURSE_ID"
        fun newInstance(): CourseListFragViewImpl {
            val fragment = CourseListFragViewImpl()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }

        fun newInstance( courseId : String ): CourseListFragViewImpl {
            val fragment = CourseListFragViewImpl()
            val bundle = Bundle()
            bundle.putString( SCROLL_TO_COURSE_ID, courseId )
            fragment.arguments = bundle
            return fragment
        }
    }

    @Inject
    lateinit var viewModel : CourseListViewModel

    @Inject
    lateinit var navigator : MainNavigation

    private lateinit var adapter   : CourseListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?): View? {
        val view = inflater.inflate( R.layout.fragment_course_list, null)
        init( view, bundle)
        return view
    }

    private fun init( view: View, bundle: Bundle? ) {

        (activity as BaseActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        view.progress.visibility = View.VISIBLE

        view.rvCourseList.layoutManager = LinearLayoutManager( context )

        adapter = CourseListAdapter( mutableListOf(), this)
        adapter.registerAdapterDataObserver( object : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                super.onChanged()
                checkEmptyAdapter()
            }
        })

        view.rvCourseList.adapter = adapter
        view.srlCourseList.setOnRefreshListener { viewModel.getFreshData() }

        viewModel.courseListLifeData?.observe( this, Observer<MutableList<CoursesItem>>{
            showList(it)
        })

        waitRecycleViewToRender( view )

    }

    private fun waitRecycleViewToRender( view: View ){
        postponeEnterTransition()
        view.rvCourseList?.viewTreeObserver?.addOnPreDrawListener( object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                startPostponedEnterTransition()
                view.rvCourseList.viewTreeObserver.removeOnPreDrawListener( this )
                return true
            }
        })
    }

    private fun showProgress   () {
        view?.progress?.visibility = View.VISIBLE
    }

    private fun hideProgress () {
        view?.progress?.visibility = View.GONE
    }

    override fun showDetails(courseItem: CoursesItem) {
        navigator.navigateToCourseDetails( courseItem )
    }

    override fun showDetails( courseItem : CoursesItem, sharedView : ImageView) {
        navigator.navigateToCourseDetails( courseItem , sharedView )
    }

    private fun showList( list : MutableList<CoursesItem>? ){

        list?.let {
            if( it.isNotEmpty() ) {
                adapter.addItems(it)
            }
            else {
                checkEmptyAdapter()
            }
        }   ?:run {
            checkEmptyAdapter()
        }

        refreshDone { snack( "getData done!") }
        hideProgress()

    }

    private fun checkEmptyAdapter() {
        when( adapter.itemCount ){
            0 -> adapterIsEmpty()
            else -> adapterIsNotEmpty()
        }
    }

    private fun adapterIsEmpty(){

    }

    private fun adapterIsNotEmpty(){

    }

    private fun refreshDone( exec : () -> Unit ) {
        view?.srlCourseList?.let {
            if( it.isRefreshing ) { it.isRefreshing = false ; exec() }
        }
    }

    private fun snack( stringId : Int ) {
        view?.clCourseList?.let {
            Snackbar.make( it, resources.getString( stringId ), Snackbar.LENGTH_LONG).show()
        }
    }

    private fun snack( message : String ){
        view?.clCourseList?.let {
            Snackbar.make( it, message, Snackbar.LENGTH_LONG).show()
        }
    }

}