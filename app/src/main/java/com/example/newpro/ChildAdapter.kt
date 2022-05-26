package  com.example.newpro

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_list.view.*

class ChildAdapter(val context : Context, val item: Categories): RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    private var cardList = ArrayList<CardItem>()

    fun setData(cardItem : ArrayList<CardItem>){
        this.cardList = cardItem
    }

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item : CardItem){
            itemView.image.setImageResource(item.card)
            itemView.amount.text = item.message.toString()
//            itemView.favourite.setImageResource(item.favourite)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_list, parent, false)
        return ChildViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
       holder.bind(cardList[position])
    }

}