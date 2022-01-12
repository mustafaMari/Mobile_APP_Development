package com.example.lab5.Placeholder;

import java.util.List;

public interface ListFragmentInteractionListener {
    void onDeleteItem(ItemData itemData);
    List<ItemData> getRepositoryList();
}
