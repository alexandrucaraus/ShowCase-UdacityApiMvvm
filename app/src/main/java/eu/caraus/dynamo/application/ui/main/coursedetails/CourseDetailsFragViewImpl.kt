package eu.caraus.dynamo.application.ui.main.coursedetails

import android.net.Uri
import android.os.Bundle
import android.support.transition.TransitionInflater
import android.text.Html
import android.view.*
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import eu.caraus.dynamo.R
import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import eu.caraus.dynamo.application.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_course_details.*
import kotlinx.android.synthetic.main.fragment_course_details.view.*


import javax.inject.Inject

class CourseDetailsFragViewImpl : BaseFragment(), CourseDetailsContract.View {


    companion object {

        val TAG = CourseDetailsFragViewImpl::class.java.simpleName

        const val COURSE_ID = "COURSE_ID"

        const val COURSE_OBJ = "COURSE_OBJ"

        fun newInstance(): CourseDetailsFragViewImpl {

            val fragment = CourseDetailsFragViewImpl()

            val bundle = Bundle()

            fragment.arguments = bundle

            return fragment
        }

        fun newInstance( courseId: String) : CourseDetailsFragViewImpl {

            val fragment = CourseDetailsFragViewImpl()

            val bundle = Bundle()

            bundle.putString( COURSE_ID, courseId )

            fragment.arguments = bundle

            return fragment
        }

        fun newInstance( courseItem : CoursesItem ) : CourseDetailsFragViewImpl {

            val fragment = CourseDetailsFragViewImpl()

            val bundle = Bundle()

            // TODO : change to parcelable
            bundle.putSerializable( COURSE_OBJ, courseItem )

            fragment.arguments = bundle

            return fragment

        }

    }

    @Inject
    lateinit var presenter : CourseDetailsContract.Presenter

    var coursesItem : CoursesItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = TransitionInflater.from(context)
                                    .inflateTransition(android.R.transition.move)

        lifecycle.addObserver( presenter )

        setHasOptionsMenu(true)

    }

    override fun onResume() {
        presenter.onViewAttached(this)
        super.onResume()
    }

    override fun onPause() {
        presenter.onViewDetached(true)
        super.onPause()
    }

    override fun onDestroy() {
        lifecycle.removeObserver( presenter )
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_course_details, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when ( item?.itemId ) {
            android.R.id.home -> {
                presenter.goBack()
            }
        }
        return true
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        postponeEnterTransition()

        val view = inflater.inflate(R.layout.fragment_course_details, null)

        coursesItem = arguments?.getSerializable( COURSE_OBJ ) as CoursesItem

        init( view, coursesItem )

        return view
    }

    private fun init( view : View, courseItem : CoursesItem? ){

        courseItem?.let {

            Picasso.with( context )
                    .load( Uri.parse( it.image ))
                    .fit()
                    .centerCrop()
                    .into( view.courseItemImage, object : Callback {
                        override fun onSuccess() {
                            startPostponedEnterTransition()
                        }
                        override fun onError() {
                            startPostponedEnterTransition()
                        }
                    })

            view.courseItemTitle.text = it.title
            view.courseItemSummary?.text = it.shortSummary

            if ( it.instructors.isEmpty() ){
                view.cvCourseInstructor.visibility = View.GONE
                return
            }

            it.instructors[0]?.let {

                Picasso.with( context )
                        .load( Uri.parse( it.image ))
                        .fit()
                        .centerCrop()
                        .into( view.courseInstructorImage )

                view.courseInstructorName.text = it.name
                view.courseInstructorBio.text = Html.fromHtml( it.bio ).toString()

            } ?: run {
                cvCourseInstructor.visibility = View.GONE
            }

        }

    }

}