package eu.caraus.dynamo.application.ui.main.courselist

import android.os.Bundle
import android.os.Handler
import android.support.annotation.IdRes
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.caraus.dynamo.R
import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import eu.caraus.dynamo.application.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_course_list.view.*
import javax.inject.Inject
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView


class CourseListFragViewImpl : BaseFragment(), CourseListContract.View {

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
    lateinit var presenter : CourseListContract.Presenter

    lateinit var adapter: CourseListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver( presenter )
    }

    override fun onDestroy() {
        lifecycle.removeObserver( presenter)
        super.onDestroy()
    }

    override fun onResume() {
        presenter.onViewAttached(this)
        super.onResume()
    }

    override fun onPause() {
        presenter.onViewDetached(true)
        super.onPause()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate( R.layout.fragment_course_list, null)
        init(view)
        return view
    }

    private fun init( view: View ) {

        view.rvCourseList.layoutManager = LinearLayoutManager( context )

        adapter = CourseListAdapter( mutableListOf(), presenter )
        adapter.registerAdapterDataObserver( object : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                super.onChanged()
                checkEmptyAdapter()
            }
        })

        view.rvCourseList.adapter = adapter

        view.srlCourseList.setOnRefreshListener { presenter.refresh() }

    }

    override fun addItems( itemList: List<CoursesItem> ) {

        adapter.addItems( itemList )

        refreshDone { snack(R.string.course_list_refresh_done) }

    }

    override fun showPlaceholder() {
        view?.placeholder?.visibility = View.VISIBLE
    }

    override fun hidePlaceholder() {
        view?.placeholder?.visibility = View.GONE
    }

    override fun showProgress() {
        view?.progress?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        view?.progress?.visibility = View.GONE
    }

    override fun showServiceCallError( error : String ) {

        refreshDone { }

        checkEmptyAdapter()

        snack( error )

    }

    private fun checkEmptyAdapter() {
        when( adapter.itemCount ){
            0 -> presenter.adapterEmpty()
            else -> presenter.adapterNotEmpty()
        }
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