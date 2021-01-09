package com.example.sendersms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import 	android.telephony.SmsManager;

import com.example.sendersms.contact.ContactAdapter;
import com.example.sendersms.contact.ContactModel;
import com.example.sendersms.kardex.KardexAdapter;
import com.example.sendersms.kardex.KardexModel;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CampainFragment extends Fragment {

    static {
        System.setProperty(
                "org.apache.poi.javax.xml.stream.XMLInputFactory",
                "com.fasterxml.aalto.stax.InputFactoryImpl"
        );
        System.setProperty(
                "org.apache.poi.javax.xml.stream.XMLOutputFactory",
                "com.fasterxml.aalto.stax.OutputFactoryImpl"
        );
        System.setProperty(
                "org.apache.poi.javax.xml.stream.XMLEventFactory",
                "com.fasterxml.aalto.stax.EventFactoryImpl"
        );
    }

    private static final int RESULT_OK = 25;
    private static final int REQUEST_CODE_XLSX = 10;
    private TextView textView;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 100;
    private static final String TAG = "FF";
    private View root;
    EditText edtPhoneNumber , edtMessage;
    Uri uriXlsx;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_campain, container, false);
        textView = root.findViewById(R.id.textview);
        edtMessage =  root.findViewById(R.id.edt_message);
        ExtendedFloatingActionButton fabCargarArchivo = root.findViewById(R.id.fab_cargar_archivo);
        root.findViewById(R.id.btn_send_campain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(CampainFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                smsSendMessage(edtPhoneNumber.getText().toString() , edtMessage.getText().toString());
            }
        });

        List<ContactModel> listContact;
        listContact = new ArrayList<>();
        listContact.add(new ContactModel());
        listContact.add(new ContactModel());
        listContact.add(new ContactModel());
        listContact.add(new ContactModel());
        listContact.add(new ContactModel());
        listContact.add(new ContactModel());
        ContactAdapter adapterContact = new ContactAdapter(listContact);


        RecyclerView recyclerContact = root.findViewById(R.id.recycler_contact);
        LinearLayoutManager llms = new LinearLayoutManager(getContext());
        llms.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerContact.getContext(),
                llms.getOrientation());
        recyclerContact.addItemDecoration(dividerItemDecoration);
        recyclerContact.setLayoutManager(llms);
        recyclerContact.setAdapter(adapterContact);

        fabCargarArchivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("application/xlsx");
                intent.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
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

    public void smsSendMessage(String phoneNumber , String mensaje) {

        SmsManager
                .getDefault()
                .sendTextMessage(phoneNumber, null,
                        mensaje,
                        null, null);
    }

    public void readExcelFileFromAssets(Uri uriXlsx) {
        try {

          InputStream stream = getContext().getContentResolver().openInputStream(uriXlsx);

            // Create a workbook using the File System
            XSSFWorkbook myWorkBook = new XSSFWorkbook (stream);

            // Get the first sheet from workbook
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);

            // We now need something to iterate through the cells.
            Iterator<Row> rowIter = mySheet.rowIterator();
            int rowno =0;
            textView.append("\n");
            while (rowIter.hasNext()) {
                Log.e(TAG, " row no "+ rowno );
                XSSFRow myRow = (XSSFRow) rowIter.next();
                if(rowno !=0) {
                    Iterator<Cell> cellIter = myRow.cellIterator();
                    int colno =0;
                    String sno="", date="", det="";
                    while (cellIter.hasNext()) {
                        XSSFCell myCell = (XSSFCell) cellIter.next();
                        if (colno==0){
                            sno = myCell.toString();
                        }else if (colno==1){
                            date = myCell.toString();
                        }else if (colno==2){
                            det = myCell.toString();
                        }
                        colno++;
                        Log.e(TAG, " Index :" + myCell.getColumnIndex() + " -- " + myCell.toString());
                    }
                    textView.append( sno + " -- "+ date+ "  -- "+ det+"\n");
                }
                rowno++;
            }
        } catch (Exception e) {
            Log.e(TAG, "error "+ e.toString());
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