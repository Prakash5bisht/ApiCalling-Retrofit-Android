package prakash.example.rest

import android.util.Log

val TAG2 = "ApiData"
object ApiData {

    var products = ArrayList<ProductItem>()

    fun setData(data : ArrayList<ProductItem>){
        products = data
        Log.d(TAG2, "setData: ${products.toString()}")
    }

    fun getData() : ArrayList<ProductItem>{
        Log.d(TAG2, "getData: ${products.toString()}")
        return products
    }
}