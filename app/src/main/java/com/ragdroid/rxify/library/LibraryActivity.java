package com.ragdroid.rxify.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.fueled.reclaim.ItemsViewAdapter;
import com.ragdroid.rxify.BaseActivity;
import com.ragdroid.rxify.R;
import com.ragdroid.rxify.core.list.BookItem;
import com.ragdroid.rxify.dagger.ActivityComponent;
import com.ragdroid.rxify.entity.Book;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public final class LibraryActivity extends BaseActivity<LibraryContract.Presenter> implements LibraryContract.View {

    @BindView(R.id.lib_fix_bug) FloatingActionButton fab;
    @BindView(R.id.lib_search_view) SearchView searchView;
    @BindView(R.id.lib_books_list) RecyclerView recyclerView;

    private ItemsViewAdapter adapter;

    private SearchView.OnQueryTextListener textListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            presenter.onQueryTextChange(newText);
            return true;
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_library;
    }

    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        searchView.setOnQueryTextListener(textListener);
    }

    @Override
    protected void setupActivity(@Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecoration);

        adapter = new ItemsViewAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.lib_fix_bug)
    public void onFixBugToggleClicked() {
        searchView.setQuery("", false);
        presenter.onFixBugToggleClicked();
        toggleFixBugToggle(presenter.isAutoSearch());
    }

    private void toggleFixBugToggle(boolean autoSearch) {
        if (autoSearch) {
            fab.setImageResource(R.drawable.ic_bugit);
        } else {
            fab.setImageResource(R.drawable.ic_fixit);
        }
    }

    @Override
    public void showBooks(List<Book> books) {
        adapter.clearAllRecyclerItems();
        List<BookItem> bookItems = new ArrayList<>();
        for (Book book : books) {
            BookItem bookItem = new BookItem(book, null);
            bookItems.add(bookItem);
        }
        adapter.addItemsList(bookItems);
    }
}
