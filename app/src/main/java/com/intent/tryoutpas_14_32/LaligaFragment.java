package com.intent.tryoutpas_14_32;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaligaFragment extends Fragment {

    RecyclerView rvLaliga;
    ProgressBar pbLaliga;

    List<ModelClass> teamList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laliga, container, false);

        pbLaliga = view.findViewById(R.id.pbLaliga);
        rvLaliga = view.findViewById(R.id.rvLaliga);
        rvLaliga.setHasFixedSize(true);

        rvLaliga.setLayoutManager(new LinearLayoutManager(getContext()));


        //Hit Api
        APIService apiService = APIClient.getClient().create(APIService.class);
        Call<TeamResponse> call = apiService.getModelClassesSpain();

        call.enqueue(new Callback<TeamResponse>() {

            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    rvLaliga.setVisibility(View.VISIBLE);
                    pbLaliga.setVisibility(View.GONE);
                    List<ModelClass> teamList = response.body().getTeams();
                    RvLaligaAdapter adapter = new RvLaligaAdapter(LaligaFragment.this, teamList);
                    rvLaliga.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable throwable) {
                Toast.makeText(getContext(), "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
