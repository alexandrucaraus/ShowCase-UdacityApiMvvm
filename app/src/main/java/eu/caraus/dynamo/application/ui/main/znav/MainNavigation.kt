package eu.caraus.dynamo.application.ui.main.znav

import android.content.Context
import android.support.annotation.IdRes

import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewCompat

import android.widget.ImageView
import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import eu.caraus.dynamo.application.ui.base.BaseActivity
import eu.caraus.dynamo.application.ui.base.BaseFragment
import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsFragViewImpl
import eu.caraus.dynamo.application.ui.main.courselist.CourseListFragViewImpl
import java.lang.ref.WeakReference

class MainNavigation( activity: BaseActivity, @param:IdRes @field:IdRes private val containerId: Int) {

    private val refContext: WeakReference<Context> = WeakReference( activity )

    init {
        // show back button toolbar depending on currently showing fragment
        fragmentManager.addOnBackStackChangedListener {
            (context() as BaseActivity)?.let {
                it.supportActionBar?.let {
                    it.setDisplayHomeAsUpEnabled(
                            when( fragmentManager.findFragmentById(containerId) ){
                                is CourseDetailsFragViewImpl -> true
                                else -> false
                            }
                    )
                }
                it.invalidateOptionsMenu()
            }
        }
    }

    private val fragmentManager: FragmentManager
        get() = (context() as BaseActivity).supportFragmentManager


    fun navigateToCourseList() {
        loadFragmentWithTag( getCoursesListFragment(), CourseListFragViewImpl.TAG )
    }

    fun navigateToCourseList( courseId: String ) {
        loadFragmentWithTag( getCoursesListFragment( courseId ), CourseListFragViewImpl.TAG )
    }

    fun navigateToCourseDetails( courseId : String ) {
        loadFragmentWithTag( getCourseDetailsFragment( courseId), CourseDetailsFragViewImpl.TAG )
    }

    fun navigateToCourseDetails( courseItem : CoursesItem) {
        loadFragmentWithTag( getCourseDetailsFragment( courseItem), CourseDetailsFragViewImpl.TAG)
    }

    fun navigateToCourseDetails( courseItem : CoursesItem, sharedElement: ImageView ) {

        val fragment = getCourseDetailsFragment( courseItem)

//        fragment.sharedElementEnterTransition = DetailsTransition()
//        fragment.enterTransition = Fade()
//        fragment.exitTransition = Fade()
//        fragment.sharedElementReturnTransition = DetailsTransition()

        fragmentManager
                .beginTransaction()
                .addSharedElement( sharedElement, ViewCompat.getTransitionName( sharedElement))
                .replace( containerId, fragment)
                .commitNow()

    }

    fun goBack() : Boolean {
        return when( fragmentManager.backStackEntryCount ) {
            1 -> false
            else -> { fragmentManager.popBackStack() ; true }
        }
    }

    private fun getCoursesListFragment() : CourseListFragViewImpl {
        return CourseListFragViewImpl.newInstance()
    }

    private fun getCoursesListFragment( courseId : String ) : CourseListFragViewImpl {
        return CourseListFragViewImpl.newInstance( courseId )
    }

    private fun getCourseDetailsFragment( courseId : String ) : CourseDetailsFragViewImpl {
        return CourseDetailsFragViewImpl.newInstance( courseId )
    }

    private fun getCourseDetailsFragment( courseItem : CoursesItem ) : CourseDetailsFragViewImpl {
        return CourseDetailsFragViewImpl.newInstance( courseItem)
    }

    private fun loadFragmentWithTag(fragment: BaseFragment, tag: String) {

        val currentFragment = fragmentManager.findFragmentById( containerId )

        val transaction = fragmentManager.beginTransaction()

        currentFragment?.let {
            transaction.hide(it)
        }

        transaction.add( containerId, fragment)
        transaction.addToBackStack( null )
        transaction.commit()

    }

    private fun context(): Context? {
        return refContext.get()
    }

}