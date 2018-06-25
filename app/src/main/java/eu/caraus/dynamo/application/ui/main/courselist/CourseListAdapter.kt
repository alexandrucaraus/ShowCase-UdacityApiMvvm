package eu.caraus.dynamo.application.ui.main.courselist

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso

import eu.caraus.dynamo.R
import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import kotlinx.android.synthetic.main.courses_list_item.view.*

class CourseListAdapter(private val list : MutableList<CoursesItem>,
                        private val listPresenter: CourseListContract.Presenter ) : RecyclerView.Adapter<CourseListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from( parent.context ).inflate( R.layout.courses_list_item, parent,
                        false )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val subject = list[ position ]

        holder.courseItemTitle.text = subject.title
        holder.courseItemDesc.text  = subject.shortSummary

        Picasso.with( holder.itemView.context )
                .load( Uri.parse( subject.image ))
                .fit()
                .centerCrop()
                .into( holder.courseItemIcon )

        holder.itemView.setOnClickListener {
            listPresenter.showDetails( subject )
        }

    }

    fun addItems(list : List<CoursesItem>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
        
    }

    fun getPositionByCourseKey( courseKey : String ) : Int {

        list.forEach  {
            if( it.key.equals( courseKey,true) )
                return list.indexOf( it )
        }

        return 0
    }

    class ViewHolder( view : View ) : RecyclerView.ViewHolder( view ) {
        val courseItemIcon  = view.courseItemImage
        val courseItemTitle = view.courseItemTitle
        val courseItemDesc  = view.courseItemShortDesc
    }

}