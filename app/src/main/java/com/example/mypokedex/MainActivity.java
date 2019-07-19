package com.example.mypokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.algolia.instantsearch.helpers.InstantSearch;
import com.algolia.instantsearch.helpers.Searcher;

public class MainActivity extends AppCompatActivity {
    private static final String ALGOLIA_APP_ID = "R5B2117XAJ";
    private static final String ALGOLIA_SEARCH_API_KEY = "3293bc4a8671581c518aaac4214b9b63";
    private static final String ALGOLIA_INDEX_NAME = "pokedex";

    Searcher searcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searcher = Searcher.create(ALGOLIA_APP_ID, ALGOLIA_SEARCH_API_KEY, ALGOLIA_INDEX_NAME);
        InstantSearch helper = new InstantSearch(this, searcher);
        helper.search();
    }

    @Override
    protected void onDestroy() {
        searcher.destroy();
        super.onDestroy();
    }
}