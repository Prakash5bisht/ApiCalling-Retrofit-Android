package prakash.example.rest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductImagesAdapter(val images : List<String>) : RecyclerView.Adapter<ProductImagesAdapter.ImagesViewHolder>() {

    inner class ImagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val layout = R.layout.product_images
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ImagesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val image : ImageView = holder.itemView.findViewById(R.id.productImage)
        Picasso.get().load(images[position]).into(image)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}