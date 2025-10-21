package pm.pizzaria.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter(val c: Context, val imagens: Array<Int>) : BaseAdapter() {

    override fun getCount(): Int { return imagens.size }
    override fun getItem(position: Int): Any? { return null }
    override fun getItemId(position: Int): Long { return 0 }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = ImageView(c)
        imageView.setImageResource(imagens[position])
        imageView.setPadding(8,8,8,8)
        return imageView
    }
}