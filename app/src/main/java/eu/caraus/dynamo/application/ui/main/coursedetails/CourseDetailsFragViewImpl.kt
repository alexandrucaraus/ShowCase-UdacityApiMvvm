package eu.caraus.dynamo.application.ui.main.coursedetails

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.arch.lifecycle.Observer
import android.net.Uri
import android.os.Bundle

import android.text.Html
import android.view.*
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import eu.caraus.dynamo.R
import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import eu.caraus.dynamo.application.ui.base.BaseActivity
import eu.caraus.dynamo.application.ui.base.BaseFragment
import eu.caraus.dynamo.application.ui.main.znav.MainNavigation

import kotlinx.android.synthetic.main.fragment_course_details.view.*
import javax.inject.Inject


class CourseDetailsFragViewImpl : BaseFragment() {


    companion object {

        val TAG = CourseDetailsFragViewImpl::class.java.simpleName

        const val COURSE_ID = "COURSE_ID"

        const val COURSE_OBJ = "COURSE_OBJ"

        const val TRANSITION_NAME = "TRANSITION_NAME"

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

        fun newInstance( courseItem : CoursesItem, transition : String ) : CourseDetailsFragViewImpl {

            val fragment = CourseDetailsFragViewImpl()

            val bundle = Bundle()

            // TODO : change to parcelable
            bundle.putSerializable( COURSE_OBJ, courseItem )
            bundle.putString( TRANSITION_NAME, transition )

            fragment.arguments = bundle

            return fragment

        }

    }

    @Inject
    lateinit var viewModel : CourseDetailsViewModel

    @Inject
    lateinit var navigator: MainNavigation

    private var coursesItem : CoursesItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_course_details, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when ( item?.itemId ) {
            android.R.id.home -> {
                navigator.goBack()
            }
        }
        return true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        postponeEnterTransition()


        val view = inflater.inflate(R.layout.fragment_course_details, null)

        if( coursesItem == null ) {
            coursesItem = arguments?.let {
                it.getSerializable(COURSE_OBJ) as CoursesItem
            } ?: run {
                savedInstanceState?.getSerializable(COURSE_OBJ) as CoursesItem
            }
        }

        arguments?.let {
            if( it.containsKey( TRANSITION_NAME )) {
                view.courseItemImage.transitionName = it.getString(TRANSITION_NAME)
            }
        }

        init( view , coursesItem )

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {

        coursesItem?.let {
            outState.putSerializable( COURSE_OBJ, coursesItem )
        }

        super.onSaveInstanceState(outState)
    }

    private fun init( view : View, courseItem : CoursesItem? ){

        (activity as BaseActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        hideViews(view)

        courseItem?.let {
            viewModel.setCourseItem( it )
        }

        viewModel.courseLogoUrl.observe(this, Observer<String> {
            it?.let {
                Picasso.with( context )
                        .load( Uri.parse( it ))
                        .fit()
                        .centerCrop()
                        .into( view.courseItemImage, object : Callback {
                            override fun onSuccess() {
                                startViewsAnimation(view)
                                startPostponedEnterTransition()

                            }
                            override fun onError() {
                                startViewsAnimation(view)
                                startPostponedEnterTransition()
                            }
                        })
            }
        })

        viewModel.courseTitle.observe( this, Observer<String> {
            it?.let {
                view.courseItemTitle.text = it
            }
        })

        viewModel.courseSummary.observe( this, Observer<String> {
            it?.let {
                view.courseItemSummary.text = it
            }
        })

        viewModel.instructorLogoUrl.observe(this, Observer<String>{
            it?.let {
                Picasso.with( context )
                        .load( Uri.parse( it))
                        .fit()
                        .centerCrop()
                        .into( view.courseInstructorImage )
            }
        })

        viewModel.instructorName.observe( this, Observer<String> {
            it?.let {
                view.courseInstructorName.text = it
            }
        })

        viewModel.instructorBio.observe( this, Observer<String> {
            it?.let {
                view.courseInstructorBio.text = Html.fromHtml( it ).toString()
            }
        })

    }

    fun startViewsAnimation ( view : View? ) {

        view?.let {

            it.cvCourseInfo.translationX        = 1800f
            it.cvCourseInstructor.translationY  = 1800f

            showViews(view)

            val titleAnimator = ObjectAnimator.ofFloat( it.cvCourseInfo, "translationX",  0f )
            val instrAnimator = ObjectAnimator.ofFloat( it.cvCourseInstructor, "translationY",  0f)

            val animatorSet = AnimatorSet()

            animatorSet.duration = 350

            animatorSet.playTogether( titleAnimator, instrAnimator)
            animatorSet.start()

        } ?: run {
            showViews( view )
        }

    }

    private fun hideViews(view: View?) {
        view?.cvCourseInfo?.visibility = View.GONE
        view?.cvCourseInstructor?.visibility = View.GONE
    }

    private fun showViews(view: View?) {
        view?.cvCourseInfo?.visibility = View.VISIBLE
        view?.cvCourseInstructor?.visibility = View.VISIBLE
    }

}