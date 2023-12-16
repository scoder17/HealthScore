package com.example.healthscore.hospital

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.healthscore.data.HospitalData
import com.example.healthscore.data.PatientData
import com.example.healthscore.patient.TAG
import com.example.healthscore.patient.err
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class hospitalDataViewModel:ViewModel() {
}

suspend fun getHospitalDataFromFireBase(email: String): HospitalData {
    val db = FirebaseFirestore.getInstance()
    var hospitalData=HospitalData()
    db.collection("hospital").whereEqualTo("hospitalEmail", email).get().await().map {

        val result = it.toObject(HospitalData::class.java)
        hospitalData = result
    }
    return hospitalData
}

fun addHospitalDataToFireBase(hospitalData: HospitalData) {
    val db = Firebase.firestore

    db.collection("hospital")
        .add(hospitalData)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(err, "Error adding document", e)
        }
}