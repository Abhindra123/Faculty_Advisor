package com.sonait.facultyadvisor;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentAddFragment extends Fragment{
    FirebaseFirestore dbroot;
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20,e21,e22,e23,e24,e25;
    Button b1,b2;


    public StudentAddFragment() {
        // Required empty public constructor
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_student_add, container, false);
        String s= FirebaseAuth.getInstance().getCurrentUser().getEmail();
        StringBuilder sb=new StringBuilder(s);
        String s2=sb.toString();
        String s3="students/"+s2.trim();
        dbroot=FirebaseFirestore.getInstance();
        e1=(EditText) v.findViewById(R.id.num1);
        e2=(EditText) v.findViewById(R.id.num2);
        e3=(EditText) v.findViewById(R.id.num3);
        e4=(EditText) v.findViewById(R.id.num4);
        e5=(EditText) v.findViewById(R.id.num5);
        e6=(EditText) v.findViewById(R.id.num6);
        e7=(EditText) v.findViewById(R.id.num7);
        e8=(EditText) v.findViewById(R.id.num8);
        e9=(EditText) v.findViewById(R.id.num9);
        e10=(EditText) v.findViewById(R.id.num10);
        e11=(EditText) v.findViewById(R.id.num11);
        e12=(EditText) v.findViewById(R.id.num12);
        e13=(EditText) v.findViewById(R.id.num13);
        e14=(EditText) v.findViewById(R.id.num14);
        e15=(EditText) v.findViewById(R.id.num15);
        e16=(EditText) v.findViewById(R.id.num16);
        e17=(EditText) v.findViewById(R.id.num17);
        e18=(EditText) v.findViewById(R.id.num18);
        e19=(EditText) v.findViewById(R.id.num19);
        e20=(EditText) v.findViewById(R.id.num20);
        e21=(EditText) v.findViewById(R.id.num21);
        e22=(EditText) v.findViewById(R.id.num22);
        e23=(EditText) v.findViewById(R.id.num23);
        e24=(EditText) v.findViewById(R.id.num24);
        e25=(EditText) v.findViewById(R.id.num25);
        b1=(Button) v.findViewById(R.id.submit);
        b2=(Button) v.findViewById(R.id.load);
        b1.setVisibility(v.INVISIBLE);
        b2.setVisibility(v.VISIBLE);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbroot.collection("students").document(s2).get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if(documentSnapshot.exists()) {
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
                                e1.setText(num1);
                                e2.setText(num2);
                                e3.setText(num3);
                                e4.setText(num4);
                                e5.setText(num5);
                                e6.setText(num6);
                                e7.setText(num7);
                                e8.setText(num8);
                                e9.setText(num9);
                                e10.setText(num10);
                                e11.setText(num11);
                                e12.setText(num12);
                                e13.setText(num13);
                                e14.setText(num14);
                                e15.setText(num15);
                                e16.setText(num16);
                                e17.setText(num17);
                                e18.setText(num18);
                                e19.setText(num19);
                                e20.setText(num20);
                                e21.setText(num21);
                                e22.setText(num22);
                                e23.setText(num23);
                                e24.setText(num24);
                                e25.setText(num25);
                            }
                            else{
                                e1.setText("No Data");
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                e1.setText("No");
                            }
                        });
                b1.setVisibility(v.VISIBLE);
                b2.setVisibility(v.INVISIBLE);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> items=new HashMap<>();
                items.put("num1",e1.getText().toString().trim());
                items.put("num2",e2.getText().toString().trim());
                items.put("num3",e3.getText().toString().trim());
                items.put("num4",e4.getText().toString().trim());
                items.put("num5",e5.getText().toString().trim());
                items.put("num6",e6.getText().toString().trim());
                items.put("num7",e7.getText().toString().trim());
                items.put("num8",e8.getText().toString().trim());
                items.put("num9",e9.getText().toString().trim());
                items.put("num10",e10.getText().toString().trim());
                items.put("num11",e11.getText().toString().trim());
                items.put("num12",e12.getText().toString().trim());
                items.put("num13",e13.getText().toString().trim());
                items.put("num14",e14.getText().toString().trim());
                items.put("num15",e15.getText().toString().trim());
                items.put("num16",e16.getText().toString().trim());
                items.put("num17",e17.getText().toString().trim());
                items.put("num18",e18.getText().toString().trim());
                items.put("num19",e19.getText().toString().trim());
                items.put("num20",e20.getText().toString().trim());
                items.put("num21",e21.getText().toString().trim());
                items.put("num22",e22.getText().toString().trim());
                items.put("num23",e23.getText().toString().trim());
                items.put("num24",e24.getText().toString().trim());
                items.put("num25",e25.getText().toString().trim());
                dbroot.collection("students").document(s2).set(items)
                        .addOnCompleteListener(task -> {
                            e1.setText("");
                            e2.setText("");
                            e3.setText("");
                            e4.setText("");
                            e5.setText("");
                            e6.setText("");
                            e7.setText("");
                            e8.setText("");
                            e9.setText("");
                            e10.setText("");
                        });
                Toast.makeText(view.getContext(),"Inserted Successfully",Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
