package com.example.healthscore.hospital

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.healthscore.data.Department
import com.example.healthscore.data.Doctor
import com.example.healthscore.data.HospitalData
import com.example.healthscore.data.PatientData
import com.example.healthscore.patient.TAG
import com.example.healthscore.patient.err
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class hospitalDataViewModel : ViewModel() {
}

val db = Firebase.firestore
suspend fun getHospitalDataFromFireBase(email: String): HospitalData {

    var hospitalData = HospitalData()
    db.collection("hospital").whereEqualTo("hospitalEmail", email).get().await().map {

        val result = it.toObject(HospitalData::class.java)
        hospitalData = result
    }
    return hospitalData
}




fun addHospitalDataToFireBase(hospitalData: HospitalData) {
    db.collection("hospital")
        .add(hospitalData)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(err, "Error adding document", e)
        }
}

fun addDepartmentDataToFireBase(department: Department) {
    db.collection("department")
        .add(department)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(err, "Error adding document", e)
        }
}
fun addDoctorDataToFireBase(doctor: Doctor) {
    Log.d(TAG, "addDoctorDataToFireBase: $doctor")
    db.collection("doctor")
        .add(doctor)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(err, "Error adding document", e)
        }
}

suspend fun getAllDoctorDataFromFireBase(departmentId: String): MutableList<Doctor> {
    val doctorList = mutableListOf<Doctor>()

    try {
        val querySnapshot = db.collection("doctor")
            .whereEqualTo("departmentId", departmentId)
            .get()
            .await()

        for (document in querySnapshot.documents) {
            val doctor = document.toObject(Doctor::class.java)
            if (doctor != null) {
                doctorList.add(doctor)
            }
        }
        Log.d(TAG, "getAllDepartmentDataFromFireBase: $doctorList")
    } catch (exception: Exception) {
        // Handle the exception (e.g., log an error, show an error message)
        Log.e(TAG, "Error getting department data: $exception")
    }

    return doctorList
}
suspend fun getAllDepartmentDataFromFireBase(hospitalId: String): MutableList<Department> {
    val departmentsList = mutableListOf<Department>()

    try {
        val querySnapshot = db.collection("department")
            .whereEqualTo("hospitalId", hospitalId)
            .get()
            .await()

        for (document in querySnapshot.documents) {
            val department = document.toObject(Department::class.java)
            if (department != null) {
                departmentsList.add(department)
            }
        }
        Log.d(TAG, "getAllDepartmentDataFromFireBase: $departmentsList")
    } catch (exception: Exception) {
        // Handle the exception (e.g., log an error, show an error message)
        Log.e(TAG, "Error getting department data: $exception")
    }

    return departmentsList
}