package me.viper.viperarch.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import me.viper.viperarch.R;
import me.viper.viperarch.data.DataManager;
import me.viper.viperarch.ui.base.DiActivity;
import me.viper.viperarch.ui.base.viper.Assembler;
import me.viper.viperarch.ui.base.viper.IBasePresenter;
import me.viper.viperarch.ui.main.interactor.MainInteractor;
import me.viper.viperarch.ui.main.presenter.MainPresenter;
import me.viper.viperarch.ui.main.router.MainRouter;
import me.viper.viperarch.ui.main.view.MainViewModel;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends DiActivity{


    @Inject
    MainPresenter presenter;
    @Inject
    MainRouter router;
    @Inject
    MainInteractor interactor;
    @Inject
    MainViewModel viewModel;
    @Inject
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Button btn = findViewById(R.id.click);
        Button btn2 = findViewById(R.id.click2);
        TextView txt = findViewById(R.id.textView);
        btn.setOnClickListener(view -> presenter.setData());
        btn2.setOnClickListener(view -> navigate());

        presenter.getViewModel().getUser().observe(this, newName -> {
            txt.setText(newName.getUserName()+"\n"+newName.getPhoneNumber());
        });

    }
    public void navigate(){
        presenter.navigate(this,SecondActivity.class);
    }

    @Override
    protected Assembler.Builder provideAssemblerBuilder() {
        return new Assembler.Builder()
                .view(viewModel)
                .router(router)
                .presenter(presenter)
                .interactor(interactor)
                .dataManager(dataManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getData();
    }
}
