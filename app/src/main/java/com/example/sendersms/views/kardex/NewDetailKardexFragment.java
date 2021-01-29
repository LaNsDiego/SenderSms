package com.example.sendersms.views.kardex;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sendersms.R;
import com.example.sendersms.firebase.Firestore;
import com.example.sendersms.helpers.RecyclerBuilder;
import com.example.sendersms.kardex.KardexModel;
import com.example.sendersms.kardexdetail.ItemDetailKardexAdapter;
import com.example.sendersms.kardexdetail.KardexDetailModel;
import com.example.sendersms.product.ProductModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;
import java.util.List;

public class NewDetailKardexFragment extends Fragment {

    View root;
    MaterialAutoCompleteTextView matTypeOperation , matTypeProof;
    TextInputEditText tieSerie , tieNumbeProof,tieQuantity,tiePrice,tieSubtotal,tieName;
    MaterialButton btnAddDetailKardex;
    TextView txvSubTotal;
    KardexModel objKardex;
    List<ProductModel> products;
    RecyclerView recyclerProducts;
    ItemDetailKardexAdapter adapterItemDetailKardex;
    public NewDetailKardexFragment() {
        // Required empty public constructor
    }

    public static NewDetailKardexFragment newInstance() {
        NewDetailKardexFragment fragment = new NewDetailKardexFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        objKardex = (KardexModel) getArguments().getSerializable("objKardex");
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_new_detail_kardex, container, false);
        recyclerProducts = root.findViewById(R.id.recycler_temp_detail_kardex);
        products = new ArrayList<>();
        render(products);
        //FAB
        FloatingActionButton fabSaveDetail = root.findViewById(R.id.btn_create_new_detail_kardex);
        fabSaveDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDetailKardex();
            }
        });
        //Form Head
        matTypeOperation = root.findViewById(R.id.mat_type_operation);
        matTypeProof = root.findViewById(R.id.mat_type_proof);
        tieSerie = root.findViewById(R.id.tie_serie);
        tieNumbeProof = root.findViewById(R.id.tie_number_proof);

        String[] typeOperations = new String[]{"COMPRA","VENTA","DEVOLUCION","TRASLADO"};
        ArrayAdapter<String> adapterTypeOperation = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,typeOperations);
        matTypeOperation.setAdapter(adapterTypeOperation);

        String[] matTypeVouchers = new String[]{"BOLETA","FACTURA"};
        ArrayAdapter<String> adapterMatTypeProof = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,matTypeVouchers);
        matTypeProof.setAdapter(adapterMatTypeProof);
        //Form detail
        btnAddDetailKardex = root.findViewById(R.id.btn_add_detail_kardex);
        tieQuantity = root.findViewById(R.id.tie_quantity);
        tiePrice = root.findViewById(R.id.tie_price);
        tieName = root.findViewById(R.id.tie_name);
        txvSubTotal = root.findViewById(R.id.txv_subtotal);

        btnAddDetailKardex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ProductModel objProduct = new ProductModel();
                    objProduct.setName(tieName.getText().toString());
                    objProduct.setPrice(Double.valueOf(tiePrice.getText().toString()));
                    objProduct.setQuantity(Integer.valueOf(tieQuantity.getText().toString()));
                    addItemDetailKardex(objProduct);
                    tieQuantity.setText("");
                    tieName.setText("");
                    tiePrice.setText("");
                    tieSubtotal.setText("S/. 0.0");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        return root;
    }


    private void createDetailKardex(){
        final DocumentReference newDocDetailKardex = Firestore.getCollectionKardex().document(objKardex.getId()).collection("detail").document();
        KardexDetailModel objDetailKardex = new KardexDetailModel();
        objDetailKardex.setId(newDocDetailKardex.getId());
        objDetailKardex.setNumberProof(tieNumbeProof.getText().toString());
        objDetailKardex.setSerie(tieSerie.getText().toString());
        objDetailKardex.setTypeOperation(matTypeOperation.getText().toString());
        objDetailKardex.setTypeProof(matTypeProof.getText().toString());
        objDetailKardex.setProducts(products);
        newDocDetailKardex.set(objDetailKardex)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getContext(), "Detail created.", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Ocurrio un error.", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }

    private void render(List<ProductModel> listProduct){
        adapterItemDetailKardex  = new ItemDetailKardexAdapter(listProduct);
        RecyclerBuilder.build(recyclerProducts,adapterItemDetailKardex);
    }

    private void addItemDetailKardex(ProductModel objProduct){
        adapterItemDetailKardex.addItemDetail(objProduct);
        adapterItemDetailKardex.notifyDataSetChanged();
    }
}