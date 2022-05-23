package com.example.monitoringcenter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.monitoringcenter.databinding.FragmentCameraBinding
import com.example.monitoringcenter.databinding.FragmentResidentBinding
import com.google.firebase.database.*


class CameraFragment : Fragment() {


    private var _binding: FragmentCameraBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseReference
    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        openCamera()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCameraBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun openCamera(){
        binding.btnStream.setOnClickListener{
            playStream()
        }
    }

    private fun playStream() {
        database = FirebaseDatabase.getInstance().reference
        database.child("同步影像").child("on").setValue(1)
        val webSettings = binding.streamView.settings
        webSettings.javaScriptEnabled = true
        binding.streamView.onResume()
        binding.streamView.webViewClient = WebViewClient()
        database = FirebaseDatabase.getInstance().reference
        val getListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val url = dataSnapshot.child("url").value.toString()
                when {
                    url.isNotEmpty() -> {
                        binding.streamView.loadUrl(url)
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        database.child("串流網址").addValueEventListener(getListener)
    }

}