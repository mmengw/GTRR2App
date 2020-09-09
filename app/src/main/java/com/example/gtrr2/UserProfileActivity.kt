package com.example.gtrrapp

import android.content.ClipData
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gtrr2.R
import com.example.gtrr2.fragments.AchievementsFragment
import com.example.gtrr2.fragments.HomeFragment
import com.example.gtrr2.fragments.LogFragment
import com.example.gtrr2.fragments.UserFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_userprofile.view.*
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.fragment_user.view.*
import org.w3c.dom.Text
import java.lang.StringBuilder
import java.lang.ref.Reference

class UserProfileActivity:Fragment() {

    private val currentUser = FirebaseAuth.getInstance().currentUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user,container,false)
    }

    override fun onViewCreated(view:View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val user = Firebase.auth.currentUser
        user?.let {
            for (profile in it.providerData) {
                // Id of the provider (ex: google.com)
                val providerId = profile.providerId

                // UID specific to the provider
                val uid = profile.uid

                // Name, email address, and profile photo Url
                val name = profile.displayName
                val email = profile.email
                val photoUrl = profile.photoUrl
            }
            
        }

//        var getdata=object: ValueEventListener{
//            override fun onDataChange(data: DataSnapshot) {
//               var sb=StringBuilder()
//                for(i in data.children ){
//                    var UName = i.child("users").getValue()
//                      sb.append("${i.key} $UName")
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//        }
//        currentUser.addValueEventListener(getdate)
//        currentUser.addListenerForSingleValueEvent(getdate)

//        currentUser?.let{user->
//            Glide.with(this)
//                .load(user.photoUrl)
//                .into(user_profilepic)
//
//            user_profile_name1.setText(user.displayName)
//        }

    }

}

