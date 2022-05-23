package com.example.monitoringcenter

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.monitoringcenter.databinding.FragmentResidentBinding
import com.google.firebase.database.*


class ResidentFragment : Fragment() {

    private var _binding: FragmentResidentBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseReference
    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tpDataGet()
        smDataGet()
        ltDataGet()
    }

    override fun onStart() {
        super.onStart()
        tpDataGet()
        smDataGet()
        ltDataGet()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResidentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun tpDataGet() {
        database = FirebaseDatabase.getInstance().reference
        val getListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val tp1 = dataSnapshot.child("1").value.toString()
                val tp2 = dataSnapshot.child("2").value.toString()
                val tp3 = dataSnapshot.child("3").value.toString()
                val tp4 = dataSnapshot.child("4").value.toString()
                val tp5 = dataSnapshot.child("5").value.toString()
                val tp6 = dataSnapshot.child("6").value.toString()
                val tp7 = dataSnapshot.child("7").value.toString()
                val tp8 = dataSnapshot.child("8").value.toString()
                val tp9 = dataSnapshot.child("9").value.toString()

                binding.tpData1.text = tp1
                binding.tpData2.text = tp2
                binding.tpData3.text = tp3
                binding.tpData4.text = tp4
                binding.tpData5.text = tp5
                binding.tpData6.text = tp6
                binding.tpData7.text = tp7
                binding.tpData8.text = tp8
                binding.tpData9.text = tp9

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        database.child("test").child("溫度").addValueEventListener(getListener)
    }

    private fun smDataGet() {
        database = FirebaseDatabase.getInstance().reference
        val getListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val sm1 = dataSnapshot.child("1").value.toString().toInt()
                val sm2 = dataSnapshot.child("2").value.toString().toInt()
                val sm3 = dataSnapshot.child("3").value.toString().toInt()
                val sm4 = dataSnapshot.child("4").value.toString().toInt()
                val sm5 = dataSnapshot.child("5").value.toString().toInt()
                val sm6 = dataSnapshot.child("6").value.toString().toInt()
                val sm7 = dataSnapshot.child("7").value.toString().toInt()
                val sm8 = dataSnapshot.child("8").value.toString().toInt()
                val sm9 = dataSnapshot.child("9").value.toString().toInt()

                if (sm1 == 1) {
                    binding.smData1.text = "異常"
                    binding.smData1.setTextColor(Color.RED)
                } else if (sm1 == 0) {
                    binding.smData1.text = "安全"
                    binding.smData1.setTextColor(Color.GREEN)
                }

                if (sm2 == 1) {
                    binding.smData2.text = "異常"
                    binding.smData2.setTextColor(Color.RED)
                } else if (sm2 == 0) {
                    binding.smData2.text = "安全"
                    binding.smData2.setTextColor(Color.GREEN)
                }

                if (sm3 == 1) {
                    binding.smData3.text = "異常"
                    binding.smData3.setTextColor(Color.RED)
                } else if (sm3 == 0) {
                    binding.smData3.text = "安全"
                    binding.smData3.setTextColor(Color.GREEN)
                }

                if (sm4 == 1) {
                    binding.smData4.text = "異常"
                    binding.smData4.setTextColor(Color.RED)
                } else if (sm4 == 0) {
                    binding.smData4.text = "安全"
                    binding.smData4.setTextColor(Color.GREEN)
                }

                if (sm5 == 1) {
                    binding.smData5.text = "異常"
                    binding.smData5.setTextColor(Color.RED)
                } else if (sm5 == 0) {
                    binding.smData5.text = "安全"
                    binding.smData5.setTextColor(Color.GREEN)
                }

                if (sm6 == 1) {
                    binding.smData6.text = "異常"
                    binding.smData6.setTextColor(Color.RED)
                } else if (sm6 == 0) {
                    binding.smData6.text = "安全"
                    binding.smData6.setTextColor(Color.GREEN)
                }

                if (sm7 == 1) {
                    binding.smData7.text = "異常"
                    binding.smData7.setTextColor(Color.RED)
                } else if (sm7 == 0) {
                    binding.smData7.text = "安全"
                    binding.smData7.setTextColor(Color.GREEN)
                }

                if (sm8 == 1) {
                    binding.smData8.text = "異常"
                    binding.smData8.setTextColor(Color.RED)
                } else if (sm8 == 0) {
                    binding.smData8.text = "安全"
                    binding.smData8.setTextColor(Color.GREEN)
                }

                if (sm9 == 1) {
                    binding.smData9.text = "異常"
                    binding.smData9.setTextColor(Color.RED)
                } else if (sm9 == 0) {
                    binding.smData9.text = "安全"
                    binding.smData9.setTextColor(Color.GREEN)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        database.child("test").child("煙霧").addValueEventListener(getListener)
    }

    private fun ltDataGet() {
        database = FirebaseDatabase.getInstance().reference
        val getListener = object : ValueEventListener {
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val lt1 = dataSnapshot.child("R1").value.toString().toInt()
                val lt2 = dataSnapshot.child("R2").value.toString().toInt()
                val lt3 = dataSnapshot.child("R3").value.toString().toInt()
                val lt4 = dataSnapshot.child("R4").value.toString().toInt()
                val lt5 = dataSnapshot.child("R5").value.toString().toInt()
                val lt6 = dataSnapshot.child("R6").value.toString().toInt()
                val lt7 = dataSnapshot.child("R7").value.toString().toInt()
                val lt8 = dataSnapshot.child("R8").value.toString().toInt()
                val lt9 = dataSnapshot.child("R9").value.toString().toInt()

                if (lt1 == 1) {
                    binding.circle1.setImageDrawable(resources.getDrawable(R.drawable.ic_red_circle))
                } else if (lt1 == 0) {
                    binding.circle1.setImageDrawable(resources.getDrawable(R.drawable.ic_gray_circle))
                }

                if (lt2 == 1) {
                    binding.circle2.setImageDrawable(resources.getDrawable(R.drawable.ic_red_circle))
                } else if (lt2 == 0) {
                    binding.circle2.setImageDrawable(resources.getDrawable(R.drawable.ic_gray_circle))
                }

                if (lt3 == 1) {
                    binding.circle3.setImageDrawable(resources.getDrawable(R.drawable.ic_red_circle))
                } else if (lt3 == 0) {
                    binding.circle3.setImageDrawable(resources.getDrawable(R.drawable.ic_gray_circle))
                }

                if (lt4 == 1) {
                    binding.circle4.setImageDrawable(resources.getDrawable(R.drawable.ic_red_circle))
                } else if (lt4 == 0) {
                    binding.circle4.setImageDrawable(resources.getDrawable(R.drawable.ic_gray_circle))
                }

                if (lt5 == 1){
                    binding.circleCenter.setImageDrawable(resources.getDrawable(R.drawable.ic_red_circle))
                }else if (lt5 == 0){
                    binding.circleCenter.setImageDrawable(resources.getDrawable(R.drawable.ic_gray_circle))
                }

                if (lt6 == 1){
                    binding.circle5.setImageDrawable(resources.getDrawable(R.drawable.ic_red_circle))
                }else if (lt6 == 0){
                    binding.circle5.setImageDrawable(resources.getDrawable(R.drawable.ic_gray_circle))
                }

                if (lt7 == 1){
                    binding.circle6.setImageDrawable(resources.getDrawable(R.drawable.ic_red_circle))
                }else if (lt7 == 0){
                    binding.circle6.setImageDrawable(resources.getDrawable(R.drawable.ic_gray_circle))
                }

                if (lt8 == 1){
                    binding.circle7.setImageDrawable(resources.getDrawable(R.drawable.ic_red_circle))
                }else if (lt8 == 0){
                    binding.circle7.setImageDrawable(resources.getDrawable(R.drawable.ic_gray_circle))
                }

                if (lt9 == 1){
                    binding.circle8.setImageDrawable(resources.getDrawable(R.drawable.ic_red_circle))
                }else if (lt9 == 0){
                    binding.circle8.setImageDrawable(resources.getDrawable(R.drawable.ic_gray_circle))
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        database.child("light").child("燈號").addValueEventListener(getListener)
    }

}