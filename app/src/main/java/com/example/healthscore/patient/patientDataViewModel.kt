package com.example.healthscore.patient

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthscore.data.DocNotes
import com.example.healthscore.data.Doctor
import com.example.healthscore.data.Medicine
import com.example.healthscore.data.PatientData
import com.example.healthscore.hospital.db
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

const val TAG = "success"
const val err = "error"

class PatientDataViewModel : ViewModel() {
    private val state = mutableStateOf(PatientData())

//    private fun getPatientData(email: String) {
//        viewModelScope.launch {
//            state.value = getPatientDataFromFireBase(email)
//        }
//    }
//
//    fun checkIsValidPatient(email: String, password: String): Boolean {
//        getPatientData(email)
//        return state.value.password == password
//    }


}

suspend fun getPatientDataFromFireBase(email: String): PatientData {
    val db = FirebaseFirestore.getInstance()
    var patientData = PatientData()
    db.collection("patient").whereEqualTo("email", email).get().await().map {

        val result = it.toObject(PatientData::class.java)
        patientData = result
    }

    return patientData
}

suspend fun getAllMedicineDataFromFireBase(): MutableList<Medicine> {
    val medicineList = mutableListOf<Medicine>()

    try {
        val querySnapshot = db.collection("medicine")
            .get()
            .await()

        for (document in querySnapshot.documents) {
            val medicine = document.toObject(Medicine::class.java)
            if (medicine != null) {
                medicineList.add(medicine)
            }
        }

    } catch (exception: Exception) {
        // Handle the exception (e.g., log an error, show an error message)
        Log.e(TAG, "Error getting department data: $exception")
    }

    return medicineList
}

suspend fun getAllDocNotesDataFromFireBase(): MutableList<DocNotes> {
    val docNotesList = mutableListOf<DocNotes>()

    try {
        val querySnapshot = db.collection("docNotes").whereEqualTo("patientId", "admin")
            .get()
            .await()

        for (document in querySnapshot.documents) {
            val docnote = document.toObject(DocNotes::class.java)
            if (docnote != null) {
                docNotesList.add(docnote)
            }
        }
        Log.d(TAG, "getAllDocNotesDataFromFireBase: $docNotesList")
    } catch (exception: Exception) {
        // Handle the exception (e.g., log an error, show an error message)
        Log.e(TAG, "Error getting department data: $exception")
    }

    return docNotesList
}

fun addDataToFireBase(patientData: PatientData) {
    val db = Firebase.firestore

    db.collection("patient")
        .add(patientData)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(err, "Error adding document", e)
        }
}