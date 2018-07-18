package eu.caraus.dynamo.application.ui.main.coursedetails

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import eu.caraus.dynamo.application.domain.udacity.CoursesItem

class CourseDetailsViewModel : ViewModel() {

    var courseLogoUrl = MutableLiveData<String>()
    var courseTitle   = MutableLiveData<String>()
    var courseSummary = MutableLiveData<String>()

    var instructorSectionVisibility = MutableLiveData<Boolean>()
    var instructorLogoUrl = MutableLiveData<String>()
    var instructorName    = MutableLiveData<String>()
    var instructorBio     = MutableLiveData<String>()

    var courseItem = MutableLiveData<CoursesItem>()

    fun setCourseItem( item : CoursesItem ) {

        courseItem.value = item

        courseLogoUrl.value = item.image
        courseTitle.value = item.title
        courseSummary.value = item.shortSummary

        if ( item.instructors?.isEmpty() == true ) {
             instructorLogoUrl.value = null
             instructorName.value = null
             instructorBio.value = null
             instructorSectionVisibility.value = false
            return
        }

        item.instructors[0]?.let {
            instructorLogoUrl.value = it.image
            instructorName.value = it.name
            instructorBio.value = it.bio
        } ?: run {
            instructorLogoUrl.value = null
            instructorName.value = null
            instructorBio.value = null
        }

        instructorSectionVisibility.value = true

    }

}
