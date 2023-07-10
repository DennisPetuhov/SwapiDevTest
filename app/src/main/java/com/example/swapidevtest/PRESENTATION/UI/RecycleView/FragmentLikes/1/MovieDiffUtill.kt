//package com.example.recyclerretrofitsealed.RecyclerView
//
//import androidx.recyclerview.widget.DiffUtil
//import com.example.swapidevtest.DATA.DB.PersonEntity
//
//
//class MovieDiffUtill(private val oldList:List<PersonEntity>, private val newList:List<PersonEntity>): DiffUtil.Callback() {
//    override fun getOldListSize(): Int {
//     return   oldList.size
//    }
//
//    override fun getNewListSize(): Int {
//        return newList.size
//    }
//
//    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//       return oldList[oldItemPosition].personId==newList[newItemPosition].personId
//    }
//
//    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//        return oldList[oldItemPosition]==newList[newItemPosition]
//    }
//}