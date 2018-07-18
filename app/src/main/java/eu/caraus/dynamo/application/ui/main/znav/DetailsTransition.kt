package eu.caraus.dynamo.application.ui.main.znav

import android.content.Context
import android.support.transition.*
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet

class DetailsTransition : TransitionSet {

    constructor() {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    private fun init() {

        interpolator = FastOutSlowInInterpolator()

        ordering = ORDERING_TOGETHER

        duration = 300

        addTransition( ChangeClipBounds() )
        .addTransition( ChangeTransform())
        .addTransition( ChangeBounds())

    }

}
