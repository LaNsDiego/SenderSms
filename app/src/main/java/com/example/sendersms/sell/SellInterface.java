package com.example.sendersms.sell;

import com.example.sendersms.product.ProductModel;

public interface SellInterface {
    interface ItemListener{
        void onClickItem(ProductModel objProduct);
    }
}
