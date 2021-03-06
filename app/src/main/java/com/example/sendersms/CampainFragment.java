package com.example.sendersms;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import 	android.telephony.SmsManager;

import com.example.sendersms.contact.ContactAdapter;
import com.example.sendersms.contact.ContactModel;
import com.example.sendersms.contact.SenderSMSWorker;
import com.example.sendersms.helpers.NotificationBuilder;
import com.example.sendersms.helpers.RecyclerBuilder;
import com.example.sendersms.kardex.KardexAdapter;
import com.example.sendersms.kardex.KardexModel;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

public class CampainFragment extends Fragment {
    List<ContactModel> listContact;
    final Random random = new Random();
    private static final int RESULT_OK = 25;
    private static final int REQUEST_CODE_XLSX = 10;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 100;
    private static final String TAG = "FF";
    private View root;
    TextInputEditText tieMessageCampain;
    Uri uriXlsx;
    String stringPhones = "";
    String stringsIds = "";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_campain, container, false);
        tieMessageCampain = root.findViewById(R.id.tie_message_campain);
        ExtendedFloatingActionButton fabCargarArchivo = root.findViewById(R.id.fab_cargar_archivo);
        root.findViewById(R.id.btn_send_campain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCampain();
            }
        });
        listContact = new ArrayList<>();
        fabCargarArchivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("text/plain");
                startActivityForResult(intent, REQUEST_CODE_XLSX);
            }
        });
        checkPermission();
        return root;
    }



    protected void checkPermission() {
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    private void renderListContact(List<ContactModel> list){
        ContactAdapter adapterContact = new ContactAdapter(list);
        RecyclerView recyclerContact = root.findViewById(R.id.recycler_contact);
        RecyclerBuilder.build(recyclerContact,adapterContact);
    }

    private void startCampain(){
        final Data myData = new Data.Builder()
                .putString("KEY_ARRAY_PHONE",stringPhones)
                .putString("KEY_ARRAY_IDS",stringsIds)
                .putString("KEY_MESSAGE",tieMessageCampain.getText().toString())
                .build();

        OneTimeWorkRequest senderWorker = new OneTimeWorkRequest.Builder(SenderSMSWorker.class)
                .setInputData(myData)
                .build();
        final Operation enqueue = WorkManager.getInstance(getContext()).enqueue(senderWorker);
        Toast.makeText(getContext(), "Mensajes en proceso", Toast.LENGTH_SHORT).show();
    }

    public void readExcelFileFromAssets(Uri uriXlsx) {
        try {
          InputStream stream = getContext().getContentResolver().openInputStream(uriXlsx);
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = br.readLine()) != null) {
                ContactModel contact = new ContactModel();

                contact.setId(random.nextInt()+"");
                contact.setNumberPhone(line.trim());
                listContact.add(contact);
                stringPhones +=  contact.getNumberPhone()+",";
                stringsIds += contact.getId()+",";
            }
            stringPhones = new StringBuilder(stringPhones).deleteCharAt(stringPhones.length() - 1).toString();
            stringsIds = new StringBuilder(stringsIds).deleteCharAt(stringsIds.length() - 1).toString();
            Log.d("GA_S",stringPhones);
            Log.d("GA_S",stringsIds);
            renderListContact(listContact);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {

            case REQUEST_CODE_XLSX:

//                if (resultCode == RESULT_OK) {
                    try {
                        uriXlsx = data.getData();
                        readExcelFileFromAssets(uriXlsx);
                        Toast.makeText(getContext(), uriXlsx.toString(), Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Toast.makeText(getContext(), "NO SELECIONADO", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

//                }
                break;

        }

    }


}