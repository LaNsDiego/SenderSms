package com.example.sendersms.views.sell;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sendersms.R;
import com.example.sendersms.helpers.RecyclerBuilder;
import com.example.sendersms.product.ProductModel;
import com.example.sendersms.sell.SellAdapter;
import com.example.sendersms.sell.SellInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SellFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SellFragment extends Fragment implements SellInterface.ItemListener {
    View root;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SellFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SellFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SellFragment newInstance(String param1, String param2) {
        SellFragment fragment = new SellFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        List<ProductModel> listProduct = new ArrayList<>();
        ProductModel p1 = new ProductModel();p1.setName("Producto1");
        ProductModel p2 = new ProductModel();p2.setName("Producto2");
        ProductModel p3 = new ProductModel();p3.setName("Producto3");
        ProductModel p4 = new ProductModel();p4.setName("Producto4");
        ProductModel p5 = new ProductModel();p5.setName("Producto5");
        listProduct.add(p1);
        listProduct.add(p2);
        listProduct.add(p3);
        listProduct.add(p4);
        listProduct.add(p5);
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_sell, container, false);
        RecyclerView recyclerSellProduct = root.findViewById(R.id.recycler_sell_product);
        SellAdapter sellAdapter = new SellAdapter(listProduct,this);
        RecyclerBuilder.buildWithLayoutGrid(recyclerSellProduct,sellAdapter,2);
        return root;
    }

    @Override
    public void onClickItem(ProductModel objProduct) {
        Toast.makeText(getContext(), objProduct.getName(), Toast.LENGTH_SHORT).show();
    }
}