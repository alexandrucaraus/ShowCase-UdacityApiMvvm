package eu.caraus.dynamo.application.ui.main.znav

import android.content.Context
import android.support.annotation.IdRes
import android.support.transition.Fade

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

    private val manager: FragmentManager?
        get() {
            context()?.let {
                return (it as BaseActivity).supportFragmentManager
            }
            return null
        }

    private fun context(): Context? {
        return refContext.get()
    }

    fun navigateToCourseList() {
        loadFragment( getCoursesListFragment() )
    }

    fun navigateToCourseDetails( courseItem : CoursesItem) {
        loadFragment( getCourseDetailsFragment( courseItem ))
    }

    fun navigateToCourseDetails( courseItem: CoursesItem, sharedElement: ImageView ){
        loadFragmentWithSharedElement(
                getCourseDetailsFragment( courseItem ,
                                          ViewCompat.getTransitionName( sharedElement )),
                                          sharedElement )
    }

    fun goBack() : Boolean {
        manager?.popBackStack()
        return false
    }

    private fun getCoursesListFragment() : CourseListFragViewImpl {
        return CourseListFragViewImpl.newInstance()
    }

    private fun getCourseDetailsFragment( courseItem : CoursesItem ) : CourseDetailsFragViewImpl {
        return CourseDetailsFragViewImpl.newInstance( courseItem )
    }

    private fun getCourseDetailsFragment( courseItem : CoursesItem,  transitionName : String ) : CourseDetailsFragViewImpl {
        return CourseDetailsFragViewImpl.newInstance( courseItem , transitionName )
    }

    private fun loadFragment( fragment : BaseFragment ) {

        val transaction
                = manager?.beginTransaction()

        transaction?.replace( containerId, fragment )
        transaction?.setReorderingAllowed(true)
        transaction?.addToBackStack(null)
        transaction?.commit()

    }

    private fun loadFragmentWithSharedElement( fragment: BaseFragment, sharedElement: ImageView  ){

        fragment.sharedElementEnterTransition  = DetailsTransition()
        fragment.enterTransition = Fade()
        fragment.exitTransition  = Fade()

        val transaction = manager?.beginTransaction()

        transaction?.setReorderingAllowed(true)
        transaction?.addSharedElement( sharedElement , ViewCompat.getTransitionName( sharedElement ))
        transaction?.replace( containerId, fragment )
        transaction?.addToBackStack(null)
        transaction?.commit()

    }

}