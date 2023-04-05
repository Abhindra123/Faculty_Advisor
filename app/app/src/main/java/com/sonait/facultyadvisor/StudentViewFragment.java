package com.sonait.facultyadvisor;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class StudentViewFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Userr> userArrayList;
    ArrayList<String> staff_number;
    MyAdapterr myadapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;

    public StudentViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_student_view, container, false);
        progressDialog=new ProgressDialog(v.getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();
        recyclerView=v.findViewById(R.id.recyclerrView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        db=FirebaseFirestore.getInstance();
        userArrayList =new ArrayList<Userr>();
        Context context=container.getContext();
        myadapter=new MyAdapterr(this, userArrayList);

        recyclerView.setAdapter(myadapter);
        EventChangeListener();
        return v;
    }
    public ArrayList<String> student_get(){
        ArrayList<String> al=new ArrayList<>();
        db=FirebaseFirestore.getInstance();
        db.collection("students").document("abhindraganesamoorthy@gmail.com").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        String num1 = documentSnapshot.getString("num1");
                        String num2 = documentSnapshot.getString("num2");
                        String num3 = documentSnapshot.getString("num3");
                        String num4 = documentSnapshot.getString("num4");
                        String num5 = documentSnapshot.getString("num5");
                        String num6 = documentSnapshot.getString("num6");
                        String num7 = documentSnapshot.getString("num7");
                        String num8 = documentSnapshot.getString("num8");
                        String num9 = documentSnapshot.getString("num9");
                        String num10 = documentSnapshot.getString("num10");
                        String num11 = documentSnapshot.getString("num11");
                        String num12 = documentSnapshot.getString("num12");
                        String num13 = documentSnapshot.getString("num13");
                        String num14 = documentSnapshot.getString("num14");
                        String num15 = documentSnapshot.getString("num15");
                        String num16 = documentSnapshot.getString("num16");
                        String num17 = documentSnapshot.getString("num17");
                        String num18 = documentSnapshot.getString("num18");
                        String num19 = documentSnapshot.getString("num19");
                        String num20 = documentSnapshot.getString("num20");
                        String num21 = documentSnapshot.getString("num21");
                        String num22 = documentSnapshot.getString("num22");
                        String num23 = documentSnapshot.getString("num23");
                        String num24 = documentSnapshot.getString("num24");
                        String num25 = documentSnapshot.getString("num25");

                            al.add(num1);
                            al.add(num2);
                            al.add(num3);
                            al.add(num4);
                            al.add(num5);
                            al.add(num6);
                            al.add(num7);
                            al.add(num8);
                            al.add(num9);
                            al.add(num10);
                        /*if(num11.length()>4)
                            al.add(num11);
                        if(num12.length()>4)
                            al.add(num12);
                        if(num13.length()>4)
                            al.add(num13);
                        if(num14.length()>4)
                            al.add(num14);
                        if(num15.length()>4)
                            al.add(num15);
                        if(num16.length()>4)
                            al.add(num16);
                        if(num17.length()>4)
                            al.add(num17);
                        if(num18.length()>4)
                            al.add(num18);
                        if(num19.length()>4)
                            al.add(num19);
                        if(num20.length()>4)
                            al.add(num20);
                        if(num21.length()>4)
                            al.add(num21);
                        if(num22.length()>4)
                            al.add(num22);
                        if(num23.length()>4)
                            al.add(num23);
                        if(num24.length()>4)
                            al.add(num24);
                        if(num25.length()>4)
                            al.add(num25);*/
                    }
                });
        return al;

    }
    private void EventChangeListener(){
        staff_number=student_get();
        db=FirebaseFirestore.getInstance();
        db.collection("Attendance").orderBy("regno", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.e("Firestore error", error.getMessage());
                            return;
                        }
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                String regno = dc.getDocument().getData().get("regno").toString();
                                for (int i = 0; i < staff_number.size(); i++) {
                                    if (regno.equals(staff_number.get(i))) {
                                        userArrayList.add(dc.getDocument().toObject(Userr.class));
                                    }
                                }
                            }
                        }
                        myadapter.notifyDataSetChanged();
                        if(progressDialog.isShowing())
                            progressDialog.dismiss();

                    }
                });
    }
}