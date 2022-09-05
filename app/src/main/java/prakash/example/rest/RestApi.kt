package prakash.example.rest

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface RestApi {

    @GET("products")
    fun getProduct() : Call<Product>

    @POST("products/add")
    fun addProduct(@Body productItem: ProductItem): Call<ProductItem>

    @PUT("products/1")
    fun updateProduct(@Body productItem: ProductItem) : Call<ProductItem>

}