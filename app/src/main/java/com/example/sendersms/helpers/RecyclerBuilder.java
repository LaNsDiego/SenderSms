package com.example.sendersms.helpers;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class RecyclerBuilder {
    public static void build(
            RecyclerView recycler,
            RecyclerView.Adapter adapter
    ){
        LinearLayoutManager llms = new LinearLayoutManager(recycler.getContext());
        llms.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                recycler.getContext(),
                llms.getOrientation()
        );
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(dividerItemDecoration);
        recycler.setLayoutManager(llms);
        recycler.setAdapter(adapter);
    }

    public static void buildWithLayoutGrid(
            RecyclerView recycler,
            RecyclerView.Adapter adapter,
            int countGrid
    ){
        GridLayoutManager glm = new GridLayoutManager(recycler.getContext(),countGrid,GridLayoutManager.VERTICAL ,false);
        recycler.setLayoutManager(glm);
        recycler.setAdapter(adapter);
    }
}
