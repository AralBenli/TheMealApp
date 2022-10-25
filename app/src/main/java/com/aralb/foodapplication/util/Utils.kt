package com.aralb.foodapplication.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.aralb.foodapplication.model.detail_response.DetailResponse
import com.aralb.foodapplication.model.food_category_response.FoodCategoryResponse
import com.aralb.foodapplication.model.food_detail_response.FoodDetailResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object Constants {

    const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
}

sealed class FoodCategoryState() {
    data class Success(val data: FoodCategoryResponse) : FoodCategoryState()
    data class Loading(val loading:Boolean = false): FoodCategoryState()
    data class Error(val msg: String? = null) : FoodCategoryState()
}

sealed class FoodDetailState() {
    data class Success(val data: FoodDetailResponse) : FoodDetailState()
    data class Loading(val loading:Boolean = false): FoodDetailState()
    data class Error(val msg: String? = null) : FoodDetailState()
}

sealed class DetailState() {
    data class Success(val data: DetailResponse) : DetailState()
    data class Loading(val loading:Boolean = false): DetailState()
    data class Error(val msg: String? = null) : DetailState()
}


fun glide(context: Context, url: String?, imageView: ImageView){

        if(!url.isNullOrEmpty()) {
            Glide
                .with(context)
                .load(url)
                .into(imageView)

        } }

@BindingAdapter("app:imageUrl")
fun ImageView.setUrl(poster_path: String?) {
    if (poster_path != null)
        Glide.with(context)
            .load(poster_path)
            .apply(RequestOptions().override(1000, 400))
            .into(this)
}
