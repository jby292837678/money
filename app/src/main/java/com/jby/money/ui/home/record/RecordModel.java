package com.jby.money.ui.home.record;

import android.os.Bundle;
import android.view.View;

import com.binding.model.adapter.IEventAdapter;
import com.binding.model.layout.recycler.RecyclerModel;
import com.binding.model.model.ModelView;
import com.jby.money.R;
import com.jby.money.databinding.FragmentRecordBinding;
import com.jby.money.inject.data.sql.DatabaseApi;
import com.jby.money.inject.data.sql.JournalEntity;

import javax.inject.Inject;

@ModelView(R.layout.fragment_record)
public class RecordModel extends RecyclerModel<RecordFragment, FragmentRecordBinding, JournalEntity> {
    @Inject RecordModel() { }
    @Inject DatabaseApi databaseApi;
    @Override
    public void attachView(Bundle savedInstanceState, RecordFragment fragment) {
        super.attachView(savedInstanceState, fragment);
//        setRcHttp((offset1, refresh) -> databaseApi.getJournalEntity());

    }

    public void onAddClick(View view) {
        JournalEntity entity = new JournalEntity();
        entity.setCurrentTimeMillis(System.currentTimeMillis());
        entity.save();
        getAdapter().addToAdapter(IEventAdapter.NO_POSITION, entity);
    }

    public void onDeleteClick(View view) {
        JournalEntity entity = getAdapter().getList().get(0);
        entity.delete();
        getAdapter().removeToAdapter(IEventAdapter.NO_POSITION, entity);
    }

    public void onRefreshClick(View view) {
        onHttp(3);
    }


}
