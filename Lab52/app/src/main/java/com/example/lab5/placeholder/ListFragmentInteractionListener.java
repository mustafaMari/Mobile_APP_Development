package com.example.lab5.placeholder;

import com.example.lab5.placeholder.ItemData;

import java.util.List;

public interface ListFragmentInteractionListener {
    void onDeleteItem(ItemData itemData);
    List<ItemData> getRepositoryList();
}
