package com.example.lab5;

import com.example.lab5.Entitiy.ItemData;

import java.util.List;

public interface ListFragmentInteractionListener {
    void onDeleteItem(ItemData itemData);
    List<ItemData> getRepositoryList();
}
