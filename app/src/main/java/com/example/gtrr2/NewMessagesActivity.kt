package com.example.gtrr2

import android.accounts.AccountManager.get
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ResourceManagerInternal.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gtrrapp.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_new_message.*
import kotlinx.android.synthetic.main.activity_userprofile.view.*
import kotlinx.android.synthetic.main.user_row_new_message.view.*
import java.lang.reflect.Array.get

class NewMessagesActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_message)

//        val adapter = GroupAdapter<ViewHolder>()
//
//        adapter.add(UserItem())
//        adapter.add(UserItem())
//        adapter.add(UserItem())
//
//        recyclerview_newmessage.adapter = adapter

        fetchUsers()
    }
    private fun fetchUsers(){
       val ref = FirebaseDatabase.getInstance().getReference("/users")
        ref.addListenerForSingleValueEvent(object:ValueEventListener{

            override fun onDataChange(data: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()

                data.children.forEach{
                    Log.d("NewMessage",it.toString())
                    val user=it.getValue(User::class.java)
                    if (user != null){
                        adapter.add(UserItem(user))
                    }
                }
                recyclerview_newmessage.adapter=adapter
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}

//GET USER INFORMATION
class UserItem(val user:User): Item<ViewHolder>(){
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.user_name.text=user.username

        Picasso.get().load(user.profileImageUrl).into(viewHolder.itemView.User_profile_picture)
    }

    //FOR RECYCLER VIEW
    override fun getLayout(): Int {
        return R.layout.user_row_new_message
    }


}

