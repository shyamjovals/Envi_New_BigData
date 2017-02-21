//package bluepanther.jiljungjuk.Reports_Grid;
//
//import android.app.DatePickerDialog;
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.content.res.TypedArray;
//import android.net.Uri;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.os.Environment;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.SearchView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.DatePicker;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import com.firebase.client.DataSnapshot;
//import com.firebase.client.Firebase;
//import com.firebase.client.FirebaseError;
//import com.firebase.client.ValueEventListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.storage.FileDownloadTask;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageMetadata;
//import com.google.firebase.storage.StorageReference;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//import bluepanther.jiljungjuk.Audiodesc;
//import bluepanther.jiljungjuk.CurrentUser;
//import bluepanther.jiljungjuk.DatePickerFragment;
//import bluepanther.jiljungjuk.FileDesc;
//import bluepanther.jiljungjuk.ImageDesc;
//import bluepanther.jiljungjuk.ImgUri;
//import bluepanther.jiljungjuk.R;
//import bluepanther.jiljungjuk.RepContent;
//import bluepanther.jiljungjuk.Repgroup_tab;
//import bluepanther.jiljungjuk.Repindi_tab;
//import bluepanther.jiljungjuk.RowItem;
//import bluepanther.jiljungjuk.TextDesc;
//import bluepanther.jiljungjuk.VideoDesc;
//import bluepanther.jiljungjuk.imgdisp;
//import bluepanther.jiljungjuk.txtdisp;
//
//
///**
// * Created by Hariharsudan on 11/3/2016.
// */
//
//public class Reports extends Fragment implements AdapterView.OnItemClickListener {
//
//    Boolean flagz;
//
//    ProgressDialog imgprog;
//    String[] member_names;
//    TypedArray profile_pics;
//    String[] statues;
//    String result,query;
//    String[] time;
//    ImageView imgg;
//    ArrayList<String> cntcheck;
//    ArrayList<String> name, categ, dates;
//    ArrayList<String> content;
//    String maincat="Academics",subcat="Time Table";
//    EditText from_date, to_date;
//    List<RowItem> rowItems;
//    ListView mylistview,mylistview2;
//    Button download;
//    private String Base_url = "https://soul-for-schools.firebaseio.com/";
//    private Firebase fb_db;
//    int flag;
//    List<RowItem> grpcontent;
//    List<RowItem> percontent;
//    String file1;
//    SearchView searchView;
//    public Uri filuri;
//    public Boolean go=true,filtered1=false,filtered2=false;
//    CustomAdapter adapter,adapter2;
//    Spinner category, subcategory, author;
//
//    String tmp1, tmp2, tmp3, tmp4, tmp5;
//    String seltab = "Text";
//
//    ArrayList<String> namei, categi, datesi, contenti, authi;
//    ArrayList<String> namea, catega, datesa, contenta, autha;
//    ArrayList<String> namev, categv, datesv, contentv, authv;
//    ArrayList<String> namef, categf, datesf, contentf, authf;
//    ArrayList<String> namet, categt, datest, contentt, autht;
//
//
//    ArrayList<String> namei2, categi2, datesi2, contenti2, authi2;
//    ArrayList<String> namea2, catega2, datesa2, contenta2, autha2;
//    ArrayList<String> namev2, categv2, datesv2, contentv2, authv2;
//    ArrayList<String> namef2, categf2, datesf2, contentf2, authf2;
//    ArrayList<String> namet2, categt2, datest2, contentt2, autht2;
//
//    String[] member_namesi;
//    String[] member_namesa;
//    String[] member_namesv;
//    String[] member_namesf;
//    String[] member_namest;
//
//    String[] member_namesi2;
//    String[] member_namesa2;
//    String[] member_namesv2;
//    String[] member_namesf2;
//    String[] member_namest2;
//
//
//
//    String[] statuesi;
//    String[] timei;
//    String[] authori;
//
//    String[] statuesi2;
//    String[] timei2;
//    String[] authori2;
//
//
//    String[] statuesa;
//    String[] timea;
//    String[] authora;
//
//    String[] statuesa2;
//    String[] timea2;
//    String[] authora2;
//
//
//    String[] statuesv;
//    String[] timev;
//    String[] authorv;
//
//    String[] statuesv2;
//    String[] timev2;
//    String[] authorv2;
//
//
//    String[] statuesf;
//    String[] timef;
//    String[] authorf;
//
//
//    String[] statuesf2;
//    String[] timef2;
//    String[] authorf2;
//
//
//    String[] statuest;
//    String[] timet;
//    String[] authort;
//
//
//    String[] statuest2;
//    String[] timet2;
//    String[] authort2;
//
//
//    List<RowItem> rowItemsi, rowItemsa, rowItemsv, rowItemsf, rowItemst;
//    List<RowItem> rowItemsi2, rowItemsa2, rowItemsv2, rowItemsf2, rowItemst2;
//
//
//
//
//
//    String day1, day2, month1, month2, year1, year2, sfrom, sto;
//
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View v = inflater.inflate(R.layout.reports, container, false);
//
//        mylistview = (ListView) v.findViewById(R.id.listView);
//
//        mylistview2 = (ListView) v.findViewById(R.id.listView2);
//
//        Firebase.setAndroidContext(getActivity());
//        fb_db = new Firebase(Base_url);
//
//        category = (Spinner) v.findViewById(R.id.category);
//        subcategory = (Spinner) v.findViewById(R.id.subcategory);
//        author = (Spinner) v.findViewById(R.id.author);
//
//searchView=(SearchView)v.findViewById(R.id.searchView);
//        download = (Button) v.findViewById(R.id.download);
//        Button down2=download;
//
//        from_date = (EditText) v.findViewById(R.id.from_date);
//        to_date = (EditText) v.findViewById(R.id.to_date);
//        imgg = (ImageView) v.findViewById(R.id.frecord);
//
//
//
//
//        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String sp1 = String.valueOf(category.getSelectedItem());
//                filtered1=true;
//                maincat=sp1;
//                if (sp1.contentEquals("Academics")) {
//
//                    List<String> list = new ArrayList<String>();
//                    list.add("Select Sub-Category");
//                    list.add("Time Table");
//                    list.add("Attendance");
//                    list.add("Text Books");
//                    list.add("Test Schedule");
//                    list.add("Test Marks");
//                    list.add("Question Papers");
//                    list.add("Resources");
//                    list.add("Exam Schedule");
//                    list.add("Exam Marks");
//                    list.add("Assignments");
//                    list.add("Home Work");
//                    list.add("Record");
//                    list.add("Observation");
//                    list.add("Projects");
//                    list.add("Late Attendance");
//
//                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
//                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    dataAdapter.notifyDataSetChanged();
//                    subcategory.setAdapter(dataAdapter);
//                }
//                if (sp1.contentEquals("Administration")) {
//
//                    List<String> list = new ArrayList<String>();
//                    list.add("Select Sub-Category");
//                    list.add("Registration");
//                    list.add("Fee Payment");
//                    list.add("Reminders");
//                    list.add("Uniform");
//                    list.add("Shoes / Accessories");
//                    list.add("Functions (Annual Day, Sports Day, Science Exhibition)");
//                    list.add("Visitors / Special Guests");
//                    list.add("Special Lectures");
//                    list.add("Certificates");
//                    list.add("Holidays");
//                    list.add("Scholarships");
//                    list.add("Circulars");
//                    list.add("Notice Board");
//
//                    ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
//                    dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    dataAdapter2.notifyDataSetChanged();
//                    subcategory.setAdapter(dataAdapter2);
//                }
//                if (sp1.contentEquals("Extra-Curricular Activities")) {
//
//                    List<String> list = new ArrayList<String>();
//                    list.add("Select Sub-Category");
//                    list.add("NCC");
//                    list.add("NSS");
//                    list.add("Club Activities");
//                    list.add("Competitions");
//                    list.add("Prizes / Awards");
//                    list.add("Donations");
//                    list.add("Field Trips");
//                    list.add("Tours");
//
//                    ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
//                    dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    dataAdapter3.notifyDataSetChanged();
//                    subcategory.setAdapter(dataAdapter3);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//        subcategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                filtered2=true;
//                String sp1 = String.valueOf(subcategory.getSelectedItem());
//                subcat=sp1;
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//
//        from_date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDatePicker();
//            }
//        });
//
//        to_date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDatePicker2();
//            }
//        });
//        rowItems = new ArrayList<RowItem>();
//        rowItemsi = new ArrayList<RowItem>();
//        rowItemsa = new ArrayList<RowItem>();
//        rowItemsv = new ArrayList<RowItem>();
//        rowItemsf = new ArrayList<RowItem>();
//        rowItemst = new ArrayList<RowItem>();
//
//        rowItemsi2 = new ArrayList<RowItem>();
//        rowItemsa2 = new ArrayList<RowItem>();
//        rowItemsv2 = new ArrayList<RowItem>();
//        rowItemsf2 = new ArrayList<RowItem>();
//        rowItemst2 = new ArrayList<RowItem>();
//
//        profile_pics = getResources().obtainTypedArray(R.array.profile_pics);
//
//
//        down2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                query=searchView.getQuery().toString();
//                adapter = new CustomAdapter(getActivity(), rowItemst);
//                mylistview.setAdapter(adapter);
//
//                adapter2 = new CustomAdapter(getActivity(), rowItemst2);
//                mylistview2.setAdapter(adapter2);
//                new MyTask().execute();
//            }
//        });
//        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                seltab=grpcontent.get(position).getType();
//                switch (seltab) {
//                    case "Text":
//                        final String res = rowItemst.get(position).getAuthor() + rowItemst.get(position).getTime();
//
//                        System.out.println("Downloading" + res);
//                        String tmp5 = Base_url + "Classes/" + CurrentUser.sclass + "/" + CurrentUser.ssec + "/Texts/" + res + "/";
//                        fb_db = new Firebase(tmp5);
//                        fb_db.addListenerForSingleValueEvent(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(DataSnapshot dataSnapshot) {
//                                TextDesc obj = dataSnapshot.getValue(TextDesc.class);
//                                result = obj.text;
//                                System.out.println("TXT IS " + result);
//                                Intent i = new Intent(getActivity(), txtdisp.class);
//                                i.putExtra("value", result);
//                                startActivity(i);
//                            }
//
//                            @Override
//                            public void onCancelled(FirebaseError firebaseError) {
//
//                            }
//
//                        });
//
//
//                        break;
//                    case "Images":
//
//                        imgprog = ProgressDialog.show(getActivity(), "Download", "Downloading Image...");
//
////
////                        Toast toast =Toast.makeText(getApplicationContext(),"DOWNLOADING IMAGE",Toast.LENGTH_LONG);
////                        toast.setGravity(Gravity.CENTER,0,0);
////                        toast.show();
//
//                        final String res2 = rowItemsi.get(position).getAuthor() + rowItemsi.get(position).getTime();
//
//                        System.out.println("Downloading" + res2);
//
//                        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Classes").child(CurrentUser.sclass).child(CurrentUser.ssec).child("Images").child(res2);
//
//                        System.out.println("Storage refference : " + storageReference);
//
//                        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                            @Override
//                            public void onSuccess(Uri uri) {
//                                imgprog.dismiss();
//                                System.out.println("NOOB");
//                                Intent i = new Intent(getActivity(), imgdisp.class);
//                                ImgUri.uri = uri;
//                                startActivity(i);
//
////                                            Picasso.with(Reports.this).load(uri).fit().centerCrop().into(imgg);
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception exception) {
//                                // Handle any errors
//                                System.out.println("sad" + exception);
//                            }
//                        });
//
//                        break;
//                    case "Audios":
//                        imgprog = ProgressDialog.show(getActivity(), "Download", "Downloading Audio...");
//
//                        final String res3 = rowItemsa.get(position).getAuthor() + rowItemsa.get(position).getTime();
//                        System.out.println("Downloading" + res3);
//
//                        StorageReference storageReference2 = FirebaseStorage.getInstance().getReference().child("Classes").child(CurrentUser.sclass).child(CurrentUser.ssec).child("Audios").child(res3);
//
//                        System.out.println("Storage refference : " + storageReference2);
//
//
//                        storageReference2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                            @Override
//                            public void onSuccess(Uri uri) {
//                                System.out.println("NOOB");
//                                Intent i = new Intent();
//                                i.setAction(Intent.ACTION_VIEW);
//                                i.setDataAndType(uri, "audio/*");
//                                imgprog.dismiss();
//                                startActivity(i);
//
////                                            Picasso.with(Reports.this).load(uri).fit().centerCrop().into(imgg);
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception exception) {
//                                // Handle any errors
//                                System.out.println("sad" + exception);
//                            }
//                        });
//                        break;
//                    case "Videos":
//                        imgprog = ProgressDialog.show(getActivity(), "Download", "Downloading Video...");
//
//                        final String res4 = rowItemsv.get(position).getAuthor() + rowItemsv.get(position).getTime();
//                        System.out.println("Downloading" + res4);
//
//                        StorageReference storageReference3 = FirebaseStorage.getInstance().getReference().child("Classes").child(CurrentUser.sclass).child(CurrentUser.ssec).child("Videos").child(res4);
//
//                        System.out.println("Storage refference : " + storageReference3);
//
//
//                        storageReference3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                            @Override
//                            public void onSuccess(Uri uri) {
//                                System.out.println("NOOB");
//                                Intent i = new Intent();
//                                i.setAction(Intent.ACTION_VIEW);
//                                i.setDataAndType(uri, "video/*");
//                                imgprog.dismiss();
//                                startActivity(i);
//
////                                            Picasso.with(Reports.this).load(uri).fit().centerCrop().into(imgg);
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception exception) {
//                                // Handle any errors
//                                System.out.println("sad" + exception);
//                            }
//                        });
//                        break;
//                    case "Files":
//                        imgprog = ProgressDialog.show(getActivity(), "Download", "Downloading File...");
//
//                        final String res5 = rowItemsf.get(position).getAuthor() + rowItemsf.get(position).getTime();
//                        System.out.println("Downloading" + res5);
//
//                        final StorageReference storageReference4 = FirebaseStorage.getInstance().getReference().child("Classes").child(CurrentUser.sclass).child(CurrentUser.ssec).child("Files").child(res5);
//
//                        System.out.println("Storage refference : " + storageReference4);
//
//
//                        storageReference4.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
//
//                            @Override
//                            public void onSuccess(StorageMetadata storageMetadata) {
//
//
//                                System.out.println("Type is"+storageMetadata.getContentType()+"end");
//                                String splitarr[]=storageMetadata.getContentType().split("/");
//                                System.out.println("Sharp type is"+splitarr[splitarr.length-1]);
//                               final String ftype=storageMetadata.getContentType();
//
//                                if (ftype.contains("x-zip") || ftype.contains("word") || ftype.contains("msword")) {
//                                    file1 = Environment.getExternalStorageDirectory() + "/" + "word.docx";
//
//                                } else if (ftype.equals("octet-stream") || ftype.contains("text") || ftype.contains("xml")) {
//                                    file1 = Environment.getExternalStorageDirectory() + "/" + "text.txt";
//                                } else if (ftype.contains("pdf")) {
//                                    file1 = Environment.getExternalStorageDirectory() + "/" + "pdf." + splitarr[splitarr.length - 1];
//
//                                }
//                                final File files = new File(file1);
//
//                                storageReference4.getFile(files).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                                    @Override
//                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//
//                                        // Metadata now contains the metadata for 'images/forest.jpg'
//                                        imgprog.dismiss();
//
//                                        Intent intent = new Intent(Intent.ACTION_VIEW);
//                                        if (ftype.contains("pdf")) {
//                                            intent.setDataAndType(Uri.fromFile(files), ftype);
//                                        } else if (ftype.equals("octet-stream") || ftype.contains("text") || ftype.contains("xml")) {
//                                            intent.setDataAndType(Uri.fromFile(files), "text/plain");
//
//                                        } else if (ftype.contains("x-zip") || ftype.contains("word") || ftype.contains("msword")) {
//                                            intent.setDataAndType(Uri.fromFile(files), "application/msword");
//
//                                        } else if (ftype.equals("presentation")) {
//                                            intent.setDataAndType(Uri.fromFile(files), "application/vnd.ms-powerpoint");
//
//                                        } else if (ftype.equals("spreadsheet") || ftype.equals("sheet")) {
//                                            intent.setDataAndType(Uri.fromFile(files), "application/vnd.ms-excel");
//
//                                        }
//                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//
//                                        try {
//                                            startActivity(intent);
//                                        } catch (Exception e) {
//                                            System.out.println("EXCEPTION IS "+e);
//                                            Toast.makeText(getActivity(),"Invalid File type", Toast.LENGTH_LONG).show();
//                                            // Instruct the user to install a PDF reader here, or something
//                                        }
//
//                                    }
//                                }).addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception exception) {
//                                        // Uh-oh, an error occurred!
//                                    }
//                                });
//
//
//
////                                            Picasso.with(Reports.this).load(uri).fit().centerCrop().into(imgg);
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception exception) {
//                                // Handle any errors
//                                System.out.println("sad" + exception);
//                            }
//                        });
//                        break;
//                }
//            }
//        });
//        mylistview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                seltab=percontent.get(position).getType();
//                switch (seltab) {
//                    case "Text":
//                        imgprog = ProgressDialog.show(getActivity(),"Download","Downloading Text");
//
//                        final String res = rowItemst2.get(position).getAuthor() + rowItemst2.get(position).getTime();
//
//                        System.out.println("Downloading2" + res);
//                        String tmp5 = Base_url + "Classes/" + CurrentUser.sclass + "/" + CurrentUser.ssec + "/Texts/" + res + "/";
//                        fb_db = new Firebase(tmp5);
//                        fb_db.addListenerForSingleValueEvent(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(DataSnapshot dataSnapshot) {
//                                TextDesc obj = dataSnapshot.getValue(TextDesc.class);
//                                result = obj.text;
//                                System.out.println("TXT IS " + result);
//                                Intent i = new Intent(getActivity(), txtdisp.class);
//                                i.putExtra("value", result);
//                                imgprog.dismiss();
//                                startActivity(i);
//                            }
//
//                            @Override
//                            public void onCancelled(FirebaseError firebaseError) {
//
//                            }
//
//                        });
//
//
//                        break;
//                    case "Images":
//
//                        imgprog = ProgressDialog.show(getActivity(), "Download", "Downloading Image...");
//
////
////                        Toast toast =Toast.makeText(getApplicationContext(),"DOWNLOADING IMAGE",Toast.LENGTH_LONG);
////                        toast.setGravity(Gravity.CENTER,0,0);
////                        toast.show();
//
//                        final String res2 = rowItemsi2.get(position).getAuthor() + rowItemsi2.get(position).getTime();
//
//                        System.out.println("Downloading2" + res2);
//
//                        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Classes").child(CurrentUser.sclass).child(CurrentUser.ssec).child("Images").child(res2);
//
//                        System.out.println("Storage refference2 : " + storageReference);
//
//                        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                            @Override
//                            public void onSuccess(Uri uri) {
//                                imgprog.dismiss();
//                                System.out.println("NOOB2");
//                                Intent i = new Intent(getActivity(), imgdisp.class);
//                                ImgUri.uri = uri;
//                                startActivity(i);
//
////                                            Picasso.with(Reports.this).load(uri).fit().centerCrop().into(imgg);
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception exception) {
//                                // Handle any errors
//                                System.out.println("sad2" + exception);
//                            }
//                        });
//
//                        break;
//                    case "Audios":
//                        imgprog = ProgressDialog.show(getActivity(), "Download", "Downloading Audio...");
//
//                        final String res3 = rowItemsa2.get(position).getAuthor() + rowItemsa2.get(position).getTime();
//                        System.out.println("Downloading2" + res3);
//
//                        StorageReference storageReference2 = FirebaseStorage.getInstance().getReference().child("Classes").child(CurrentUser.sclass).child(CurrentUser.ssec).child("Audios").child(res3);
//
//                        System.out.println("Storage refference : " + storageReference2);
//
//
//                        storageReference2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                            @Override
//                            public void onSuccess(Uri uri) {
//                                imgprog.dismiss();
//                                System.out.println("NOOB");
//                                Intent i = new Intent();
//                                i.setAction(Intent.ACTION_VIEW);
//                                i.setDataAndType(uri, "audio/*");
//                                startActivity(i);
//
////                                            Picasso.with(Reports.this).load(uri).fit().centerCrop().into(imgg);
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception exception) {
//                                // Handle any errors
//                                System.out.println("sad" + exception);
//                            }
//                        });
//                        break;
//                    case "Videos":
//                        imgprog = ProgressDialog.show(getActivity(), "Download", "Downloading Video...");
//
//                        final String res4 = rowItemsv2.get(position).getAuthor() + rowItemsv2.get(position).getTime();
//                        System.out.println("Downloading2" + res4);
//
//                        StorageReference storageReference3 = FirebaseStorage.getInstance().getReference().child("Classes").child(CurrentUser.sclass).child(CurrentUser.ssec).child("Videos").child(res4);
//
//                        System.out.println("Storage refference2 : " + storageReference3);
//
//
//                        storageReference3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                            @Override
//                            public void onSuccess(Uri uri) {
//                                imgprog.dismiss();
//                                System.out.println("NOOB2");
//                                Intent i = new Intent();
//                                i.setAction(Intent.ACTION_VIEW);
//                                i.setDataAndType(uri, "video/*");
//                                startActivity(i);
//
////                                            Picasso.with(Reports.this).load(uri).fit().centerCrop().into(imgg);
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception exception) {
//                                // Handle any errors
//                                System.out.println("sad" + exception);
//                            }
//                        });
//                        break;
//                    case "Files":
//                        imgprog = ProgressDialog.show(getActivity(), "Download", "Downloading File...");
//
//                        final String res5 = rowItemsf2.get(position).getAuthor() + rowItemsf2.get(position).getTime();
//                        System.out.println("Downloading2" + res5);
//
//                        final StorageReference storageReference4 = FirebaseStorage.getInstance().getReference().child("Classes").child(CurrentUser.sclass).child(CurrentUser.ssec).child("Files").child(res5);
//
//                        System.out.println("Storage refference2 : " + storageReference4);
//
//                        storageReference4.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
//                            @Override
//                            public void onSuccess(StorageMetadata storageMetadata) {
//                                System.out.println("Type is" + storageMetadata.getContentType() + "end");
//                                String splitarr[] = storageMetadata.getContentType().split("/");
//                                System.out.println("Sharp type is" + splitarr[splitarr.length - 1]);
//                                final String ftype = storageMetadata.getContentType();
//
//                                if(ftype.contains("x-zip")||ftype.contains("word")||ftype.contains("msword")){                                                                  file1 = Environment.getExternalStorageDirectory() + "/" + "word.docx";
//
//                                } else if(ftype.equals("octet-stream")||ftype.contains("text")||ftype.contains("xml")) {
//                                    file1 = Environment.getExternalStorageDirectory() + "/" + "text.txt";
//                                } else if(ftype.contains("pdf")){
//                                    file1 = Environment.getExternalStorageDirectory() + "/" + "pdf." + splitarr[splitarr.length - 1];
//
//                                }
//                                final File files = new File(file1);
//
//                                storageReference4.getFile(files).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                                    @Override
//                                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//
//                                        Intent intent = new Intent(Intent.ACTION_VIEW);
//                                        if(ftype.contains("pdf")){
//                                            intent.setDataAndType(Uri.fromFile(files), ftype);
//                                        }else if(ftype.equals("octet-stream")||ftype.contains("text")||ftype.contains("xml"))
//                                        {
//                                            intent.setDataAndType(Uri.fromFile(files), "text/plain");
//
//                                        }else if(ftype.contains("x-zip")||ftype.contains("word")||ftype.contains("msword"))
//                                        {
//                                            intent.setDataAndType(Uri.fromFile(files), "application/msword");
//
//                                        }else if(ftype.equals("presentation"))
//                                        {
//                                            intent.setDataAndType(Uri.fromFile(files), "application/vnd.ms-powerpoint");
//
//                                        }
//                                        else if(ftype.equals("spreadsheet")||ftype.equals("sheet"))
//                                        {
//                                            intent.setDataAndType(Uri.fromFile(files), "application/vnd.ms-excel");
//
//                                        }
//                                        // Check what kind of file you are trying to open, by comparing the url with extensions.
//                                        // When the if condition is matched, plugin sets the correct intent (mime) type,
//                                        // so Android knew what application to use to open the file
//                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//
//                                        try {
//                                            imgprog.dismiss();
//                                            startActivity(intent);
//                                        } catch (Exception e) {
//                                            System.out.println("EXCEPTION IS " + e);
//                                            imgprog.dismiss();
//                                            Toast.makeText(getActivity(), "Invalid File type", Toast.LENGTH_LONG).show();
//                                            // Instruct the user to install a PDF reader here, or something
//                                        }
//
//                                    }
//                                });
//
//
//                            }
//                        });
//
//                        break;
//                }
//            }
//        });
//
//        return v;
//    }
//
//
//    private void showDatePicker() {
//        DatePickerFragment date = new DatePickerFragment();
//        /**
//         * Set Up Current Date Into dialog
//         */
//        Calendar calender = Calendar.getInstance();
//        Bundle args = new Bundle();
//        args.putInt("year", calender.get(Calendar.YEAR));
//        args.putInt("month", calender.get(Calendar.MONTH));
//        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
//        date.setArguments(args);
//        /**
//         * Set Call back to capture selected date
//         */
//        date.setCallBack(ondate_from);
//        date.show(getFragmentManager(), "Date Picker");
//    }
//
//    DatePickerDialog.OnDateSetListener ondate_from = new DatePickerDialog.OnDateSetListener() {
//
//        public void onDateSet(DatePicker view, int year, int monthOfYear,
//                              int dayOfMonth) {
//
//            from_date.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear + 1) + "-" + String.valueOf(year));
//            day1 = String.valueOf(dayOfMonth);
//            month1 = String.valueOf(monthOfYear + 1);
//            year1 = String.valueOf(year);
//            if (day1.length() == 1) {
//                day1 = "0" + day1;
//            }
//            if (month1.length() == 1) {
//                month1 = "0" + month1;
//            }
//            sfrom = year1 + "-" + month1 + "-" + day1 + " 00:00:00";
//
//        }
//    };
//
//    private void showDatePicker2() {
//        DatePickerFragment date = new DatePickerFragment();
//        /**
//         * Set Up Current Date Into dialog
//         */
//        Calendar calender = Calendar.getInstance();
//        Bundle args = new Bundle();
//        args.putInt("year", calender.get(Calendar.YEAR));
//        args.putInt("month", calender.get(Calendar.MONTH));
//        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
//        date.setArguments(args);
//        /**
//         * Set Call back to capture selected date
//         */
//        date.setCallBack(ondate_to);
//        date.show(getFragmentManager(), "Date Picker");
//    }
//
//    DatePickerDialog.OnDateSetListener ondate_to = new DatePickerDialog.OnDateSetListener() {
//
//        public void onDateSet(DatePicker view, int year, int monthOfYear,
//                              int dayOfMonth) {
//
//            to_date.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear + 1)
//                    + "-" + String.valueOf(year));
//            day2 = String.valueOf(dayOfMonth);
//            month2 = String.valueOf(monthOfYear + 1);
//            year2 = String.valueOf(year);
//            if (day2.length() == 1) {
//                day2 = "0" + day2;
//            }
//            if (month2.length() == 1) {
//                month2 = "0" + month2;
//            }
//            sto = year2 + "-" + month2 + "-" + day2 + " 23:59:59";
//
//        }
//    };
//
//
////    @Override
////    public void onClick(View view) {
////        switch (view.getId()) {
////            case R.id.menuitem1:
////                seltab = "Text";
////                adapter = new CustomAdapterGT(Reports.this, rowItemst);
////                mylistview.setAdapter(adapter);
////                adapter2 = new CustomAdapterGT(Reports.this, rowItemst2);
////                mylistview2.setAdapter(adapter2);
////                break;
////            case R.id.menuitem2:
////                seltab = "Image";
////                adapter = new CustomAdapterGT(Reports.this, rowItemsi);
////                mylistview.setAdapter(adapter);
////                adapter2 = new CustomAdapterGT(Reports.this, rowItemsi2);
////                mylistview2.setAdapter(adapter2);
////                break;
////            case R.id.menuitem3:
////                seltab = "Audio";
////                adapter = new CustomAdapterGT(Reports.this, rowItemsa);
////                mylistview.setAdapter(adapter);
////                adapter2 = new CustomAdapterGT(Reports.this, rowItemsa2);
////                mylistview2.setAdapter(adapter2);
////                break;
////            case R.id.menuitem4:
////                seltab = "Video";
////                adapter = new CustomAdapterGT(Reports.this, rowItemsv);
////                mylistview.setAdapter(adapter);
////                adapter2 = new CustomAdapterGT(Reports.this, rowItemsv2);
////                mylistview2.setAdapter(adapter2);
////                break;
////            case R.id.menuitem5:
////                seltab = "File";
////                adapter = new CustomAdapterGT(Reports.this, rowItemsf);
////                mylistview.setAdapter(adapter);
////                adapter2 = new CustomAdapterGT(Reports.this, rowItemsf2);
////                mylistview2.setAdapter(adapter2);
////                break;
////        }
////    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position,
//                            long id) {
//
//        String member_name = rowItems.get(position).getMember_name();
//        Toast.makeText(getActivity(), "" + member_name,
//                Toast.LENGTH_SHORT).show();
//    }
//
//
//    private class MyTask extends AsyncTask<String, Integer, String> {
//
//        // Runs in UI before background thread is called
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            imgprog = ProgressDialog.show(getActivity(), "Message", "Fetching Data...");
//
//        }
//
//        // This is run in a background thread
//        @Override
//        protected String doInBackground(String... params) {
//            //images
//            tmp1 = Base_url + "Classes/" + CurrentUser.sclass + "/" + CurrentUser.ssec + "/Images/";
//            fb_db = new Firebase(tmp1);
//            fb_db.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    contenti = new ArrayList<>();
//                    namei = new ArrayList<>();
//                    categi = new ArrayList<>();
//                    datesi = new ArrayList<>();
//                    authi = new ArrayList<String>();
//                    rowItemsi.clear();
//
//                    contenti2 = new ArrayList<>();
//                    namei2 = new ArrayList<>();
//                    categi2 = new ArrayList<>();
//                    datesi2 = new ArrayList<>();
//                    authi2 = new ArrayList<String>();
//
//
//                    rowItemsi2.clear();
////                    adapter.notifyDataSetChanged();
////                    adapter2.notifyDataSetChanged();
//                    System.out.println("Entering");
//
//                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                        ImageDesc images = postSnapshot.getValue(ImageDesc.class);
//                        String date = images.date;
//                        String desc = images.desc;
//                        System.out.println("Checking" + postSnapshot.getKey());
//                        go=true;
//                        if (checkdate(date)) {
//                            if (filtered1) {
//                                if (images.maincat.equals(maincat)) {
//                                    go = true;
//                                    if (filtered2) {
//                                        if (images.subcat.equals(subcat)) {
//                                            go = true;
//                                        } else {
//                                            go = false;
//                                        }
//                                    }
//                                } else {
//                                    go = false;
//                                }
//                            }
//                            if(query!=null)
//                            {
//                                if(query.contains(desc)||desc.contains(query))
//                                {
//                                    go=true;
//                                }
//                                else
//                                {
//                                    go=false;
//                                }
//                            }
//
//
//
//                            if (go) {
//                                if (images.target.equals("all")) {
//                                    System.out.println("Image date passed:" + postSnapshot.getKey());
//                                    namei.add(images.desc);
//                                    categi.add(images.maincat + " : " + images.subcat);
//                                    datesi.add(images.date);
//                                    authi.add(images.user);
//                                    System.out.println("Added" + namei.size());
//                                    member_namesi = new String[namei.size()];
//                                    statuesi = new String[namei.size()];
//                                    timei = new String[namei.size()];
//                                    authori = new String[authi.size()];
//
//                                    for (int i = 0; i < namei.size(); i++) {
//
//
//                                        System.out.println("title is " + namei.get(i));
//                                        member_namesi[i] = namei.get(i);
//                                        statuesi[i] = categi.get(i);
//                                        timei[i] = datesi.get(i);
//                                        authori[i] = authi.get(i);
//                                    }
//
//                                } else {
//                                    flagz = false;
//                                    for (int i = 0; i < images.targetmems.size(); i++) {
//                                        if (CurrentUser.user.equals(images.targetmems.get(i))) {
//                                            flagz = true;
//                                            break;
//                                        }
//                                    }
//                                    if (flagz) {
//                                        flagz = false;
//                                        System.out.println("Image date passed:" + postSnapshot.getKey());
//                                        namei2.add(images.desc);
//                                        categi2.add(images.maincat + " : " + images.subcat);
//                                        datesi2.add(images.date);
//                                        authi2.add(images.user);
//                                        System.out.println("Added" + namei2.size());
//                                        member_namesi2 = new String[namei2.size()];
//                                        statuesi2 = new String[namei2.size()];
//                                        timei2 = new String[namei2.size()];
//                                        authori2 = new String[authi2.size()];
//                                        for (int i = 0; i < namei2.size(); i++) {
//
//
//                                            System.out.println("title is " + namei2.get(i));
//                                            member_namesi2[i] = namei2.get(i);
//                                            statuesi2[i] = categi2.get(i);
//                                            timei2[i] = datesi2.get(i);
//                                            authori2[i] = authi2.get(i);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    if (namei.size() > 0) {
//                        System.out.println("Row cnt is" + member_namesi.length);
//                        for (int i = 0; i < member_namesi.length; i++) {
//                            RowItem item = new RowItem(member_namesi[i],
//                                    R.drawable.picture, statuesi[i],
//                                    timei[i], authori[i],"Images");
//                            rowItemsi.add(item);
//                            System.out.println("mangatha added" + rowItemsi);
//                        }
//
//                        getfiles();
//                        RepContent.grpcontent=new ArrayList<RowItem>(grpcontent);
//                        CustomAdapter adapter = new CustomAdapter(getActivity(), grpcontent);
//                        Repgroup_tab.setContent(adapter);
//
//                        //  profile_pics.recycle();
//
//                    }
//                    if (namei2.size() > 0) {
//                        System.out.println("Row cnt is" + member_namesi2.length);
//                        for (int i = 0; i < member_namesi2.length; i++) {
//                            RowItem item = new RowItem(member_namesi2[i],
//                                    R.drawable.picture, statuesi2[i],
//                                    timei2[i], authori2[i],"Images");
//                            rowItemsi2.add(item);
//                            System.out.println("mangatha added" + rowItemsi2);
//                        }
//
//                        getfiles();
//                        RepContent.percontent=new ArrayList<RowItem>(percontent);
//                        CustomAdapter adapter = new CustomAdapter(getActivity(), percontent);
//                        Repindi_tab.setContent(adapter);
//                        //  profile_pics.recycle();
//
//                    }
//
//                }
//
//                @Override
//                public void onCancelled(FirebaseError firebaseError) {
//                    System.out.println("FIREBASE ERROR OCCOURED");
//                }
//            });
////audio
//            tmp2 = Base_url + "Classes/" + CurrentUser.sclass + "/" + CurrentUser.ssec + "/Audios/";
//            fb_db = new Firebase(tmp2);
//            fb_db.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    contenta = new ArrayList<>();
//                    namea = new ArrayList<>();
//                    catega = new ArrayList<>();
//                    datesa = new ArrayList<>();
//                    autha = new ArrayList<String>();
//                    rowItemsa.clear();
//
//                    contenta2 = new ArrayList<>();
//                    namea2 = new ArrayList<>();
//                    catega2 = new ArrayList<>();
//                    datesa2 = new ArrayList<>();
//                    autha2 = new ArrayList<String>();
//                    rowItemsa2.clear();
//
////                    adapter.notifyDataSetChanged();
////                    adapter2.notifyDataSetChanged();
//
//                    System.out.println("Entering");
//
//                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                        Audiodesc audiodesc = postSnapshot.getValue(Audiodesc.class);
//                        String date = audiodesc.date;
//                        String desc = audiodesc.desc;
//                        System.out.println("Checking" + postSnapshot.getKey());
//                        go=true;
//                        if (checkdate(date)) {
//                            if (filtered1) {
//                                if (audiodesc.maincat.equals(maincat)) {
//                                    go = true;
//                                    if (filtered2) {
//                                        if (audiodesc.subcat.equals(subcat)) {
//                                            go = true;
//                                        } else {
//                                            go = false;
//                                        }
//                                    }
//                                } else {
//                                    go = false;
//                                }
//                            }
//                            if(query!=null)
//                            {
//                                if(query.contains(desc)||desc.contains(query))
//                                {
//                                    go=true;
//                                }
//                                else
//                                {
//                                    go=false;
//                                }
//                            }
//                            if (go) {
//                                if (audiodesc.target.equals("all")) {
//
//
//                                    System.out.println("Audio date passed:" + postSnapshot.getKey());
//                                    namea.add(audiodesc.desc);
//                                    catega.add(audiodesc.maincat + " : " + audiodesc.subcat);
//                                    datesa.add(audiodesc.date);
//                                    autha.add(audiodesc.user);
//                                    System.out.println("Added" + namea.size());
//                                    member_namesa = new String[namea.size()];
//                                    statuesa = new String[namea.size()];
//                                    timea = new String[namea.size()];
//                                    authora = new String[autha.size()];
//                                    for (int i = 0; i < namea.size(); i++) {
//
//
//                                        System.out.println("title is " + namea.get(i));
//                                        member_namesa[i] = namea.get(i);
//                                        statuesa[i] = catega.get(i);
//                                        timea[i] = datesa.get(i);
//                                        authora[i] = autha.get(i);
//                                    }
//
//                                } else {
//                                    flagz = false;
//                                    for (int i = 0; i < audiodesc.targetmems.size(); i++) {
//                                        if (CurrentUser.user.equals(audiodesc.targetmems.get(i))) {
//                                            flagz = true;
//                                            break;
//                                        }
//                                    }
//                                    if (flagz) {
//                                        flagz = false;
//                                        System.out.println("Image date passed:" + postSnapshot.getKey());
//                                        namea2.add(audiodesc.desc);
//                                        catega2.add(audiodesc.maincat + " : " + audiodesc.subcat);
//                                        datesa2.add(audiodesc.date);
//                                        autha2.add(audiodesc.user);
//                                        System.out.println("Added" + namea2.size());
//                                        member_namesa2 = new String[namea2.size()];
//                                        statuesa2 = new String[namea2.size()];
//                                        timea2 = new String[namea2.size()];
//                                        authora2 = new String[autha2.size()];
//                                        for (int i = 0; i < namea2.size(); i++) {
//
//
//                                            System.out.println("title is " + namea2.get(i));
//                                            member_namesa2[i] = namea2.get(i);
//                                            statuesa2[i] = catega2.get(i);
//                                            timea2[i] = datesa2.get(i);
//                                            authora2[i] = autha2.get(i);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                    if (namea.size() > 0) {
//                        System.out.println("Row cnt is" + member_namesa.length);
//                        for (int i = 0; i < member_namesa.length; i++) {
//                            RowItem item = new RowItem(member_namesa[i],
//                                    R.drawable.music, statuesa[i],
//                                    timea[i], authora[i],"Audios");
//                            rowItemsa.add(item);
//                            System.out.println("mangatha added" + rowItemsa);
//                        }
//
//                        getfiles();
//                        RepContent.grpcontent=new ArrayList<RowItem>(grpcontent);
//                        CustomAdapter adapter = new CustomAdapter(getActivity(), grpcontent);
//                        Repgroup_tab.setContent(adapter);
//                        //  profile_pics.recycle();
//
//
//                    }
//                    if (namea2.size() > 0) {
//                        System.out.println("Row cnt is" + member_namesa2.length);
//                        for (int i = 0; i < member_namesa2.length; i++) {
//                            RowItem item2 = new RowItem(member_namesa2[i],
//                                    R.drawable.picture, statuesa2[i],
//                                    timea2[i], authora2[i],"Audios");
//                            rowItemsa2.add(item2);
//                            System.out.println("mangatha added here" + rowItemsa2.get(0).getMember_name());
//                        }
//                        getfiles();
//                        RepContent.percontent=new ArrayList<RowItem>(percontent);
//                        CustomAdapter adapter = new CustomAdapter(getActivity(), percontent);
//                        Repindi_tab.setContent(adapter);
//                    }
//
//                }
//
//                @Override
//                public void onCancelled(FirebaseError firebaseError) {
//                    System.out.println("FIREBASE ERROR OCCOURED");
//                }
//            });
////video
//            tmp3 = Base_url + "Classes/" + CurrentUser.sclass + "/" + CurrentUser.ssec + "/Videos/";
//            fb_db = new Firebase(tmp3);
//            fb_db.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    contentv = new ArrayList<>();
//                    namev = new ArrayList<>();
//                    categv = new ArrayList<>();
//                    datesv = new ArrayList<>();
//                    authv = new ArrayList<String>();
//                    rowItemsv.clear();
//
//                    contentv2 = new ArrayList<>();
//                    namev2 = new ArrayList<>();
//                    categv2 = new ArrayList<>();
//                    datesv2 = new ArrayList<>();
//                    authv2 = new ArrayList<String>();
//
//                    rowItemsv2.clear();
//
////                    adapter.notifyDataSetChanged();
////                    adapter2.notifyDataSetChanged();
//                    System.out.println("Entering");
//
//                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                        VideoDesc images = postSnapshot.getValue(VideoDesc.class);
//                        String date = images.date;
//                        String desc = images.desc;
//                        System.out.println("Checking" + postSnapshot.getKey());
//                        go=true;
//                        if (checkdate(date)) {
//                            if (filtered1) {
//                                if (images.maincat.equals(maincat)) {
//                                    go = true;
//                                    if (filtered2) {
//                                        if (images.subcat.equals(subcat)) {
//                                            go = true;
//                                        } else {
//                                            go = false;
//                                        }
//                                    }
//                                } else {
//                                    go = false;
//                                }
//                            }
//                            if(query!=null)
//                            {
//                                if(query.contains(desc)||desc.contains(query))
//                                {
//                                    go=true;
//                                }
//                                else
//                                {
//                                    go=false;
//                                }
//                            }
//                            if(go) {
//                                if (images.target.equals("all")) {
//
//                                    System.out.println("Videos date passed:" + postSnapshot.getKey());
//                                    namev.add(images.desc);
//                                    categv.add(images.maincat + " : " + images.subcat);
//                                    datesv.add(images.date);
//                                    authv.add(images.user);
//                                    System.out.println("Added" + namev.size());
//                                    member_namesv = new String[namev.size()];
//                                    statuesv = new String[namev.size()];
//                                    timev = new String[namev.size()];
//                                    authorv = new String[authv.size()];
//                                    for (int i = 0; i < namev.size(); i++) {
//
//
//                                        System.out.println("title is " + namev.get(i));
//                                        member_namesv[i] = namev.get(i);
//                                        statuesv[i] = categv.get(i);
//                                        timev[i] = datesv.get(i);
//                                        authorv[i] = authv.get(i);
//                                    }
//
//                                } else {
//                                    flagz = false;
//                                    for (int i = 0; i < images.targetmems.size(); i++) {
//                                        if (CurrentUser.user.equals(images.targetmems.get(i))) {
//                                            flagz = true;
//                                            break;
//                                        }
//                                    }
//                                    if (flagz) {
//                                        flagz = false;
//                                        System.out.println("Image date passed:" + postSnapshot.getKey());
//                                        namev2.add(images.desc);
//                                        categv2.add(images.maincat + " : " + images.subcat);
//                                        datesv2.add(images.date);
//                                        authv2.add(images.user);
//                                        System.out.println("Added" + namev2.size());
//                                        member_namesv2 = new String[namev2.size()];
//                                        statuesv2 = new String[namev2.size()];
//                                        timev2 = new String[namev2.size()];
//                                        authorv2 = new String[authv2.size()];
//                                        for (int i = 0; i < namev2.size(); i++) {
//
//
//                                            System.out.println("title is " + namev2.get(i));
//                                            member_namesv2[i] = namev2.get(i);
//                                            statuesv2[i] = categv2.get(i);
//                                            timev2[i] = datesi2.get(i);
//                                            authorv2[i] = authv2.get(i);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                        //       }
//                    }
//
//                    if (namev.size() > 0) {
//                        System.out.println("Row cnt is" + member_namesv.length);
//                        for (int i = 0; i < member_namesv.length; i++) {
//                            RowItem item = new RowItem(member_namesv[i],
//                                    R.drawable.clip, statuesv[i],
//                                    timev[i], authorv[i],"Videos");
//                            rowItemsv.add(item);
//                            System.out.println("mangatha added" + rowItemsv);
//                        }
//
//                        getfiles();
//                        RepContent.grpcontent=new ArrayList<RowItem>(grpcontent);
//                        CustomAdapter adapter = new CustomAdapter(getActivity(), grpcontent);
//                        Repgroup_tab.setContent(adapter);
//                        //  profile_pics.recycle();
//
//                    }
//                    if (namev2.size() > 0) {
//                        System.out.println("Row cnt is" + member_namesv2.length);
//                        for (int i = 0; i < member_namesv2.length; i++) {
//                            RowItem item2 = new RowItem(member_namesv2[i],
//                                    R.drawable.picture, statuesv2[i],
//                                    timev2[i], authorv2[i],"Videos");
//                            rowItemsv2.add(item2);
//                            System.out.println("mangatha added" + rowItemsv2);
//                        }
//                        getfiles();
//                        RepContent.percontent=new ArrayList<RowItem>(percontent);
//                        CustomAdapter adapter = new CustomAdapter(getActivity(), percontent);
//                        Repindi_tab.setContent(adapter);
//
//                    }
//
//                }
//
//                @Override
//                public void onCancelled(FirebaseError firebaseError) {
//                    System.out.println("FIREBASE ERROR OCCOURED");
//                }
//            });
////file
//            tmp4 = Base_url + "Classes/" + CurrentUser.sclass + "/" + CurrentUser.ssec + "/Files/";
//            fb_db = new Firebase(tmp4);
//            fb_db.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    contentf = new ArrayList<>();
//                    namef = new ArrayList<>();
//                    categf = new ArrayList<>();
//                    datesf = new ArrayList<>();
//                    authf = new ArrayList<String>();
//                    rowItemsf.clear();
//
//                    contentf2 = new ArrayList<>();
//                    namef2 = new ArrayList<>();
//                    categf2 = new ArrayList<>();
//                    datesf2 = new ArrayList<>();
//                    authf2 = new ArrayList<String>();
//
//                    rowItemsf2.clear();
////                    adapter.notifyDataSetChanged();
////                    adapter2.notifyDataSetChanged();
//                    System.out.println("Entering");
//
//                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                        FileDesc fileDesc = postSnapshot.getValue(FileDesc.class);
//                        String date = fileDesc.date;
//                        String desc = fileDesc.desc;
//                        System.out.println("Checking" + postSnapshot.getKey());
//                        go=true;
//                        if (checkdate(date)) {
//                            if (filtered1) {
//                                if (fileDesc.maincat.equals(maincat)) {
//                                    go = true;
//                                    if (filtered2) {
//                                        if (fileDesc.subcat.equals(subcat)) {
//                                            go = true;
//                                        } else {
//                                            go = false;
//                                        }
//                                    }
//                                } else {
//                                    go = false;
//                                }
//                            }
//                            if(query!=null)
//                            {
//                                if(query.contains(desc)||desc.contains(query))
//                                {
//                                    go=true;
//                                }
//                                else
//                                {
//                                    go=false;
//                                }
//                            }
//                            if (go) {
//                                if (fileDesc.target.equals("all")) {
//
//                                    System.out.println("Files date passed:" + postSnapshot.getKey());
//                                    namef.add(fileDesc.desc);
//                                    categf.add(fileDesc.maincat + " : " + fileDesc.subcat);
//                                    datesf.add(fileDesc.date);
//                                    authf.add(fileDesc.user);
//                                    System.out.println("Added" + namef.size());
//                                    member_namesf = new String[namef.size()];
//                                    statuesf = new String[namef.size()];
//                                    timef = new String[namef.size()];
//                                    authorf = new String[authf.size()];
//                                    for (int i = 0; i < namef.size(); i++) {
//
//
//                                        System.out.println("title is " + namef.get(i));
//                                        member_namesf[i] = namef.get(i);
//                                        statuesf[i] = categf.get(i);
//                                        timef[i] = datesf.get(i);
//                                        authorf[i] = authf.get(i);
//                                    }
//
//                                } else {
//                                    flagz = false;
//                                    for (int i = 0; i < fileDesc.targetmems.size(); i++) {
//                                        if (CurrentUser.user.equals(fileDesc.targetmems.get(i))) {
//                                            flagz = true;
//                                            break;
//                                        }
//                                    }
//                                    if (flagz) {
//                                        flagz = false;
//                                        System.out.println("Image date passed:" + postSnapshot.getKey());
//                                        namef2.add(fileDesc.desc);
//                                        categf2.add(fileDesc.maincat + " : " + fileDesc.subcat);
//                                        datesf2.add(fileDesc.date);
//                                        authf2.add(fileDesc.user);
//                                        System.out.println("Added" + namef2.size());
//                                        member_namesf2 = new String[namef2.size()];
//                                        statuesf2 = new String[namef2.size()];
//                                        timef2 = new String[namef2.size()];
//                                        authorf2 = new String[authf2.size()];
//                                        for (int i = 0; i < namef2.size(); i++) {
//
//
//                                            System.out.println("title is " + namef2.get(i));
//                                            member_namesf2[i] = namef2.get(i);
//                                            statuesf2[i] = categf2.get(i);
//                                            timef2[i] = datesf2.get(i);
//                                            authorf2[i] = authf2.get(i);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                    if (namef.size() > 0) {
//                        System.out.println("Row cnt is" + member_namesf.length);
//                        for (int i = 0; i < member_namesf.length; i++) {
//                            RowItem item = new RowItem(member_namesf[i],
//                                    R.drawable.files, statuesf[i],
//                                    timef[i], authorf[i],"Files");
//                            rowItemsf.add(item);
//                            System.out.println("mangatha added" + rowItemsf);
//                        }
//
//                        getfiles();
//                        RepContent.grpcontent=new ArrayList<RowItem>(grpcontent);
//                        CustomAdapter adapter = new CustomAdapter(getActivity(), grpcontent);
//                        Repgroup_tab.setContent(adapter);
//                        //  profile_pics.recycle();
//
//                    }
//
//                    if (namef2.size() > 0) {
//                        System.out.println("Row cnt is" + member_namesf2.length);
//                        for (int i = 0; i < member_namesf2.length; i++) {
//                            RowItem item2 = new RowItem(member_namesf2[i],
//                                    R.drawable.picture, statuesf2[i],
//                                    timef2[i], authorf2[i],"Files");
//                            rowItemsf2.add(item2);
//                            System.out.println("mangatha added" + rowItemsf2);
//                        }
//                        getfiles();
//                        RepContent.percontent=new ArrayList<RowItem>(percontent);
//                        CustomAdapter adapter = new CustomAdapter(getActivity(), percontent);
//                        Repindi_tab.setContent(adapter);
//
//                    }
//
//                }
//
//                @Override
//                public void onCancelled(FirebaseError firebaseError) {
//                    System.out.println("FIREBASE ERROR OCCOURED");
//                }
//            });
////text
//
//
//            tmp5 = Base_url + "Classes/" + CurrentUser.sclass + "/" + CurrentUser.ssec + "/Texts/";
//            fb_db = new Firebase(tmp5);
//
//            fb_db.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    contentt = new ArrayList<>();
//                    namet = new ArrayList<>();
//                    categt = new ArrayList<>();
//                    datest = new ArrayList<>();
//                    autht = new ArrayList<String>();
//                    rowItemst.clear();
//
//
//                    namet2 = new ArrayList<>();
//                    categt2 = new ArrayList<>();
//                    datest2 = new ArrayList<>();
//                    autht2 = new ArrayList<String>();
//
//                    rowItemst2.clear();
////                    adapter.notifyDataSetChanged();
////                    adapter2.notifyDataSetChanged();
//                    System.out.println("Entering");
//
//                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                        TextDesc textDesc = postSnapshot.getValue(TextDesc.class);
//                        String date = textDesc.date;
//                        String desc = textDesc.desc;
//                        System.out.println("Checking" + postSnapshot.getKey());
//                        go=true;
//                        if (checkdate(date)) {
//                            if (filtered1) {
//                                if (textDesc.maincat.equals(maincat)) {
//                                    go = true;
//                                    if (filtered2) {
//                                        if (textDesc.subcat.equals(subcat)) {
//                                            go = true;
//                                        } else {
//                                            go = false;
//                                        }
//                                    }
//                                } else {
//                                    go = false;
//                                }
//                            }
//                            if(query!=null)
//                            {
//                                if(query.contains(desc)||desc.contains(query))
//                                {
//                                    go=true;
//                                }
//                                else
//                                {
//                                    go=false;
//                                }
//                            }
//                            if(go) {
//                                if (textDesc.target.equals("all")) {
//
//
//                                    System.out.println("Files date passed:" + postSnapshot.getKey());
//                                    namet.add(textDesc.desc);
//                                    categt.add(textDesc.maincat + " : " + textDesc.subcat);
//                                    datest.add(textDesc.date);
//                                    contentt.add(textDesc.text);
//                                    autht.add(textDesc.user);
//                                    System.out.println("Added" + namet.size());
//                                    member_namest = new String[namet.size()];
//                                    statuest = new String[namet.size()];
//                                    timet = new String[namet.size()];
//                                    authort = new String[autht.size()];
//                                    for (int i = 0; i < namet.size(); i++) {
//
//
//                                        System.out.println("title is " + namet.get(i));
//                                        member_namest[i] = namet.get(i);
//                                        statuest[i] = categt.get(i);
//                                        timet[i] = datest.get(i);
//                                        authort[i] = autht.get(i);
//
//                                    }
//
//                                } else {
//                                    flagz = false;
//                                    for (int i = 0; i < textDesc.targetmems.size(); i++) {
//                                        if (CurrentUser.user.equals(textDesc.targetmems.get(i))) {
//                                            flagz = true;
//                                            break;
//                                        }
//                                    }
//                                    if (flagz) {
//                                        flagz = false;
//                                        System.out.println("Image date passed:" + postSnapshot.getKey());
//                                        namet2.add(textDesc.desc);
//                                        categt2.add(textDesc.maincat + " : " + textDesc.subcat);
//                                        datest2.add(textDesc.date);
//                                        autht2.add(textDesc.user);
//
//                                        System.out.println("Added" + namet2.size());
//                                        member_namest2 = new String[namet2.size()];
//                                        statuest2 = new String[namet2.size()];
//                                        timet2 = new String[namet2.size()];
//                                        authort2 = new String[autht2.size()];
//                                        for (int i = 0; i < namet2.size(); i++) {
//
//
//                                            System.out.println("title is " + namet2.get(i));
//                                            member_namest2[i] = namet2.get(i);
//                                            statuest2[i] = categt2.get(i);
//                                            timet2[i] = datest2.get(i);
//                                            authort2[i] = autht2.get(i);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                    if (namet.size() > 0) {
//                        System.out.println("Row cnt is" + member_namest.length);
//                        for (int i = 0; i < member_namest.length; i++) {
//                            RowItem item = new RowItem(member_namest[i],
//                                    R.drawable.doc, statuest[i],
//                                    timet[i], authort[i],"Text");
//                            rowItemst.add(item);
//                            System.out.println("mangatha added" + rowItemst);
//                        }
//
//                        getfiles();
//                        RepContent.grpcontent=new ArrayList<RowItem>(grpcontent);
//                        CustomAdapter adapter = new CustomAdapter(getActivity(), grpcontent);
//                        Repgroup_tab.setContent(adapter);
//                        //  profile_pics.recycle();
//
//                    }
//                    if (namet2.size() > 0) {
//                        System.out.println("Row cnt is" + member_namest2.length);
//                        for (int i = 0; i < member_namest2.length; i++) {
//                            RowItem item = new RowItem(member_namest2[i],
//                                    R.drawable.doc, statuest2[i],
//                                    timet2[i], authort2[i],"Text");
//                            rowItemst2.add(item);
//                            System.out.println("mangatha added" + rowItemst2);
//                        }
//                        getfiles();
//                        RepContent.percontent=new ArrayList<RowItem>(percontent);
//                        CustomAdapter adapter = new CustomAdapter(getActivity(), percontent);
//                        Repindi_tab.setContent(adapter);
//
//                    }
//
//
//                    }
//
//                @Override
//                public void onCancelled(FirebaseError firebaseError) {
//                    System.out.println("FIREBASE ERROR OCCOURED");
//                }
//            });
//
//
//            return "SUCCESS";
//
//
//        }
//
//
//        // This runs in UI when background thread finishes
//        @Override
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//            if (result.equals("SUCCESS")) {
//                System.out.println("SUCCESS");
//
//
//                imgprog.dismiss();
//                // Do things like hide the progress bar or change a TextView
//            }
//        }
//
//
//        public boolean checkdate(String date) {
//            System.out.println("Comparing date:" + date + "with " + sfrom + "and" + sto);
//            if (sfrom.compareTo(date) <= 0 && date.compareTo(sto) <= 0) {
//                return true;
//            }
//            if(sfrom==null||sto==null)
//            {
//                return true;
//            }
//            return false;
//        }
//
//    }
//    public void getfiles()
//    {
//        grpcontent = new ArrayList<>();
//        grpcontent.addAll(rowItemsi);
//        grpcontent.addAll(rowItemsa);
//        grpcontent.addAll(rowItemsv);
//        grpcontent.addAll(rowItemsf);
//        grpcontent.addAll(rowItemst);
//        System.out.println("Grp list size is:"+grpcontent.size());
//        Collections.sort(grpcontent, new Comparator<RowItem>() {
//            @Override
//            public int compare(RowItem lhs, RowItem rhs) {
//                return rhs.getTime().compareTo(lhs.getTime());
//            }
//        });
//        percontent = new ArrayList<>();
//        percontent.addAll(rowItemsi2);
//        percontent.addAll(rowItemsa2);
//        percontent.addAll(rowItemsv2);
//        percontent.addAll(rowItemsf2);
//        percontent.addAll(rowItemst2);
//        System.out.println("Grp list size is:"+grpcontent.size());
//        Collections.sort(percontent, new Comparator<RowItem>() {
//            @Override
//            public int compare(RowItem lhs, RowItem rhs) {
//                return rhs.getTime().compareTo(lhs.getTime());
//            }
//        });
//    }
//}